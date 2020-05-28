package com.joezeo.jear.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注远程监听事件
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 14:58
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteEvent {

}
