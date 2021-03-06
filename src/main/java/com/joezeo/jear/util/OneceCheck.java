package com.joezeo.jear.util;

import com.joezeo.jear.exception.JearInitException;
import com.joezeo.jear.exception.util.ExceptionTypeEnum;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 用于某些只能一次调用的方法检查
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 15:14
 */
public final class OneceCheck {
    private final AtomicBoolean hasChecked = new AtomicBoolean(false);

    public void check() {
        if (hasChecked.compareAndSet(false, true)) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            // 调用栈的0、1、2分别为 getStackTrace()、check()、以及调用check()的方法
            StackTraceElement element = stackTrace[2];
            throw new JearInitException("多次调用，已忽略多次调用部分", ExceptionTypeEnum.WARN);
        }
    }
}
