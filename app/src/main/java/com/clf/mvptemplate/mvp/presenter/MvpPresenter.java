package com.clf.mvptemplate.mvp.presenter;

import com.clf.mvptemplate.mvp.model.DataModelManager;
import com.clf.mvptemplate.mvp.model.UserModel;
import com.clf.mvptemplate.mvp.model.callback.MvpCallback;
import com.clf.mvptemplate.mvp.presenter.base.BasePresenter;
import com.clf.mvptemplate.mvp.ui.view.MvpView;

/**
 * Created by clf on 2018/2/6.
 */

public class MvpPresenter extends BasePresenter<MvpView> {

    @Override
    public void attachView(MvpView view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public void getData(String params) {
        if (!isViewAttached()) {
            this.mView.hideLoading();
            return;
        }
        //显示正在加载进度条
        mView.showLoading();
        DataModelManager.newInstance(UserModel.class.getName()).setParams(params).execute(callBack);
    }

    private MvpCallback callBack = new MvpCallback<String>() {

        @Override
        public void onSuccess(String data) {
            mView.showData(data);
        }

        @Override
        public void onError(String msg) {
            mView.showErrorMessage(msg);
        }

        @Override
        public void onFailure(String msg) {
            mView.showFailureMessage(msg);
        }

        @Override
        public void onComplete() {
            mView.hideLoading();
        }
    };
}
