package com.joezeo.jear.exception.strategy;

import com.joezeo.jear.exception.JearException;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 10:56
 */
public enum  ExceptionStrategyEnum {
    INIT_EXCEPTION_STRATEGY(new InitExceptionStrategy()),
    SYSTEM_EXCEPTION_STRATEGY(new SystemExceptionStrategy())
    ;

    private IExceptionStrategy strategy;

    ExceptionStrategyEnum(IExceptionStrategy strategy) {
        this.strategy = strategy;
    }

    public void hand(JearException e){
        this.strategy.handException(e);
    }
}
