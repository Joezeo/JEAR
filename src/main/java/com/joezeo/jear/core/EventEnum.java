package com.joezeo.jear.core;

import java.lang.annotation.Annotation;

/**
 * 事件类型Enum
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 14:22
 */
public enum EventEnum {
    /**
     * 普通本地事件
     */
    NORMAL_EVENT(1001, NormalEvent.class),

    /**
     * 远程事件
     */
    REMOTE_EVENT(1002, RemoteEvent.class);

    public static final int NORMAL_CODE = 1001;
    public static final int REMOTE_CODE = 1002;

    private int index;
    private Class<? extends Annotation> annotation;

    EventEnum(int index, Class<? extends Annotation> annotation) {
        this.index = index;
        this.annotation = annotation;
    }

    public int getIndex() {
        return index;
    }

    public Class<? extends Annotation> getAnnotation() {
        return annotation;
    }
}
