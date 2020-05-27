package com.joezeo.jear.core;

/**
 * 监听器基类
 *
 * 所有监听器需要实现此基类，并且注释@Listener
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/25 16:56
 */
public abstract class AbstractListener {
    abstract void hand();
}
