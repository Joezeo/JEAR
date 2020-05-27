package com.joezeo.jear.exception;

/**
 * JEAR 框架异常运行时基类
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 14:47
 */
public class JearException extends RuntimeException {
    public JearException(String message){
        super(message);
    }
}
