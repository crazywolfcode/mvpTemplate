package com.clf.mvptemplate.mvp.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.clf.mvptemplate.R;
import com.clf.mvptemplate.mvp.presenter.MvpPresenter;
import com.clf.mvptemplate.mvp.ui.activity.base.BaseActivity;
import com.clf.mvptemplate.mvp.ui.view.MvpView;

public class mvpActivity extends BaseActivity implements MvpView, View.OnClickListener {

    private MvpPresenter presenter;

    private TextView loadingTv, infoRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        this.presenter = new MvpPresenter();
        presenter.attachView(this);
        infoRv = (TextView) findViewById(R.id.info);
        loadingTv = (TextView) findViewById(R.id.loading);

        getData();
        infoRv.setOnClickListener(this);
    }

    public void getData() {
        presenter.getData("failure");
    }

    private int index = 1;

    //-------------------------------------View----------------------------------//
    @Override
    public void onClick(View v) {
        if (index > 2) {
            index = 0;
        }
        String param = null;
        if (index == 0) {
            param = "error";
        } else if (index == 2) {
            param = "failure";
        } else {
            param = "normal";

        }
        switch (v.getId()) {
            case R.id.info:
                presenter.getData(param);
                break;
        }
    }
    //-------------------------------------/View----------------------------------//

    //-------------------------------------MvpView----------------------------------//
    @Override
    public void showLoading() {
        Log.i(TAG, "showLoading: ");
        loadingTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        Log.i(TAG, "hideLoading: ");
        loadingTv.setVisibility(View.GONE);
    }

    @Override
    public void showData(Object data) {
        Log.i(TAG, "showData: ");
        infoRv.setText(data.toString());
    }

    @Override
    public void showFailureMessage(String msg) {
        Log.i(TAG, "showFailureMessage: ");
        infoRv.setText(msg);
    }

    @Override
    public void showErrorMessage(String msg) {
        Log.i(TAG, "showErrorMessage: ");
        infoRv.setText(msg);
    }
    //-------------------------------------/MvpView----------------------------------//


    @Override
    protected void onDestroy() {
        this.presenter.detachView();
        super.onDestroy();
    }


}
