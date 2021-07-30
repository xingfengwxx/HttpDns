package com.wangxingxing.httpdns.httpdns;

import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Dns;

/**
 * author : 王星星
 * date : 2021/7/29 15:40
 * email : 1099420259@qq.com
 * description :
 */
public class OkHttpDns implements Dns {

    private static OkHttpDns instance;

    private HttpDnsCache mDnsCache = HttpDnsCache.getInstance();

    private OkHttpDns() {
    }

    public static OkHttpDns getInstance() {
        if (instance == null) {
            synchronized (OkHttpDns.class) {
                if (instance == null) {
                    instance = new OkHttpDns();
                }
            }
        }
        return instance;
    }

    @Override
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        String ip = mDnsCache.getIpByHostAsync(hostname);
        LogUtils.d("DnsCache IP:" + ip);

        if (ip != null) {
            //如果ip不为null，直接使用该ip进行网络请求
            return Arrays.asList(InetAddress.getAllByName(ip));
        }
        //如果返回null，走系统DNS服务解析域名
        return Dns.SYSTEM.lookup(hostname);
    }
}
