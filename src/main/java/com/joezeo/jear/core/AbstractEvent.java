package com.joezeo.jear.core;

import com.joezeo.jear.core.help.EventHelp;

import java.io.Serializable;

/**
 * 监听事件基类，所有监听事件都需继承于此类
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/25 17:01
 */
public abstract class AbstractEvent<T> implements Serializable {
    private T data;

    public final void dispatch() {
        EventHelp.addToEventList(this);
    }
}
