package com.Wangqi.wangqiShop.example;

import android.app.Application;

import com.wangqi.wangqishop.wangqi_core.app.Wangqi;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Wangqi.init(this)
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}

