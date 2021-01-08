package com.kimho.plugindemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kimho.lifecycle_mananager.BroadcastReceiverInterface;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/6 17:46
 */
public class ProxyReceiver extends BroadcastReceiver {

    private String mReceiverName;

    public ProxyReceiver(String receiverName) {
        mReceiverName = receiverName;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Class clazz = null;
        try{
            clazz = PluginManager.getInstance(context).getClassLoader().loadClass(mReceiverName);
            BroadcastReceiverInterface receiverInterface =(BroadcastReceiverInterface) clazz.newInstance();
            receiverInterface.onReceive(context,intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}