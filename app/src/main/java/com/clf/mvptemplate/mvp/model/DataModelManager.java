package com.clf.mvptemplate.mvp.model;

import com.clf.mvptemplate.mvp.model.base.BaseModel;

/**
 * Created by hacker on 2018/2/6.
 */

public class DataModelManager {
    public static BaseModel newInstance(String className){
        // 声明一个空的BaseModel
        BaseModel model = null;
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel)Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
