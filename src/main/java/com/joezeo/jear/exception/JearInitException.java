package com.joezeo.jear.exception;

import com.joezeo.jear.exception.strategy.ExceptionStrategyEnum;

/**
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 16:17
 */
public class JearInitException extends JearException {

    public static final ExceptionStrategyEnum strategy = ExceptionStrategyEnum.INIT_EXCEPTION_STRATEGY;

    public JearInitException(String message) {
        super(message);
    }

}
