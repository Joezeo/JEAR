package com.joezeo.jear.core.help;

import com.joezeo.jear.ListenerCenter;
import com.joezeo.jear.core.AbstractEvent;
import com.joezeo.jear.core.annotation.NormalEvent;
import com.joezeo.jear.core.annotation.RemoteEvent;
import com.joezeo.jear.exception.JearInitException;
import com.joezeo.jear.exception.util.ExceptionTypeEnum;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 15:00
 */
public class EventHelp {
    public static void addToEventList(AbstractEvent<?> event) {
        ListenerCenter center = ListenerCenter.getCenter();
        if (center == null) {
            throw new JearInitException("ListenerCenter尚未初始化", ExceptionTypeEnum.ERROR);
        }

        Class<? extends AbstractEvent> clazz = event.getClass();
        NormalEvent normal = clazz.getAnnotation(NormalEvent.class);
        RemoteEvent remote = clazz.getAnnotation(RemoteEvent.class);
        if (normal != null && remote != null) {
            throw new JearInitException(clazz.getName() + "只能注解一个监听器", ExceptionTypeEnum.ERROR);
        }
    }

    private EventHelp() {

    }
}
