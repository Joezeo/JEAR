package com.joezeo.jear.core.cell;

import com.joezeo.jear.core.AbstractListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoZhe
 * @email joezane.cn@gmail.com
 * @date 2020/6/3 16:18
 */
public class NormalListenerCell extends ListenerCell {

    private List<AbstractListener> listeners = new ArrayList<>();

    @Override
    public List<AbstractListener> getListeners() {
        return this.listeners;
    }

    @Override
    public void registeListener(AbstractListener listener) {
        this.listeners.add(listener);
    }
}
