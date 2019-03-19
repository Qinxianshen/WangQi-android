package com.wangqi.wangqishop.wangqi_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

//存取配置信息
public class Configurator {
    private static final HashMap<String, Object> WANGQI_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        //告诉配置文件 开始配置 但未配置完毕
        WANGQI_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    //静态内部类单例模式的初始化 与下面的getInstance方法组成线程安全的单例懒汉模式
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    //获得配置类
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getWangqiConfigs(){
        return WANGQI_CONFIGS;
    }

    //告诉配置文件 已经配置完成
    public final void configure(){
        initIcons();
        WANGQI_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    //ApiHost配置
    public final Configurator withApiHost(String host) {
        WANGQI_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }
    //icon配置

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }


    //检查配置是否完成
    private void checkConfiguration() {
        final boolean isReady = (boolean) WANGQI_CONFIGS.get(ConfigType.CONFIG_READY.name());
        //若配置未完成 抛出配置未完成异常
        if(!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }

    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = WANGQI_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) WANGQI_CONFIGS.get(key);
    }


}
