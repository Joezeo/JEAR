package com.joezeo.jear.core;

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
    NORMAL_EVENT(1001),

    /**
     * 远程事件
     */
    REMOTE_EVENT(1002)
    ;
    private int index;
    EventEnum(int index){
        this.index = index;
    }
}
