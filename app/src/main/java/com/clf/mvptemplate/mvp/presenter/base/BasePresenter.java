package com.clf.mvptemplate.mvp.presenter.base;

import com.clf.mvptemplate.mvp.ui.view.BaseView;

/**
 * Created by hacker on 2018/2/6.
 */

public abstract class BasePresenter<T> {

    public T mView;
    public BasePresenter() {
        //构造方法中不再需要View参数
    }

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public abstract void attachView(T  view);

    /**
     * 断开view，一般在onDestroy中调用
     */
    public abstract void detachView();

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mView!= null;
    }

    /**
     * 获取网络数据
     * @param params 参数
     */
    public abstract void getData(String params);
}
