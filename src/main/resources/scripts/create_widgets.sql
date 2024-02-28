create extension if not exists "uuid-ossp";

create table if not exists widgets (
	widget_id 				uuid primary key not null default uuid_generate_v4(),
	x						integer not null default 0,
	y						integer not null default 0,
	z_index					integer not null unique,
	width					integer not null default 1,
	height					integer not null default 1,
	last_modification_date	timestamp not null default now()
);

--drop table widgets;