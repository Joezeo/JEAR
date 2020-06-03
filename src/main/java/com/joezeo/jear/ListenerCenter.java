package com.joezeo.jear;

import com.joezeo.jear.core.AbstractListener;
import com.joezeo.jear.core.EventEnum;
import com.joezeo.jear.core.annotation.Listener;
import com.joezeo.jear.exception.ExceptionHand;
import com.joezeo.jear.exception.JearException;
import com.joezeo.jear.exception.JearInitException;
import com.joezeo.jear.exception.JearSystemException;
import com.joezeo.jear.exception.util.ExceptionTypeEnum;
import com.joezeo.jear.util.AnnotationUtil;
import com.joezeo.jear.util.OneceCheck;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 监听器中心
 * 是所有监听器注册管理的中心单位，在一个项目上只能支持拥有一个监听器中心
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 11:45
 */
public final class ListenerCenter {
    private static volatile ListenerCenter center = null;
    private static OneceCheck oneceCheck = new OneceCheck();

    private List<AbstractListener> normalListeners = new ArrayList<>();
    private List<AbstractListener> remoteListeners = new ArrayList<>();

    private List<Class<?>> clazzes; // 所有注解了@Listener的类class对象

    public static ListenerCenter getCenter() {
        return center;
    }

    /**
     * 初始化监视器中心、默认不开启远程事件监听
     *
     * @param packageName 监听器中心管理的监听器所在的包名，只会注册在此包下的监视器
     */
    public static ListenerCenter init(String packageName) {
        try {
            oneceCheck.check();
            center = new ListenerCenter();

            // 根据@Listener注解来进行普通事件监视器注册
            center.registeNormalListener(packageName);
        } catch (JearException e) {
            ExceptionHand.handJearException(e);
        }
        return center;
    }

    /**
     * 初始化监视器中心，根据remoteListen参数选择是否开启远程事件监听
     *
     * @param packageName
     * @param remoteListen
     * @return
     */
    public static ListenerCenter init(String packageName, boolean remoteListen) {
        try {
            oneceCheck.check();
            center = new ListenerCenter();

            if (remoteListen) {
                center.registeRemoteListener(packageName);
            }
            center.registeNormalListener(packageName);
        } catch (JearException e) {
            ExceptionHand.handJearException(e);
        }
        return center;
    }

    public List<AbstractListener> getNormalListeners() {
        return this.normalListeners;
    }

    public List<AbstractListener> getRemoteListeners() {
        return this.remoteListeners;
    }

    /*
        private method
     */
    private void registeNormalListener(String packageName) {
        // 解析获取所有注解了@Listener的监听器，并且处理事件为NORMAL_EVENT的监听器
        registeByAnnotationAndType(packageName, EventEnum.NORMAL_EVENT);
    }

    private void registeRemoteListener(String packageName) {
        // 解析获取所有注解了@Listener的监听器，并且处理事件为REMOTE_EVENT的监听器
        registeByAnnotationAndType(packageName, EventEnum.REMOTE_EVENT);
    }

    private void registeByAnnotationAndType(String packageName, EventEnum eventType) {
        if (this.clazzes == null) {
            this.clazzes = AnnotationUtil.getClassListByAnnotation(packageName, Listener.class);
        }

        // 筛取符合条件的Listener class对象
        List<Class<?>> targetListeners = AnnotationUtil.getTargetListener(this.clazzes, eventType);

        targetListeners.forEach((clazz) -> {
            if (AbstractListener.class.equals(clazz.getSuperclass())){
                Class<? extends AbstractListener> lisClass = clazz.asSubclass(AbstractListener.class);
                try {
                    // 获取Listener的空构造方法，构造Listener对象
                    Constructor<? extends AbstractListener> constructor = lisClass.getDeclaredConstructor(null);
                    AbstractListener abstractListener = constructor.newInstance(null);

                    switch (eventType.getIndex()){
                        case EventEnum.NORMAL_CODE:
                            normalListeners.add(abstractListener);
                            break;
                        case EventEnum.REMOTE_CODE:
                            remoteListeners.add(abstractListener);
                            break;
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new JearSystemException("反射获取class对象的构造方法失败", ExceptionTypeEnum.ERROR);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new JearSystemException("反射获取class对象的构造方法失败，参数异常", ExceptionTypeEnum.ERROR);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new JearSystemException("通过反射创建对象失败", ExceptionTypeEnum.ERROR);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    throw new JearSystemException("反射执行任务失败", ExceptionTypeEnum.ERROR);
                }
            } else { // 标注了@listener的没有继承AbstractListener
                ExceptionHand.handJearException(new JearInitException(clazz.getName()
                        + "注解了@Listener，未继承AbstractListener，注册至监听器中心失败", ExceptionTypeEnum.WARN));
            }
        });
    }
}
