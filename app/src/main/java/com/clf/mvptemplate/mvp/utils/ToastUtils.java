package com.clf.mvptemplate.mvp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hacker on 2018/2/6.
 */

public class ToastUtils {

    public static void showShortMessage(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

    public static void showLongMessage(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
