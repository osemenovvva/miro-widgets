package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryStorage {

    private ConcurrentMap<UUID, Widget> uuidWidgetMap = new ConcurrentHashMap<>();

    private SortedSet<Widget> widgetSet = Collections.synchronizedSortedSet(
            new TreeSet(Comparator.comparingInt(Widget::getzIndex)
            ));
    
    public InMemoryStorage() { }

    public ConcurrentMap<UUID, Widget> getUuidWidgetMap() {
        return uuidWidgetMap;
    }

    public void setUuidWidgetMap(ConcurrentMap<UUID, Widget> uuidWidgetMap) {
        this.uuidWidgetMap = uuidWidgetMap;
    }

    public SortedSet<Widget> getWidgetSet() {
        return widgetSet;
    }

    public void setWidgetSet(TreeSet<Widget> widgetSet) {
        this.widgetSet = widgetSet;
    }

}
