-- Usar empresa_internet
USE empresa_internet;

-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
-- Realizar las asociaciones/relaciones correspondientes entre estos registros.
INSERT INTO planes
VALUES
	(null, "Mejor", 50, 500, 0.2),
	(null, "Veloz", 30, 300, 0.1),
	(null, "Neutro", 20, 200, 0.05),
	(null, "Normal", 10, 150, 0.0),
	(null, "Malo", 5, 100, 0.0);
    
INSERT INTO clientes
VALUES
	(null, "ABC123", "Pedro", "Hernandez", "1998-03-12", null, "Guadalajara", 1),
    (null, "DEF456", "Aitana", "Carreño", "1996-06-04", null, "México", 2), 
    (null, "GHI789", "Adriana", "Zabala", "1993-07-14", null, "Puebla", 3), 
    (null, "JKL012", "Selena", "Ferrer", "1992-03-18", null, "León", 4), 
    (null, "MNO345", "Luis", "Viñas", "1991-11-22", null, "Querétaro", 5), 
    (null, "PQR678", "Ezequiel", "Heras", "1998-12-21", null, "Aguascalientes", 1), 
    (null, "STV901", "Josefina", "Vega", "1997-04-04", null, "Toluca", 2), 
    (null, "WXY234", "Rogelio", "Rogelio", "1995-07-15", null, "Tijuana", 3), 
    (null, "ZAB567", "Irene", "Pomares", "1993-03-29", null, "Monterrey", 4), 
    (null, "CDE890", "Fernanda", "Franco", "1997-11-24", null, "Zapopan", 5);

-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

-- 1. Seleccionar los planes con descuento
SELECT id, identificador, velocidad_megas, precio, descuento
FROM planes
WHERE descuento > 0;
-- 2. Seleccionar los planes con velocidad mayor a 20 megas
SELECT id, identificador, velocidad_megas, precio, descuento
FROM planes
WHERE velocidad_megas > 20;
-- 3. Seleccionar los planes con precio entre 150 y 300 pesos
SELECT id, identificador, velocidad_megas, precio, descuento
FROM planes
WHERE precio BETWEEN 150 AND 300;
-- 4. Seleccionar los clientes que hayan nacido en el mes de marzo
SELECT id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan
FROM clientes
WHERE MONTH(fecha_nacimiento) = "03";
-- 5. Seleccionar los clientes que hayan nacido entre los años 1994 y 1997
SELECT id, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan
FROM clientes
WHERE YEAR(fecha_nacimiento) BETWEEN "1994" AND "1997";
-- 6. Seleccionar los clientes con el plan con identificador "Mejor"
SELECT c.id, c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad, c.id_plan, p.identificador AS identificador_plan
FROM clientes AS c
INNER JOIN planes AS p ON p.id = c.id_plan
WHERE p.identificador LIKE "Mejor";
-- 7. Seleccionar los clientes cuya velocidad en megas es 20
SELECT c.id, c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad, c.id_plan, p.velocidad_megas AS velocidad_plan
FROM clientes AS c
INNER JOIN planes AS p ON p.id = c.id_plan
WHERE p.velocidad_megas = 20;
-- 8. Seleccionar los planes y el número de clientes que los tienen contratados
SELECT p.id, p.identificador, p.velocidad_megas, p.precio, p.descuento, COUNT(*) AS numero_clientes
FROM planes AS p
LEFT JOIN clientes AS c ON c.id_plan = p.id
GROUP BY p.id;
-- 9. Seleccionar los clientes con mayor velocidad en megas
SELECT c.id, c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad, c.id_plan, p.velocidad_megas AS velocidad_plan
FROM clientes AS c
INNER JOIN planes AS p ON p.id = c.id_plan
WHERE p.velocidad_megas = (SELECT MAX(velocidad_megas) FROM planes);
-- 10. Seleccionar los clientes que tengan algún descuento en su plan
SELECT c.id, c.dni, c.nombre, c.apellido, c.fecha_nacimiento, c.provincia, c.ciudad, c.id_plan, p.descuento AS descuento_plan
FROM clientes AS c
INNER JOIN planes AS p ON p.id = c.id_plan
WHERE p.descuento > 0;