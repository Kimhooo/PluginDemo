package com.kimho.plugindemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;

import com.kimho.lifecycle_mananager.ActivityInterface;

import androidx.annotation.Nullable;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/6 16:54
 */
public class ProxyActivity extends Activity {
    public static final String EXT_CLASS_NAME = "ext_class_name";
    public static final String EXT_ACTION = "ext_action";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取到真正要启动的插件Activity，然后执行onCreate方法
        String className = getIntent().getStringExtra(EXT_CLASS_NAME);
        try {
            Class clazz = getClassLoader().loadClass(className);
            ActivityInterface activityInterface = (ActivityInterface) clazz.newInstance();
            activityInterface.insertAppContext(this);
            activityInterface.onCreate(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return PluginManager.getInstance(this).getResources();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance(this).getClassLoader();
    }

    @Override
    public void startActivity(Intent intent) {
        String className = intent.getStringExtra(EXT_CLASS_NAME);
        Intent proxyIntent = new Intent(this, ProxyActivity.class);
        proxyIntent.putExtra(EXT_CLASS_NAME, className);
        super.startActivity(proxyIntent);
    }

    @Override
    public ComponentName startService(Intent intent) {
        String className = intent.getStringExtra(EXT_CLASS_NAME);
        Intent proxtIntent = new Intent(this, ProxyService.class);
        proxtIntent.putExtra(EXT_CLASS_NAME, className);
        return super.startService(proxtIntent);
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter intentFilter) {
        String receiverName = receiver.getClass().getName();
        return super.registerReceiver(new ProxyReceiver(receiverName), intentFilter);
    }

    @Override
    public void sendBroadcast(Intent intent) {
        super.sendBroadcast(intent);
    }
}