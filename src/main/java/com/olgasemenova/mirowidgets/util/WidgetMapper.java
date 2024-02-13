package com.olgasemenova.mirowidgets.util;

import com.olgasemenova.mirowidgets.model.Widget;
import com.olgasemenova.mirowidgets.model.WidgetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class WidgetMapper {
    public Widget toEntity(WidgetDto dto) {
        return Objects.isNull(dto) ? null : new Widget(
                dto.getX(),
                dto.getY(),
                dto.getzIndex(),
                dto.getWidth(),
                dto.getHeight()
        );

    }

    public WidgetDto toDto(Widget entity) {
        return Objects.isNull(entity) ? null : new WidgetDto(
                entity.getX(),
                entity.getY(),
                entity.getzIndex(),
                entity.getWidth(),
                entity.getHeight()
        );
    }

    public List<Widget> toEntityList(List<WidgetDto> widgetDtoList) {
        List<Widget> widgetList = null;
        for (WidgetDto widgetDto : widgetDtoList) {
            widgetList.add(this.toEntity(widgetDto));
        }
        return widgetList;
    }

    public List<WidgetDto> toDtoList(List<Widget> widgetList) {
        List<WidgetDto> widgetDtoList = null;
        for (Widget widget : widgetList) {
            widgetDtoList.add(this.toDto(widget));
        }
        return widgetDtoList;
    }
}
