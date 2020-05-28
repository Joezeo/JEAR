package com.joezeo.jear;

import com.joezeo.jear.core.AbstractListener;
import com.joezeo.jear.core.Listener;
import com.joezeo.jear.exception.ExceptionHand;
import com.joezeo.jear.exception.JearException;
import com.joezeo.jear.exception.JearInitException;
import com.joezeo.jear.util.AnnotationUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 监听器中心
 * 是所有监听器注册管理的中心单位
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 11:45
 */
public final class ListenerCenter {
    private static volatile ListenerCenter center = null;
    private List<AbstractListener> listeners = new ArrayList<>();

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
     *
     * @param packageName 监听器中心管理的监听器所在的包名，只会注册在此包下的监视器
     */
    public ListenerCenter init(String packageName) {
        try {
            // 根据@Listener注解来进行监视器注册
            registeListener(packageName);
        } catch (JearException e) {
            ExceptionHand.handJearException(e);
        }
        return this;
    }


    private List<AbstractListener> getListeners() {
        return this.listeners;
    }

    /*
        private method
     */
    private void registeListener(String packageName) {
        if (this.listeners.size() == 0) {
            // 解析获取所有注解了@Listener的监听器
            List<AbstractListener> als = getByAnnotation(packageName);
            als.forEach((listener) -> {
                this.listeners.add(listener);
            });
        } else {
            throw new JearInitException("[WARN] <LisenerCenter> listener can just registe onece, the second registe was ignored");
        }
    }

    private List<AbstractListener> getByAnnotation(String packageName) {
        AnnotationUtil.getClassListByAnnotation(packageName, Listener.class);
        return null;
    }
}
