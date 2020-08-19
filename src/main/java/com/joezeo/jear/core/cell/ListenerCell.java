package com.joezeo.jear.core.cell;

import com.joezeo.jear.core.AbstractListener;

import java.util.List;

/**
 * 监听器的存储空间
 *
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/6/3 16:14
 */
public abstract class ListenerCell {

    public abstract List<AbstractListener> getListeners();

    public abstract void registeListener(AbstractListener listener);
}
