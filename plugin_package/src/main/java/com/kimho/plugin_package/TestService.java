package com.kimho.plugin_package;

import android.content.Intent;
import android.widget.Toast;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:36
 */
public class TestService extends BaseService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(mAppService, "TestService 已经启动...", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}