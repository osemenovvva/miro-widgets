package com.olgasemenova.mirowidgets.service;

import com.olgasemenova.mirowidgets.model.WidgetDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class WidgetServiceTest {
    @Autowired
    private WidgetService widgetService;

    @Test
    void addWidgetInEmptyStorage() {
        WidgetDto resultWidget = new WidgetDto(
                UUID.fromString("c0a801b8-8e0a-1a1a-818e-0a1a1cab0000"),
                1,
                1,
                1,
                30,
                40,
                LocalDateTime.parse("2007-12-03T10:15:30")
        );

        widgetService.addNewWidget(resultWidget);

        WidgetDto actualWidget = widgetService
                .getWidgetById(UUID.fromString("c0a801b8-8e0a-1a1a-818e-0a1a1cab0000"));

        assertEquals(resultWidget, actualWidget);
    }

    @Test
    void deleteWidgetById() {
        WidgetDto resultWidget = new WidgetDto(
                UUID.fromString("c0a801b8-8e0a-1a1a-818e-0a1a1cab0000"),
                1,
                1,
                1,
                30,
                40,
                LocalDateTime.parse("2007-12-03T10:15:30")
        );

        widgetService.addNewWidget(resultWidget);
        widgetService.deleteWidget(UUID.fromString("c0a801b8-8e0a-1a1a-818e-0a1a1cab0000"));
        assertNull(widgetService.getWidgetById((UUID.fromString("c0a801b8-8e0a-1a1a-818e-0a1a1cab0000"))));
    }
}