package com.olgasemenova.mirowidgets.util;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class WidgetMapper {
    public Widget toEntitySave(WidgetDto dto) {
        return new Widget(
                dto.getX(),
                dto.getY(),
                dto.getzIndex(),
                dto.getWidth(),
                dto.getHeight()
        );
    }

    public Widget toEntityUpdate(WidgetDto dto) {
        return new Widget(
                dto.getId(),
                dto.getX(),
                dto.getY(),
                dto.getzIndex(),
                dto.getWidth(),
                dto.getHeight()
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
