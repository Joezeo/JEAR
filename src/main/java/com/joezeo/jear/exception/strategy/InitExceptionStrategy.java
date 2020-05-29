package com.joezeo.jear.exception.strategy;

import com.joezeo.jear.exception.JearException;
import com.joezeo.jear.exception.util.ExceptionStringUtil;
import com.joezeo.jear.exception.util.ExceptionTypeEnum;
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
        ExceptionTypeEnum type = e.getType();
        StringBuilder sb = new StringBuilder();
        sb.append(ExceptionStringUtil.generateExceptionAffix(type, e.getClassName(), e.getMethodName()));
        sb.append(e.getMessage());

        if (type == ExceptionTypeEnum.ERROR){
            log.error(sb.toString());
        } else if (type == ExceptionTypeEnum.WARN){
            log.warn(sb.toString());
        }
    }
}
