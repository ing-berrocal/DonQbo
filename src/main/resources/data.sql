/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  DELL
 * Created: 23/04/2023
 */

INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('10001', 'Llevate 30 Don Cubanos más una gaseosa', '30 Don Cubanos', '11C9341C-D9B8-A141-C05B-E850C8BEB979', true, 30000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('10002', 'Llevate 3 Cubanos más gaseosa', '3 Cubaninos + Gaseosa', '007519D5-E5B9-B776-76C6-6A3EE1830DA2', true, 10000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200001', 'parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse tristique', 'Jamon y Queso', '823AB25F-3BBF-E737-B936-17729C445626', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200002', 'egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem', 'Hawaiano', '5A98CC2A-5165-296E-BF60-6A578335FB9C', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200003', 'Nullam nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla', 'Tocino Máiz', '28AD96B1-7967-E455-EF55-A527E2CE474D', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200004', 'Mauris eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue', 'Suiza', '9CB534B3-23EB-65E6-3685-34926C02606F', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200005', 'ultricies ornare, elit elit fermentum risus, at fringilla purus mauris', 'Chorizo', 'A6DEFBAB-6286-51B5-26E8-0CB952D3655C', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('200006', 'morbi tristique senectus et netus et malesuada fames ac turpis', 'Butifarra', '2C5AE78D-4CF3-AC62-D63B-73F5A2DCC4AD', false, 3000.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('400001', 'Gaseosa', 'Coca Cola 350 ml', '222EED9D-78B3-4ECC-3429-D2331E1A668A', false, 42437.00);
INSERT INTO donqbo.tbl_producto
(codigo, descripcion, nombre, uuid_imagen, es_promocion, valor_venta)
VALUES('400002', 'Gaseosa', 'Coca Cola 1.5 lt', 'AD508432-6317-2D77-6FBD-233115159AE8', false, 29238.00);


INSERT INTO donqbo.tbl_promocion
(id, producto_id, nombre, min_items, max_items)
VALUES(1, 1, 'Productos', 30, 30);
INSERT INTO donqbo.tbl_promocion
(id, producto_id, nombre, min_items, max_items)
VALUES(2, 1, 'Bebidas', 1, 1);
INSERT INTO donqbo.tbl_promocion
(id, producto_id, nombre, min_items, max_items)
VALUES(3, 2, 'Productos', 3, 3);
INSERT INTO donqbo.tbl_promocion
(id, producto_id, nombre, min_items, max_items)
VALUES(4, 2, 'Bebidas', 1, 1);


INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 10);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 11);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 12);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 13);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 14);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(1, 15);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(2, 41);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(2, 40);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 10);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 11);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 12);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 13);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 14);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(3, 15);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(4, 41);
INSERT INTO donqbo.tbl_promocion_producto
(promocion_id, producto_id)
VALUES(4, 40);
