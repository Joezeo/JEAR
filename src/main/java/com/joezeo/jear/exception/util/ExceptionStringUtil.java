package com.joezeo.jear.exception.util;

/**
 * 用于处理异常信息字符串的工具类
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/27 16:28
 */
public class ExceptionStringUtil {
    /**
     * 生成异常message的前缀
     *
     * 格式[ERROR/INFO/WARN] <className:methodName>
     * @return
     */
    public static String generateExceptionAffix(ExceptionTypeEnum type, String className, String methodName){
        StringBuilder sb = new StringBuilder();
        sb.append(type.getStr());
        sb.append(" <").append(className).append(":").append(methodName).append("> ");
        return sb.toString();
    }
}
