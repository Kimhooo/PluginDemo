package com.kimho.plugin_package;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/8 11:29
 */
public class PluginActivity extends BaseActivity {
    private static final String ACTION_RECEIVER = "action_receiver";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start).setOnClickListener(
                v -> {
                    startActivity(new Intent(mHostActivity, TestActivity.class));
                }
        );
        findViewById(R.id.btn_start_service).setOnClickListener(
                v -> startService(new Intent(mHostActivity, TestService.class))
        );
        // 发送静态广播
        findViewById(R.id.btn_send_static).setOnClickListener(
                v -> sendBroadcast(new Intent("static_receiver"))
        );

        // 动态广播的注册与发送
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_RECEIVER);
        registerReceiver(new TestReceiver(), intentFilter);
        Toast.makeText(mHostActivity, "TestReceiver 已经注册完成", Toast.LENGTH_SHORT).show();
        findViewById(R.id.btn_start_broadcast).setOnClickListener(
                v -> sendBroadcast(new Intent(ACTION_RECEIVER)));
    }
}
