package com.joezeo.jear.exception;

import com.joezeo.jear.exception.strategy.ExceptionStrategyEnum;

import java.lang.reflect.Field;

/**
 * JEAR框架异常处理总类
 * <p>
 * 框架中的异常都通过此类来进行处理
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 16:20
 */
public class ExceptionHand {
    /**
     * 处理JearException其子类异常
     */
    public static void handJearException(JearException e) {
        Class<? extends JearException> clazz = e.getClass();
        try {
            Field strategyField = clazz.getField("strategy");
            ExceptionStrategyEnum strategy = (ExceptionStrategyEnum) strategyField.get(e);
            strategy.hand(e);
        } catch (NoSuchFieldException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private ExceptionHand() {
    }
}
