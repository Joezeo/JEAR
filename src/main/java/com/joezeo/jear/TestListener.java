package com.joezeo.jear;

import com.joezeo.jear.core.AbstractListener;
import com.joezeo.jear.core.EventEnum;
import com.joezeo.jear.core.annotation.Listener;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/5/29 14:14
 */
@Listener(eventType = EventEnum.NORMAL_EVENT)
public class TestListener extends AbstractListener{
    @Override
    protected void hand() {

    }
}
