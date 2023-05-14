-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

create schema donqbo;

set schema 'donqbo';



create table tbl_producto(
    id serial not null primary key,
    codigo varchar(10) not null,
    descripcion varchar(250) not null,
    nombre varchar(250) not null,            
    uuid_imagen varchar(250) not null,
    es_promocion boolean not null default false,
    valor_venta numeric(10,2) not null
);

create table tbl_promocion(
    id serial not null primary key,
    producto_id int8 not null,
    nombre varchar(250) not null,
    min_items int4 not null,            
    max_items int4 not null,
    REFERENCES fk_tbl_promocion FOREIGN KEY(producto_id) REFERENCES tbl_producto(id) 
);

create table tbl_promocion_productos(
    promocion_id int8 not null,
    producto_id int8 not null,
    REFERENCES fk_tbl_promocion_promocion_1 FOREIGN KEY(producto_id) REFERENCES tbl_producto(id),
    REFERENCES fk_tbl_promocion_promocion_2 FOREIGN KEY(promocion_id) REFERENCES tbl_promocion(id) 
);

create table tbl_usuario(
    id serial not null primary key,
    user_username varchar(250) not null,
    user_password varchar(250) not null,            
    user_role varchar(250) not null
);