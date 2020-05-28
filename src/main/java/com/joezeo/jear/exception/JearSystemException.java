package com.joezeo.jear.exception;

import com.joezeo.jear.exception.strategy.ExceptionStrategyEnum;

/**
 * java RuntimeException相关异常使用此类抛出
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 11:25
 */
public class JearSystemException extends JearException{

    public static final ExceptionStrategyEnum strategy = ExceptionStrategyEnum.SYSTEM_EXCEPTION_STRATEGY;

    public JearSystemException(String message) {
        super(message);
    }
}
