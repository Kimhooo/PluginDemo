package com.kimho.plugin_package;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.kimho.lifecycle_mananager.ServiceInterface;

import androidx.annotation.Nullable;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:25
 */
public class BaseService extends Service implements ServiceInterface {

    public Service mAppService;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void insertAppContext(Service hostService) {
        mAppService = hostService;
    }

    @Override
    public void onCreate() {

    }

    @SuppressLint("WrongConstant")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 0;
    }

    @Override
    public void onDestroy() {

    }

}