package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WidgetRepository {
    public Optional<Widget> findById(UUID uuid);
    public void deleteById(UUID uuid);
    public boolean existsById(UUID widgetId);
    public List<Widget> findAllWidgets();
    public void saveAllWidgets(List<Widget> widgets);
    public void saveWidget(Widget widget);
    public void updateWidget(Widget widget);
}
