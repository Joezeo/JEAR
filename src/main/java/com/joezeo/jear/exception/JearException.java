package com.joezeo.jear.exception;

import com.joezeo.jear.exception.util.ExceptionTypeEnum;

/**
 * JEAR 框架异常运行时基类
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 14:47
 */
public class JearException extends RuntimeException {
    protected ExceptionTypeEnum type;

    protected String className; // 异常发生所在的类

    protected String methodName; // 异常发生所在的方法

    public JearException(String message, ExceptionTypeEnum type){
        super(message);
        this.type = type;
        StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        this.className = element.getClassName();
        this.methodName = element.getMethodName();
    }

    public ExceptionTypeEnum getType() {
        return type;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }
}
