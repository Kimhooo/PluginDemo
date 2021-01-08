package com.kimho.lifecycle_mananager;

import android.app.Activity;
import android.os.Bundle;

/**
 * @Description:
 * @Author: Kimho
 * @Date: 2021/1/6 17:01
 */
public interface ActivityInterface {
    void insertAppContext(Activity hostActivity);

    void onCreate(Bundle savedInstanceState);
}
