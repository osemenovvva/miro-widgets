package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("in-memory")
public class InMemoryRepository implements WidgetRepository {
    private final InMemoryStorage storage = new InMemoryStorage();

    @Override
    public Optional<Widget> findById(UUID uuid) {
        return Optional.ofNullable(storage.getUuidWidgetMap().get(uuid));
    }

    @Override
    public void deleteById(UUID uuid) {
        Widget widgetToDelete = this.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Widget doesn't exist"));
        storage.getUuidWidgetMap().remove(uuid);
        storage.getWidgetTreeSet().remove(widgetToDelete);
    }

    @Override
    public boolean existsById(UUID widgetId) {
        return this.findById(widgetId).isPresent();
    }

    public List<Widget> findAllWidgets() {
        return storage.getWidgetTreeSet().stream().toList();
    }

    public Integer getMaxZValue() {
        return storage.getWidgetTreeSet().last().getzIndex() + 1;
    }
    public Optional<Widget> findByZIndex(Integer zIndex) {
        return storage
                .getWidgetTreeSet()
                .stream()
                .filter(x -> Objects.equals(x.getzIndex(), zIndex))
                .findAny();
    }
    public boolean isZIndexExists(Integer zIndex) {
        return storage
                .getWidgetTreeSet()
                .stream()
                .anyMatch(o -> Objects.equals(o.getzIndex(), zIndex));
    }



    public void saveAllWidgets(List<Widget> widgets) {
        for(Widget widget : widgets) {
            this.saveWidget(widget);
        }
    }

    public void saveWidget(Widget widget) {
        this.checkAndUpdateZIndex(widget);

        storage.getUuidWidgetMap().put(widget.getId(), widget);
        storage.getWidgetTreeSet().add(widget);
    }

    public void updateWidget(Widget widget) {
        Map<UUID, Widget> widgetsMap = storage.getUuidWidgetMap();
        TreeSet<Widget> widgetsTreeSet = storage.getWidgetTreeSet();

        this.checkAndUpdateZIndex(widget);

        Widget oldWidget = widgetsMap.get(widget.getId());

        widgetsMap.replace(widget.getId(), oldWidget, widget);

        widgetsTreeSet.remove(oldWidget);
        widgetsTreeSet.add(widget);
    }

    private void checkAndUpdateZIndex(Widget widget) {
        if (widget.getzIndex() == null) {
            widget.setzIndex(this.getMaxZValue());
        }

        Optional<Widget> entityWithSameZIndex = this.findByZIndex(widget.getzIndex());

        if (entityWithSameZIndex.isPresent()) {
            SortedSet<Widget> widgetsToEdit = storage
                    .getWidgetTreeSet()
                    .tailSet(entityWithSameZIndex.get());

            for(Widget w: widgetsToEdit) {
                Integer newIndex = w.getzIndex() + 1;

                if (!this.isZIndexExists(newIndex)
                        && newIndex != w.getzIndex() + 1) {
                    break;
                }

                widget.setzIndex(newIndex);
                storage
                    .getUuidWidgetMap()
                    .get(widget.getId())
                    .setzIndex(newIndex);
            }
        }
    }


}