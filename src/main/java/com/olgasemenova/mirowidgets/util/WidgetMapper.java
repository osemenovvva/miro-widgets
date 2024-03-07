package com.olgasemenova.mirowidgets.util;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

@Component
public class WidgetMapper {

    @Autowired
    private final Clock clock;

    public WidgetMapper(Clock clock) {
        this.clock = clock;
    }

    public Widget toEntitySave(WidgetDto dto) {
        return new Widget(
                dto.getX(),
                dto.getY(),
                dto.getzIndex(),
                dto.getWidth(),
                dto.getHeight(),
                clock
        );
    }

    public Widget toEntityUpdate(WidgetDto dto) {
        return new Widget(
                dto.getId(),
                dto.getX(),
                dto.getY(),
                dto.getzIndex(),
                dto.getWidth(),
                dto.getHeight(),
                clock
        );
    }

    public WidgetDto toDto(Widget entity) {
        return new WidgetDto(
                entity.getId(),
                entity.getX(),
                entity.getY(),
                entity.getzIndex(),
                entity.getWidth(),
                entity.getHeight(),
                entity.getLastModificationDate()
        );
    }

    public List<WidgetDto> toDtoList(List<Widget> widgetList) {
        List<WidgetDto> widgetDtoList = new ArrayList<>();
        for (Widget widget : widgetList) {
            widgetDtoList.add(this.toDto(widget));
        }
        return widgetDtoList;
    }
}
