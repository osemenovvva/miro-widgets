package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;

import java.util.*;

public class InMemoryStorage {

    private Map<UUID, Widget> uuidWidgetMap = new HashMap<>();
    private TreeSet<Widget> widgetTreeSet = new TreeSet<>(Comparator.comparingInt(o -> o.getzIndex()));

    public InMemoryStorage() { }

    public Map<UUID, Widget> getUuidWidgetMap() {
        return uuidWidgetMap;
    }

    public void setUuidWidgetMap(Map<UUID, Widget> uuidWidgetMap) {
        this.uuidWidgetMap = uuidWidgetMap;
    }

    public TreeSet<Widget> getWidgetTreeSet() {
        return widgetTreeSet;
    }

    public void setWidgetTreeSet(TreeSet<Widget> widgetTreeSet) {
        this.widgetTreeSet = widgetTreeSet;
    }

}
