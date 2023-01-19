INSERT INTO PlanesInternet VALUES(1,123,30.2,21.0);
INSERT INTO PlanesInternet VALUES(2,200,322.2,10.0);
INSERT INTO PlanesInternet VALUES(3,300,133.4,33.0);
INSERT INTO PlanesInternet VALUES(4,123,222.2,21.0);
INSERT INTO PlanesInternet VALUES(5,50,350.22,12.0);


INSERT INTO Clientes VALUES (1,"Lucas","Vargas","Dni1","BSAS","La Plata","2022-02-04",2);
INSERT INTO Clientes VALUES (2,"Natalia","Gonzales","Dni2","BSAS","Bahia Blanca","2020-05-11",2);
INSERT INTO Clientes VALUES (3,"Lucas","Rodriguez","Dni3","Cordoba","Cordoba","1999-07-23",3);
INSERT INTO Clientes VALUES (4,"Nicolas","Lopez","Dni4","Neuquen","Bariloche","2000-08-14",5);
INSERT INTO Clientes VALUES (5,"Juan","Altamirano","Dni5","Misiones","Posadas","2019-05-02",2);
INSERT INTO Clientes VALUES (6,"Santiago","Fiorillo","Dni6","Cordoba","Cordoba","2008-10-08",3);
INSERT INTO Clientes VALUES (7,"Jose","Gonzalez","Dni7","BSAS","La Plata","2006-12-17",4);
INSERT INTO Clientes VALUES (8,"Camila","Perez","Dni8","BSAS","Bahia Blanca","2002-02-24",2);
INSERT INTO Clientes VALUES (9,"Camila","Acosta","Dni9","Santa Fe","Rosario","2022-06-13",4);
INSERT INTO Clientes VALUES (10,"Rodrigo","Rodriguez","Dni10","Tucuman","Trancas","2010-02-09",5);

SELECT * FROM PlanesInternet;
SELECT * FROM Clientes;

-- 1 Nombre completo de los cliente que tienen un plan de internet con velocidad mayor a 150.
SELECT concat(nombre," ",apellido) AS nombre_completo
FROM Clientes AS C
INNER JOIN PlanesInternet AS PI
ON C.PlanInternet_id=PI.id
WHERE megas_velocidad>150;

-- 2 Ciudades de las provincias de BSAS y Cordoba.
SELECT DISTINCT ciudad
FROM Clientes
WHERE provincia IN ("BSAS", "Cordoba");

-- 3 Id y nomobre de los clientes nacidos antes de 2020.
SELECT id, nombre
FROM Clientes
WHERE YEAR(fecha_nacimiento) < "2000";

-- 4 Fecha de nacimiento de los nacidos entre 2006 y 2020 ordenada descendentemente.
SELECT fecha_nacimiento
FROM Clientes
WHERE fecha_nacimiento BETWEEN "2006-01-01" AND "2020-01-01"
ORDER BY fecha_nacimiento DESC;

-- 5 Cantidad de las provincias unicas.
SELECT COUNT(DISTINCT(provincia)) AS cantidad_provincias
FROM Clientes;

-- 6 Id de los planes de internet cuya velocidad es mayor a 100 y precio menor a 200.
SELECT id
FROM PlanesInternet
WHERE megas_velocidad>100 AND precio<200;

-- 7 Id y precio final de cada plan de internet.
SELECT id, ROUND(precio-(precio/100)*descuento,2) AS precio_final
FROM PlanesInternet;

-- 8 Nombre y apellido de los clientes cuyo apellido es "Rodriguez".
SELECT nombre, apellido
FROM Clientes
WHERE apellido LIKE "Rodriguez";

-- 9 Nombres completos de los clientes cuyos apellidos terminan en "ez".
SELECT concat(nombre," ",apellido) as nombre_completo
FROM Clientes
WHERE apellido LIKE "%ez";

-- 10 Recaudacion total del plan 4 de internet.
SELECT SUM(ROUND(precio-(precio/100)*descuento,2)) AS recaudacion
FROM Clientes AS C
INNER JOIN PlanesInternet AS PI
ON C.PlanInternet_id = PI.id
WHERE PI.id=4;