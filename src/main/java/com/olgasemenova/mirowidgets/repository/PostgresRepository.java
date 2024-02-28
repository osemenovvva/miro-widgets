package com.olgasemenova.mirowidgets.repository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("postgres")
public interface PostgresRepository extends WidgetRepository {

    //Получение списка виджетов, отсортированных по zIndex
    //List<Widget> findWidgetSortedByZIndex();
}
