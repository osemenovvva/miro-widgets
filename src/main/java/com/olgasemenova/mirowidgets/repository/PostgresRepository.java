package com.olgasemenova.mirowidgets.repository;
import com.olgasemenova.mirowidgets.model.Widget;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostgresRepository extends WidgetRepository {

    //Получение списка виджетов, отсортированных по zIndex
    //List<Widget> findWidgetSortedByZIndex();
}
