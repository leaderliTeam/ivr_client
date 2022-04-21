package com.pccc.sip.ivrclient.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;


    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getContext().getBean(clazz);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.context == null) {
            SpringUtil.setContext(applicationContext);
        }
    }

    private static void setContext(ApplicationContext applicationContext) {
        SpringUtil.context = applicationContext;
    }
}
