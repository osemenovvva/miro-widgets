package com.olgasemenova.mirowidgets.repository;

import com.olgasemenova.mirowidgets.model.Widget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WidgetRepository extends JpaRepository<Widget, UUID> {

}
