package com.olgasemenova.mirowidgets.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class WidgetDto {
    private UUID id;
    private Integer x;
    private Integer y;
    private Integer zIndex;
    private Integer width;
    private Integer height;
    private LocalDateTime lastModificationDate;

    public WidgetDto(Integer x,
                  Integer y,
                  Integer zIndex,
                  Integer width,
                  Integer height) {
        this.x = x;
        this.y = y;
        this.zIndex = zIndex;
        this.width =  width;
        this.height =  height;
        this.lastModificationDate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getzIndex() {
        return zIndex;
    }

    public void setzIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public LocalDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    private static int getMaxZValue () {
        return 0;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                ", x='" + x +
                ", y='" + y +
                ", zIndex=" + zIndex +
                ", width=" + width +
                ", height='" + height +
                ", lastModificationDate='" + lastModificationDate +
                '}';
    }
}
