package com.olgasemenova.mirowidgets.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.UuidGenerator;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "widgets")
public class Widget {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "widget_id")
    private UUID id;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @Column(name = "z_index")
    private Integer zIndex;

    @Column(name = "width")
    @Positive
    private Integer width;

    @Column(name = "height")
    @Positive
    private Integer height;

    @Column(name = "last_modification_date")
    private LocalDateTime lastModificationDate;

    public Widget() {
    }

    public Widget(Integer x,
                  Integer y,
                  Integer zIndex,
                  Integer width,
                  Integer height,
                  Clock clock) {
        this.id = UUID.randomUUID();
        this.x = x;
        this.y = y;
        this.zIndex = zIndex;
        this.width =  width;
        this.height =  height;
        this.lastModificationDate = LocalDateTime.now(clock);
    }

    public Widget(UUID id,
                  Integer x,
                  Integer y,
                  Integer zIndex,
                  Integer width,
                  Integer height,
                  Clock clock) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.zIndex = zIndex;
        this.width =  width;
        this.height =  height;
        this.lastModificationDate = LocalDateTime.now(clock);
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
