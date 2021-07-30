package com.wangxingxing.httpdns;

import com.wangxingxing.httpdns.bean.UpInformationRes;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * author : 王星星
 * date : 2021/7/29 15:35
 * email : 1099420259@qq.com
 * description :
 */
public interface ApiService {

    String BiliBili_API_HOST = "https://app.bilibili.com/";

    @GET("x/space/acc/info?mid=191622&jsonp=jsonp")
    Flowable<UpInformationRes> getUpInformation();

}
