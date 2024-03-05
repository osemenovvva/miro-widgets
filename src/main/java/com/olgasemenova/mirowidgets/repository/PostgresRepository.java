package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.UUID;

@Repository
@Profile("postgres")
public interface PostgresRepository extends WidgetRepository, JpaRepository<Widget, UUID> {
    @Query(value = "SELECT * FROM Widgets w ORDER BY w.z_index", nativeQuery = true)
    List<Widget> findAllWidgets();

    @Query(value = "SELECT * FROM Widgets w WHERE w.z_index = ?1 LIMIT 1", nativeQuery = true)
    Optional<Widget> findByZIndex(Integer zIndex);

    @Query(value = "SELECT max(w.z_index) + 1 FROM Widgets w ", nativeQuery = true)
    Integer getMaxZValue();

    @Query(value = "SELECT EXISTS(SELECT 1 FROM Widgets w WHERE w.z_index = ?1 )", nativeQuery = true)
    Boolean isZIndexExists(Integer zIndex);

    @Query(value = "SELECT * FROM Widgets w WHERE w.widget_id = ?1", nativeQuery = true)
    Optional<Widget> findById(UUID uuid);

    @Modifying
    @Query(value = "DELETE FROM Widgets w WHERE w.widget_id = ?1", nativeQuery = true)
    void deleteById(UUID uuid);

    @Modifying
    @Query(value = "UPDATE Widgets SET x = ?2, y = ?3, z_index = ?4, width = ?5, height = ?6, last_modification_date = ?7 WHERE widget_id = ?1", nativeQuery = true)
    void updateById(UUID uuid,
                    Integer x,
                    Integer y,
                    Integer zIndex,
                    Integer width,
                    Integer height,
                    LocalDateTime lastModificationDate);

    default void saveAllWidgets(List<Widget> widgets) {
        this.saveAll(widgets);
    }

    default void saveWidget(Widget newWidget) {
        List<Widget> widgets = this.findAllWidgets();
        List<Widget> updatedWidgets = this.checkAndUpdateZIndex(widgets, newWidget);
        updatedWidgets.add(newWidget);
        this.saveAll(updatedWidgets);
    }
    default void updateWidget(Widget widget) {
        List<Widget> widgets = this.findAllWidgets();
        widgets.remove(widget);

        List<Widget> updatedWidgets = this.checkAndUpdateZIndex(widgets, widget);
        updatedWidgets.add(widget);

        for(Widget widgetToUpdate: updatedWidgets) {
            this.updateById(widgetToUpdate.getId(),
                            widgetToUpdate.getX(),
                            widgetToUpdate.getY(),
                            widgetToUpdate.getzIndex(),
                            widgetToUpdate.getWidth(),
                            widgetToUpdate.getHeight(),
                            widgetToUpdate.getLastModificationDate());
        }
    }

    default List<Widget> checkAndUpdateZIndex(List<Widget> widgets, Widget newWidget) {
        if (newWidget.getzIndex() == null) {
            newWidget.setzIndex(this.getMaxZValue());
        }

        Optional<Widget> entityWithSameZIndex = this.findByZIndex(newWidget.getzIndex());

        if (entityWithSameZIndex.isPresent()) {
            int position = widgets.indexOf(entityWithSameZIndex.get());

            for (int i = position; i < widgets.size(); i++) {
                Widget currentWidget = widgets.get(i);
                Integer newIndex = currentWidget.getzIndex() + 1;

                if (!this.isZIndexExists(newIndex)
                        && newIndex != currentWidget.getzIndex() + 1) {
                    break;
                }

                currentWidget.setzIndex(newIndex);
            }
        }
        return widgets;
    }
}
