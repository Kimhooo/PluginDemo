package com.kimho.plugindemo;

import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;

import com.kimho.lifecycle_mananager.ServiceInterface;

import androidx.annotation.Nullable;

import static com.kimho.plugindemo.ProxyActivity.EXT_CLASS_NAME;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/6 17:40
 */
public class ProxyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 获取到真正要启动的插件 Service，然后执行 onStartCommand 方法
        String className = intent.getStringExtra(EXT_CLASS_NAME);
        try {
            Class clazz = getClassLoader().loadClass(className);
            ServiceInterface serviceInterface = (ServiceInterface) clazz.newInstance();
            serviceInterface.insertAppContext(this);
            serviceInterface.onStartCommand(intent, flags, startId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance(this).getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance(this).getClassLoader();
    }
}
