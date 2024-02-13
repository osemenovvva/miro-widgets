package com.olgasemenova.mirowidgets.service;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import com.olgasemenova.mirowidgets.repository.WidgetRepository;
import com.olgasemenova.mirowidgets.util.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WidgetService {
    private final WidgetRepository widgetRepository;
    private final WidgetMapper widgetMapper;

    @Autowired
    public WidgetService(WidgetRepository widgetRepository,
                         WidgetMapper widgetMapper) {
        this.widgetRepository = widgetRepository;
        this.widgetMapper = widgetMapper;
    }
    public List<WidgetDto> getWidgets() {
        //должна доставать данные с помощью репозитория
        return widgetMapper.toDtoList(List.of());
    }

    public void addNewWidget(WidgetDto widget) {

    }

    public void deleteWidget(UUID widgetId) {

    }

    public void updateWidget(UUID widgetId,
                             Integer x,
                             Integer y,
                             Integer zIndex,
                             Integer width,
                             Integer height) {

    }
}
