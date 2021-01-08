package com.kimho.plugin_package;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:36
 */
public class TestReceiver extends BaseBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "TestReceiver onReceiver 回调完成", Toast.LENGTH_SHORT).show();
        super.onReceive(context, intent);
    }

}