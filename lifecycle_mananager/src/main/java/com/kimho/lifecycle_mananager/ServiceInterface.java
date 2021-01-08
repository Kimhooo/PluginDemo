package com.kimho.lifecycle_mananager;

import android.app.Service;
import android.content.Intent;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/7 11:09
 */
public interface ServiceInterface {
    void insertAppContext(Service hostService);

    void onCreate();

    int onStartCommand(Intent intent,int flags,int startId);

    void onDestroy();

}
