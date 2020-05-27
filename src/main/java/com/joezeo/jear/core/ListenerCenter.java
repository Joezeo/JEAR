package com.joezeo.jear.core;

import com.joezeo.jear.exception.JearException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 11:45
 */
public class ListenerCenter {
    private static volatile ListenerCenter center = null;
    private List<AbstractListener> listeners = null;

    public static ListenerCenter getInstance() {
        if (center == null) {
            synchronized (ListenerCenter.class) {
                if (center == null) {
                    center = new ListenerCenter();
                }
            }
        }
        ListenerCenter center = new ListenerCenter();
        return center;
    }

    /**
     * 初始化监视器中心
     */
    public void init() {
        // 根据@Watch注解来进行监视器注册
        registeListener();
    }


    private List<AbstractListener> getListeners() {
        return this.listeners;
    }

    /*
        private method
     */
    private void registeListener() {
        if (listeners == null) {
            listeners = new ArrayList<>();
            // 解析获取所有注解了@Listener的监听器
            List<AbstractListener> als = getByAnnotation();
            als.forEach((listener) -> {
               listeners.add(listener);
            });
        } else {
            throw new JearException();
        }
    }

    private List<AbstractListener> getByAnnotation() {
        return null;
    }
}
