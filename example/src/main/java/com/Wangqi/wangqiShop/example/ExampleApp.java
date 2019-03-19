package com.Wangqi.wangqiShop.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.wangqi.wangqishop.wangqi_core.app.Wangqi;
import com.wangqi.wangqishop.wangqi_ec.icon.FrontEcMoudule;

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Wangqi.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FrontEcMoudule())
                .withApiHost("http://127.0.0.1")
                .configure();
    }
}

