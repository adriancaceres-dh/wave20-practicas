INSERT INTO plan
VALUES
(1, 10, 1000, 0),
(2, 50, 3000, 0),
(3, 100, 10000, 25),
(4, 200, 15000, 0),
(5, 300, 20000, 10);

INSERT INTO cliente
VALUES
(40534986, "Pepito", "Pepitez", "1990-05-22", "Catamarca", "Catamarca", 1),
(40774986, "Laura", "Lauriana", "1955-04-11", "Tucuman", "San Miguel de Tucuman", 3),
(40535566, "Samuel", "Juarez", "2000-09-19", "Salta", "Salta", 4),
(34533386, "Lautaro", "Salomon", "1988-11-17", "Tierra del Fuego", "Ushuaia", 3),
(33694686, "Briana", "Perez", "2001-06-07", "Buenos Aires", "CABA", 5),
(32535644, "Simone", "Gonzalez", "1975-05-15", "La Rioja", "Catamarca", 1),
(29595436, "Mercedes", "Benz", "1998-02-22", "Buenos Aires", "Catamarca", 2),
(35533586, "Carlos", "Samuel", "1990-07-21", "Chubut", "Rawson", 5),
(44533799, "Ruben", "", "1995-06-29", "Buenos Aires", "Lobos", 3),
(40537846, "Mateo", "Martes", "1960-10-02", "San Luis", "Catamarca", 2);


-- 1. Obtener todos los planes disponibles.

SELECT velocidad_mb, precio from plan
ORDER BY velocidad_mb ASC;

-- 2. Obtener los planes a los que se suscriben los clientes de Buenos Aires.

SELECT dni, nombre, plan_id_plan FROM cliente
WHERE provincia LIKE "Buenos Aires"; 

-- 3. Obtener los clientes que nacieron despues de los 2000.

SELECT dni, nombre FROM cliente
WHERE YEAR(fecha_nacimiento) >= 2000;

-- 4. Obtener los clientes que cumplen años en Octubre.

SELECT dni, nombre, plan_id_plan FROM cliente
WHERE MONTH(fecha_nacimiento) = 10;

-- 5. Aplicar descuento de 10% a todos los planes > 100mb

UPDATE plan
SET descuento = 10
WHERE velocidad_mb >= 100;

-- 6. Obtener los planes con descuento.

SELECT velocidad_mb, precio, descuento FROM plan
WHERE descuento > 0
ORDER BY descuento DESC;

-- 7. Listar los primeros 5 clientes, ordenados por plan contratado.

SELECT dni, concat(nombre, " ", apellido), plan as nombre_completo FROM cliente
ORDER BY plan_id_plan ASC
LIMIT 5;

-- 8. Obtener los clientes cuyo documento comienza con 4.

SELECT dni, nombre FROM cliente
WHERE dni LIKE "4%";

-- 9. Obtener los clientes del interior.

SELECT dni, nombre, plan_id_plan, provincia FROM cliente
WHERE provincia NOT LIKE "Buenos Aires"; 

-- 10. Eliminar el plan basico.
DELETE FROM plan
WHERE id_plan = 1;