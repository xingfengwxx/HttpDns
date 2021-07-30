package com.wangxingxing.httpdns;

import com.wangxingxing.httpdns.httpdns.OkHttpDns;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : 王星星
 * date : 2021/7/29 17:33
 * email : 1099420259@qq.com
 * description :
 */
public class HttpUtils {

    public static final String BASE_URL = "https://api.bilibili.com/";

    private static HttpUtils instance;

    private Retrofit mRetrofit;

    private HttpUtils() {

    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .dns(OkHttpDns.getInstance())
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(interceptor);

            mRetrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    public ApiService getApiService() {
        return getRetrofit().create(ApiService.class);
    }
}
