package com.olgasemenova.mirowidgets.controller;

import com.olgasemenova.mirowidgets.model.WidgetDto;
import com.olgasemenova.mirowidgets.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/widget")
public class WidgetController {

    private final WidgetService widgetService;

    @Autowired
    public WidgetController(WidgetService widgetService) {
        this.widgetService = widgetService;
    }

    @GetMapping
    public List<WidgetDto> getWidgets() {
        return widgetService.getWidgets();
    }

    @GetMapping(path = "{widgetId}")
    public WidgetDto getWidgetById(
            @PathVariable("widgetId") UUID widgetId) {
        return widgetService.getWidgetById(widgetId);
    }

    @PostMapping
    public void addNewWidget(@RequestBody WidgetDto widgetDto) {
        widgetService.addNewWidget(widgetDto);
    }

    @DeleteMapping(path = "{widgetId}")
    public void deleteWidget(
            @PathVariable("widgetId") UUID widgetId) {
        widgetService.deleteWidget(widgetId);
    }

    @PutMapping(path = "{widgetId}")
    public void updateWidget(
            @PathVariable("widgetId") UUID widgetId,
            @RequestParam(required = false) Integer x,
            @RequestParam(required = false) Integer y,
            @RequestParam(required = false) Integer zIndex,
            @RequestParam(required = false) Integer width,
            @RequestParam(required = false) Integer height
    ) {
        widgetService.updateWidget(widgetId, x, y, zIndex,
                width, height);
    }
}
