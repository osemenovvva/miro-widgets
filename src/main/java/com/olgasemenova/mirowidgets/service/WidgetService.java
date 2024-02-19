package com.olgasemenova.mirowidgets.service;

import com.olgasemenova.mirowidgets.model.WidgetDto;

import java.util.List;
import java.util.UUID;

public interface WidgetService {

    public List<WidgetDto> getWidgets();

    public void addNewWidget(WidgetDto widget);

    public void deleteWidget(UUID widgetId);

    public void updateWidget(UUID widgetId,
                             Integer x,
                             Integer y,
                             Integer zIndex,
                             Integer width,
                             Integer height);
}
