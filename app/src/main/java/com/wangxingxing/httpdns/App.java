package com.wangxingxing.httpdns;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.elvishew.xlog.XLog;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.wangxingxing.httpdns.httpdns.HttpDnsCache;

/**
 * author : 王星星
 * date : 2021/7/29 15:30
 * email : 1099420259@qq.com
 * description :
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        XLog.init();
        Logger.addLogAdapter(new AndroidLogAdapter());

        HttpDnsCache dnsCache = HttpDnsCache.getInstance();
        dnsCache.init(191607, "app.bilibili.com", "api.bilibili.com");
        dnsCache.loadDnsCache();
    }
}
