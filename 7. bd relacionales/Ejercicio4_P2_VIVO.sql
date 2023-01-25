
-- 1. Muestra todos los datos ordenados ascendentemente por su nombre de la tabla clientes --
SELECT * FROM empresa_internet.clientes ORDER BY nombre ASC;

-- 2. Muestra su nombre y apeliido en un solo campo de la tabla clientes --
SELECT CONCAT(nombre, ' ', apellido) "Nombre Completo" FROM empresa_internet.clientes;

-- 3. Muestra precio, descuento, dni de la tabla planes de internet --
SELECT precio, descuento, dni_clientes FROM empresa_internet.planes_de_internet;

-- 4. Muestra todos los datos ordenados del mayor precio al menor de la tabla planes de internet--
SELECT * FROM empresa_internet.planes_de_internet ORDER BY precio DESC;

-- 5. Muestra el dni, nombre y apellido de las personas que nacieron entre el 2000 y 2009 --
SELECT dni_clientes AS DNI, nombre, apellido FROM empresa_internet.clientes WHERE fecha_de_nacimiento BETWEEN '2000-01-01' AND '2009-12-31';

-- 6. Muestra el dni, ciudad y nombre de las personas que son solamente de Bogota --
SELECT dni_clientes AS DNI, ciudad, nombre FROM empresa_internet.clientes WHERE ciudad = 'Bogota';

-- 7. Muestra el nombre de las personas donde su nombre comienza por JU --
SELECT nombre FROM empresa_internet.clientes WHERE nombre LIKE '%JU%'; 

-- 8. Muestra los 3 primeros registro de la tabla clientes --
SELECT nombre, apellido FROM empresa_internet.clientes LIMIT 3; 

-- 9. Muestra todos los datos donde el precio sea mayor de 150000 de la tabla planes de internet
SELECT * FROM empresa_internet.planes_de_internet WHERE precio > '150000';

-- 10. Muestra el dni de los clientes, la velocidad de megas donde la velocidad de megas este entre 100 y 400 de la tabla planes de internet
SELECT dni_clientes, velocidad_megas FROM empresa_internet.planes_de_internet WHERE velocidad_megas BETWEEN '100' AND '400';