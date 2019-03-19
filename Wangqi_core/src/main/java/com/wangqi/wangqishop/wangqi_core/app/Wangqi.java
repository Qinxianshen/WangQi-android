package com.wangqi.wangqishop.wangqi_core.app;


import android.content.Context;

import java.util.HashMap;

//对外开发工具类
public final class Wangqi {

    //初始化配置
    public static  Configurator init(Context context){
        //配置应用上下文
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }


    private static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getWangqiConfigs();
    }

    //获得配置类句柄
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }
    //通过Key获得到具体的某一个配置
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    //获得应用的上下文句柄
    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }



}
