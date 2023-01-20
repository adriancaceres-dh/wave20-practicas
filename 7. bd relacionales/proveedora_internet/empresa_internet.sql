-- Creando planes de internet:
INSERT INTO plan_internet (identificador, velocidad_megas, precio, descuento) VALUES ("P1", 100, 1000.00, 15);
INSERT INTO plan_internet (identificador, velocidad_megas, precio, descuento) VALUES ("P2", 200, 2000.00, 10);
INSERT INTO plan_internet (identificador, velocidad_megas, precio, descuento) VALUES ("P3", 300, 3000.00, 5);
INSERT INTO plan_internet (identificador, velocidad_megas, precio, descuento) VALUES ("P4", 400, 4000.00, 10);
INSERT INTO plan_internet (identificador, velocidad_megas, precio, descuento) VALUES ("P5", 500, 5000.00, 15);

-- Creando clientes:
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("11.111.111", "A", "AAA", "1999-01-01", "Cordoba", "Cordoba", 1);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("22.222.222", "B", "BBB", "1998-02-01", "Mendoza", "San Rafael", 2);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("33.333.333", "C", "CCC", "1997-03-01", "Neuquen", "Neuquen", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("44.444.444", "D", "DDD", "1996-04-01", "Buenos Aires", "La Plata", 4);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("55.555.555", "E", "EEE", "1995-05-01", "La Pampa", "Santa Rosa", 5);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("66.666.666", "F", "FFF", "1999-06-01", "Formosa", "Formosa", 4);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("77.777.777", "G", "GGG", "2000-07-01", "Chaco", "Resistencia", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("88.888.888", "H", "HHH", "2001-08-01", "Corrientes", "Corrientes", 2);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("99.999.999", "I", "III", "2003-09-01", "San Juan", "San Juan", 1);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES ("12.121.121", "J", "JJJ", "2004-10-01", "Tucuman", "Tucuman", 2);


-- Operaciones de consulta básicas:
SELECT * FROM plan_internet;

SELECT nombre, apellido FROM cliente;

SELECT * FROM cliente LIMIT 5;

SELECT nombre, apellido, dni FROM cliente
WHERE id_plan = 3;

SELECT identificador, velocidad_megas FROM plan_internet
WHERE velocidad_megas >= 300;

SELECT nombre, apellido, fecha_nacimiento FROM cliente
WHERE YEAR(fecha_nacimiento) > 1990 AND ciudad = "La Plata";

SELECT identificador, precio, descuento FROM plan_internet
ORDER BY descuento DESC;

SELECT concat(nombre," ", apellido) "Nombre completo", dni FROM cliente
WHERE id_plan BETWEEN 2 AND 5 ;

SELECT concat(nombre," ", apellido) "Nombre completo" FROM cliente 
WHERE ciudad IN ("San Juan", "Tucuman");

SELECT dni, nombre, apellido FROM cliente 
ORDER BY fecha_nacimiento LIMIT 2;









