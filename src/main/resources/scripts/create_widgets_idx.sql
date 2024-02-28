--Индекс для фильтрации виджетов
create index widgets_x_y_idx on widgets(x, y);

--Индекс для сортировки по z-индексу
create index widgets_z_index_idx on widgets(z_index);