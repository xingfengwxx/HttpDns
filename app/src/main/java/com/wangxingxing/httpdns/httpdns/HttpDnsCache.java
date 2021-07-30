package com.wangxingxing.httpdns.httpdns;

import android.text.TextUtils;
import android.text.format.Time;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.wangxingxing.httpdns.bean.HttpDnsRes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author : 王星星
 * date : 2021/7/29 15:45
 * email : 1099420259@qq.com
 * description :
 */
public class HttpDnsCache {

    public static String mHttpDnsServerIP = "203.107.1.33";
    public static final int RETRY_TIMES = 2;

    private static HttpDnsCache instance;

    private String[] mHosts;
    private Map<String, HttpDnsRes.DnsBean> mDnsCache = new HashMap<>();
    private OkHttpClient mOkHttpClient;

    private int mAccountID;
    private int mRetryTimes = 0;
    private boolean mPreLoadSync = false;

    private HttpDnsCache() {
    }

    public static HttpDnsCache getInstance() {
        if (instance == null) {
            synchronized (HttpDnsCache.class) {
                if (instance == null) {
                    instance = new HttpDnsCache();
                }
            }
        }
        return instance;
    }

    /**
     *
     * 初始化accountID，域名解析列表
     *
     * @param accountID ali dns accountID
     * @param hosts httpDNS 解析域名列表
     */
    public void init(int accountID, String... hosts) {
        mAccountID = accountID;
        mHosts = hosts;

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 首次同步加载 http://203.107.1.33/191607/resolve?host=app.bilibili.com,api.bilibili.com
     *
     * maxSize = 5
     */
    public boolean loadDnsCache() {
        if (mHosts == null || mHosts.length == 0)
            throw new NullPointerException("preload dns, hostname can not be null or empty");

        //选择http 或 https
        StringBuilder httpDnsUrl = new StringBuilder("http://" + mHttpDnsServerIP + "/" + mAccountID);

        if (mHosts.length == 1) {
            httpDnsUrl.append("/d?host=").append(mHosts[0]);
        } else {
            httpDnsUrl.append("/resolve?host=");
            for (String hostname : mHosts) {
                httpDnsUrl.append(hostname).append(",");
            }
            httpDnsUrl.deleteCharAt(httpDnsUrl.length() - 1);
        }

        Request request = new Request.Builder()
                .url(httpDnsUrl.toString())
                .build();

        if (mPreLoadSync) {
            return requestCacheSync(request);
        } else {
            requestCache(request);
            return true;
        }
    }

    private boolean requestCacheSync(Request request) {
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            return handleResponse(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(e.getMessage());
            return false;
        }
    }

    private void requestCache(Request request) {
        mRetryTimes++;
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                if (mRetryTimes < RETRY_TIMES) {
                    requestCache(request);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handleResponse(request, response);
            }
        });
    }

    private boolean handleResponse(Request request, Response response) throws IOException {
        if (response.isSuccessful()) {
            String res = response.body().string();

            if (request.url().encodedPath().contains("d")) {
                HttpDnsRes.DnsBean dnsBean = new Gson().fromJson(res, HttpDnsRes.DnsBean.class);
                saveCache(dnsBean);
            } else if (request.url().encodedPath().contains("resolve")){
                HttpDnsRes httpDnsRes = new Gson().fromJson(res, HttpDnsRes.class);
                if (httpDnsRes.getDns().size() == 0)
                    throw new NullPointerException("dns resolved return null");

                for (HttpDnsRes.DnsBean bean : httpDnsRes.getDns()) {
                    saveCache(bean);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private void saveCache(HttpDnsRes.DnsBean dnsBean) {
        mDnsCache.put(dnsBean.getHost(), dnsBean);
    }

    /**
     * 异步解析接口
     * 1. 查询注册的DNS解析列表，若未注册返回null
     * 2. 查询缓存，若存在且未过期则返回结果，若不存在返回null并且进行异步域名解析更新缓存。
     * 3. 若接口返回null，，为避免影响业务请降级到local dns解析策略。
     *
     * @param hostname 域名(如www.aliyun.com)
     * @return 域名对应的解析结果
     */
    public String getIpByHostAsync(String hostname) {
        if (mHosts == null || mHosts.length == 0)
            return null;

        for (String host : mHosts) {
            if (TextUtils.equals(host, hostname)) {
                if (mDnsCache == null || mDnsCache.isEmpty()) {
                    updateIpByHostAsync(hostname);
                    //无缓存
                    return null;
                } else {
                    HttpDnsRes.DnsBean dnsBean = mDnsCache.get(hostname);
                    if (dnsBean != null) {
                        long timeSpan = Math.abs(System.currentTimeMillis() - dnsBean.getTime());
                        if (timeSpan < dnsBean.getTtl() * 1000) {
                            if (!dnsBean.getIps().isEmpty()) {
                                //正确返回缓存ip
                                return dnsBean.getIps().get(0);
                            } else {
                                //无缓存
                                return null;
                            }
                        } else {
                            updateIpByHostAsync(dnsBean.getHost());
                            //缓存过期
                            return null;
                        }
                    } else {
                        updateIpByHostAsync(hostname);
                        //无缓存
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 更新DNS缓存
     *
     * @param hostname
     */
    private void updateIpByHostAsync(String hostname) {
        //选择http 或 https
        Request request = new Request.Builder()
                .url("http://" + mHttpDnsServerIP + "/" + mAccountID + "/d?host=" + hostname)
                .build();
        mRetryTimes = 0;
        requestCache(request);
    }

    /**
     * 设置自定义请求超时时间,默认为2S
     *
     * @param timeoutInterval 单位是秒
     */
    public void setTimeoutInterval(int timeoutInterval) {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeoutInterval, TimeUnit.SECONDS)
                .readTimeout(timeoutInterval, TimeUnit.SECONDS)
                .build();
    }

    public void setPreLoadSync(boolean preLoadSync) {
        mPreLoadSync = preLoadSync;
    }

    public static String getHttpDnsServerIP() {
        return mHttpDnsServerIP;
    }

    public static void setHttpDnsServerIP(String httpDnsServerIP) {
        mHttpDnsServerIP = httpDnsServerIP;
    }
}
