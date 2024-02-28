package com.olgasemenova.mirowidgets.service;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import com.olgasemenova.mirowidgets.repository.PostgresRepository;
import com.olgasemenova.mirowidgets.util.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WidgetService {
    private final PostgresRepository postgresRepository;
    private final WidgetMapper widgetMapper;

    @Autowired
    public WidgetService(PostgresRepository postgresRepository,
                         WidgetMapper widgetMapper) {
        this.postgresRepository = postgresRepository;
        this.widgetMapper = widgetMapper;
    }

    public List<WidgetDto> getWidgets() {
        List<Widget> widgets = postgresRepository.findAll();
        return widgetMapper.toDtoList(widgets);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addNewWidget(WidgetDto widgetDto) {
        postgresRepository.save(widgetMapper.toEntity(widgetDto));
    }

    @Transactional
    public void deleteWidget(UUID widgetId) {
        if (!postgresRepository.existsById(widgetId)) {
            throw new IllegalStateException(
                    "Widget with id " + widgetId + "does not exists");
        }
        postgresRepository.deleteById(widgetId);
    }

    @Transactional
    public void updateWidget(UUID widgetId,
                             Integer x,
                             Integer y,
                             Integer zIndex,
                             Integer width,
                             Integer height) {
        //добавить реализацию

    }
}
