SET FOREIGN_KEY_CHECKS=0; -- no supe como hacer que funcionaran los insert de clientes sin esto :(

-- Insertar 5 planes/packages de internet

INSERT INTO internet_package (id, speed, price, discount)
VALUES (1,100, 150, 20), (2,200, 250, null), (3,300, 300, null), (4,500, 430, 30), (5,800, 680, null);

-- Insertar 10 clientes

INSERT INTO client (dni, first_name, last_name, state, city, birth_date, internet_package_id) VALUES ('89298', 'Lowe', 'Thomasset', 'Florida', 'Pensacola', '1999-06-13',1),
('72496', 'Odilia', 'Angood', 'Nebraska', 'Omaha', '1999-05-24', 2),
('15860', 'Boy', 'Filipputti', 'Indiana', 'Indianapolis', '1999-06-03', 3),
('28920', 'Kirk', 'Bernardelli', 'District of Columbia', 'Washington', '2000-08-18',4),
('56175', 'Jordan', 'Raeburn', 'Texas', 'El Paso', '2000-07-26',5),
('23149', 'Meryl', 'Kuna', 'Missouri', 'Saint Louis', '2000-03-15',3),
('28908', 'Dewey', 'Boylan', 'Texas', 'Fort Worth', '2000-02-23',4),
('89455', 'Mariann', 'Snelgar', 'Virginia', 'Roanoke', '1999-07-17', 2),
('00097', 'Florrie', 'Parsonson', 'New York', 'New York City', '1999-01-28',1),
('38721', 'Hallie', 'Kernock', 'Texas', 'Katy', '1999-06-03',5);

-- 10 consultas

-- 1 Consultar todos los clientes
SELECT * FROM client;

-- 2 Consultar todos los planes

SELECT * FROM internet_package;

-- 3 Costo promedio del plan de internet

SELECT AVG(price) as precio_promedio FROM internet_package;

-- 4 Suma de todos los precios

SELECT SUM(price) AS suma_precios FROM internet_package;

-- 5 Nombre completo y DNI de los clientes

SELECT CONCAT(first_name, ' ', last_name) FROM client;

-- 6 Primer nombre, estado y ciudad

SELECT first_name, state, city FROM client;

-- 7 Todos los datos de los primeros 5 clientes

SELECT * FROM client LIMIT 5;

-- 8 Velocidad más alta de los planes de internet

SELECT MAX(speed) FROM internet_package;

-- 9 Velocidad más baja de los planes de internet

SELECT MIN(speed) FROM internet_package;

-- 10 Contar la cantidad de planes de internet

SELECT COUNT(*) FROM internet_package;
