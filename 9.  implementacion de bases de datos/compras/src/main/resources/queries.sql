INSERT INTO compras VALUES (1, CURRENT_TIMESTAMP(), 'Playera');
INSERT INTO compras VALUES (2, CURRENT_TIMESTAMP(), 'Tenis');
INSERT INTO compras VALUES (3, CURRENT_TIMESTAMP(), 'Pantalón');
INSERT INTO compras VALUES (4, CURRENT_TIMESTAMP(), 'Pants');
INSERT INTO compras VALUES (5, CURRENT_TIMESTAMP(), 'Camiseta');

-- Error por la clave repetida
INSERT INTO compras VALUES (5, CURRENT_TIMESTAMP(), 'Balón');