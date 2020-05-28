package com.joezeo.jear.exception.strategy;

import com.joezeo.jear.exception.JearException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 11:00
 */
@Slf4j
public class InitExceptionStrategy implements IExceptionStrategy {
    @Override
    public void handException(JearException e) {
        log.warn(e.getMessage());
    }
}
