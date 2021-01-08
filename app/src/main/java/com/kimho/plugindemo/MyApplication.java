package com.kimho.plugindemo;

import android.app.Application;
import android.content.Context;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:42
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(base);
        mContext = base;
    }
}