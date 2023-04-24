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