package com.kimho.lifecycle_mananager;

import android.content.Context;
import android.content.Intent;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/6 18:09
 */
public interface BroadcastReceiverInterface {
    void onReceive(Context context , Intent intent);
}
