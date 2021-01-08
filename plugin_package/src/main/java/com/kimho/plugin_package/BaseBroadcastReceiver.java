package com.kimho.plugin_package;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kimho.lifecycle_mananager.BroadcastReceiverInterface;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:25
 */
public class BaseBroadcastReceiver extends BroadcastReceiver implements BroadcastReceiverInterface {
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}