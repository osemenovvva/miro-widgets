package com.olgasemenova.mirowidgets.service;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import com.olgasemenova.mirowidgets.repository.WidgetRepository;
import com.olgasemenova.mirowidgets.util.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        List<Widget> widgets = widgetRepository.findAllWidgets();
        return widgetMapper.toDtoList(widgets);
    }

    public WidgetDto getWidgetById(UUID widgetId) {
        return widgetMapper.toDto(widgetRepository.findById(widgetId).orElseThrow(
                () -> new IllegalStateException("Widget with id " + widgetId + " does not exists")
        ));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addNewWidget(WidgetDto widgetDto) {
        widgetRepository.saveWidget(widgetMapper.toEntitySave(widgetDto));
    }

    @Transactional
    public void deleteWidget(UUID widgetId) {
        if (!widgetRepository.existsById(widgetId)) {
            throw new IllegalStateException(
                    "Widget with id " + widgetId + " does not exists");
        }
        widgetRepository.deleteById(widgetId);
    }

    @Transactional
    public void updateWidget(UUID widgetId,
                             Integer x,
                             Integer y,
                             Integer zIndex,
                             Integer width,
                             Integer height) {
        WidgetDto widgetDto = widgetMapper.toDto(widgetRepository.findById(widgetId)
                .orElseThrow(
                        () -> new IllegalStateException("Widget with id " + widgetId + "does not exists")
                ));

        if (x != null) {
            widgetDto.setX(x);
        }

        if (y != null) {
            widgetDto.setY(y);
        }

        widgetDto.setzIndex(zIndex);

        if (width != null && width > 0) {
            widgetDto.setWidth(width);
        }

        if (height != null && height > 0) {
            widgetDto.setHeight(height);
        }

        widgetRepository.updateWidget(widgetMapper.toEntityUpdate(widgetDto));
    }
}
