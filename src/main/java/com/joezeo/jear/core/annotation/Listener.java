package com.joezeo.jear.core.annotation;

import com.joezeo.jear.core.EventEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/25 16:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Listener {

    int code() default -1; // 监听器监听编号，默认为-1或<=0时该监听器会监听所有对应类型的事件

    EventEnum eventType() default EventEnum.NORMAL_EVENT; // 监听事件类型

    boolean isAsynchronous() default false; // 是否为异步执行

}
