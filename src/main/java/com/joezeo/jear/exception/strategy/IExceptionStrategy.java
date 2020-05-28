package com.joezeo.jear.exception.strategy;

import com.joezeo.jear.exception.JearException;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/28 10:53
 */
public interface IExceptionStrategy {

    void handException(JearException e);

}
