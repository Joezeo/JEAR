package com.joezeo.jear.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * JEAR框架异常处理总类
 * <p>
 * 框架中的异常都通过此类来进行处理
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 16:20
 */
@Slf4j
public class ExceptionHand {
    /**
     * 处理JearException及其子类异常
     */
    public static void handJearException(JearException e) {

    }

    /**
     * 处理其他RuntimeException
     */
    public static void handOtherException(RuntimeException e) {
        log.error(e.getMessage());
    }

    private ExceptionHand() {

    }
}
