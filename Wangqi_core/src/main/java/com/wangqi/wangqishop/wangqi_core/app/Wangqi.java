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

    //获得配置类句柄
    private static HashMap<String, Object> getConfigurations(){
        return Configurator.getInstance().getWangqiConfigs();
    }



}
