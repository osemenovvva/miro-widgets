package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Profile("postgres")
public interface PostgresRepository extends WidgetRepository, JpaRepository<Widget, UUID> {

    //Получение списка виджетов, отсортированных по zIndex
    //List<Widget> findWidgetSortedByZIndex();

}
