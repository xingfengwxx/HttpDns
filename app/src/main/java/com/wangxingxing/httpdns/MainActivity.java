package com.wangxingxing.httpdns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.wangxingxing.httpdns.bean.UpInformationRes;
import com.wangxingxing.httpdns.databinding.ActivityMainBinding;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        init();
    }

    private void init() {
        mBinding.btnGetData.setOnClickListener(v -> {
            getData();
        });
    }

    private void getData() {
        HttpUtils.getInstance()
                .getApiService()
                .getUpInformation()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<UpInformationRes>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(1);
                    }

                    @Override
                    public void onNext(UpInformationRes upInformationRes) {
                        LogUtils.json(upInformationRes);
                        mBinding.tvContent.setText(GsonUtils.toJson(upInformationRes));
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtils.e(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        }

}