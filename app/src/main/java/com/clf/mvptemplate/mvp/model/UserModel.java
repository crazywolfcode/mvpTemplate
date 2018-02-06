package com.clf.mvptemplate.mvp.model;

import android.os.Handler;

import com.clf.mvptemplate.mvp.model.base.BaseModel;
import com.clf.mvptemplate.mvp.model.callback.MvpCallback;


/**
 * Created by clf on 2018/2/6.
 */

public class UserModel extends BaseModel {
    @Override
    public void execute(final MvpCallback callback) {
        // 模拟网络请求耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mParams 是从父类得到的请求参数
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError("error");
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }
}
