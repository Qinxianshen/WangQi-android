package com.wangqi.wangqishop.wangqi_core.app;

//多线程的时候 请使用枚举类 这是线程安全的单例懒汉模式 只能被初始化一次
public enum ConfigType {
    API_HOST,                               //配置网络请求域名
    APPLICATION_CONTEXT,                    //全局上下文
    CONFIG_READY,                           //标记 配置是否完成
    ICON                                    //图标
}
