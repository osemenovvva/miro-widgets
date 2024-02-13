package com.olgasemenova.mirowidgets.model;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Widget {
    @NotNull
    private UUID id;
    @NotNull
    private Integer x;
    @NotNull
    private Integer y;
    @NotNull
    private Integer zIndex;
    @NotNull
    @Positive
    private Integer width;
    @NotNull
    @Positive
    private Integer height;
    @NotNull
    private LocalDateTime lastModificationDate;

    public Widget(Integer x,
                  Integer y,
                  Integer zIndex,
                  Integer width,
                  Integer height) {
        this.x = x != null ? x : 0;
        this.y = y != null ? y : 0;
        this.zIndex = zIndex != null ? zIndex : this.getMaxZValue() + 1;
        //this.validatePositiveValue(width, "Width");
        this.width =  width != null ? width : 1;
        //this.validatePositiveValue(height, "Height");
        this.height =  height != null ? height : 1;
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

    //Как лучше валидировать?
    /*
    private static void validatePositiveValue(Integer value, String fieldName) {
        if (value != null && value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be a positive value.");
        }
    }
     */

    private static int getMaxZValue () {
        //Нужно ли выносить в сервис?
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
