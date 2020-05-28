package com.joezeo.jear.exception.util;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 17:29
 */
public enum  ExceptionTypeEnum {
    ERROR("[ERROR]"),
    WARN("[WARN]"),
    INFO("[INFO]")
    ;
    private String str;

    ExceptionTypeEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
