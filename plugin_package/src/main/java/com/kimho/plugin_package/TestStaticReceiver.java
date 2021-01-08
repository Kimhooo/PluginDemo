package com.kimho.plugin_package;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:38
 */
public class TestStaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "TestStaticReceiver onReceive 回调完成", Toast.LENGTH_SHORT).show();
    }
}