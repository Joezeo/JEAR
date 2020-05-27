package com.joezeo.jear;

import com.joezeo.jear.core.AbstractListener;
import com.joezeo.jear.exception.ExceptionHand;
import com.joezeo.jear.exception.JearException;
import com.joezeo.jear.exception.JearInitException;

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
public class ListenerCenter {
    private static volatile ListenerCenter center = null;
    private final List<AbstractListener> listeners = new ArrayList<>();

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
    public ListenerCenter init() {
        try {
            // 根据@Listener注解来进行监视器注册
            registeListener();
        } catch (JearException e) {
            ExceptionHand.handJearException(e);
        } catch (RuntimeException e) {
            ExceptionHand.handOtherException(e);
        }

        return this;
    }


    private List<AbstractListener> getListeners() {
        return this.listeners;
    }

    /*
        private method
     */
    private void registeListener() {
        if (this.listeners.size() == 0) {
            // 解析获取所有注解了@Listener的监听器
            List<AbstractListener> als = getByAnnotation();
            als.forEach((listener) -> {
                this.listeners.add(listener);
            });
        } else {
            throw new JearInitException("[WARN] <LisenerCenter> listener can just registe onece, the second registe was ignored");
        }
    }

    private List<AbstractListener> getByAnnotation() {
        return null;
    }
}
