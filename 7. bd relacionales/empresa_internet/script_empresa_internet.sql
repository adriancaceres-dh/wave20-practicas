-- EJERCICIO 2
-- a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
-- 		La primary key seria el dni ya que los dni son indentificadores unicos para las personas.

-- b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
-- 		Para la tabla de planes seria un "id" generico ya que no hay forma de distinguirlos de otra forma

-- c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? 
-- ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
-- Yo pienso que la relación es "one to many" ya que un plan podria ser contratado por varios clientes.
-- La foreign key debiera ir en la tabla de cliente y seria el id del plan.

-- EJERCICIO 3

CREATE DATABASE empresa_internet;

CREATE TABLE plan (
    id int NOT NULL,
    velocidad int NOT NULL,
    precio int NOT NULL,
    descuento int,
    PRIMARY KEY (id)
);

CREATE TABLE cliente (
    dni int NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    fecha_de_nacimiento DATETIME NOT NULL,
    provincia VARCHAR(45) NOT NULL,
    ciudad VARCHAR(45) NOT NULL,
    id_plan int NOT NULL,
    PRIMARY KEY (dni),
    FOREIGN KEY (id_plan) REFERENCES plan(id)
);

INSERT INTO plan VALUES(1, 100, 10990, 5);
INSERT INTO plan VALUES(2, 250, 15990, 10);
INSERT INTO plan VALUES(3, 500, 19990, 5);
INSERT INTO plan VALUES(4, 750, 21990, 10);
INSERT INTO plan VALUES(5, 990, 25990, 15);

INSERT INTO cliente VALUES(123, "Fran", "Liz", "1990-01-03", "Provincia1", "Ciudad1", 5);
INSERT INTO cliente VALUES(234, "Panda", "Cub", "1991-02-04", "Provincia2", "Ciudad2", 4);
INSERT INTO cliente VALUES(345, "Opanda", "Regalón", "1992-03-05", "Provincia3", "Ciudad3", 3);
INSERT INTO cliente VALUES(456, "Odonap", "Too Cute", "1993-04-03", "Provincia4", "Ciudad4", 2);
INSERT INTO cliente VALUES(567, "Cubunap", "Miniatura", "1994-05-04", "Provincia5", "Ciudad5", 1);
INSERT INTO cliente VALUES(678, "Cub", "Nap", "1995-06-04", "Provincia6", "Ciudad6", 2);
INSERT INTO cliente VALUES(789, "Nap", "Mini Panda", "1996-07-05", "Provincia7", "Ciudad7", 3);
INSERT INTO cliente VALUES(890, "Ubuntu", "Panda", "1997-08-03", "Provincia8", "Ciudad8", 4);
INSERT INTO cliente VALUES(901, "Osito", "Cub", "1998-09-04", "Provincia9", "Ciudad9", 5);
INSERT INTO cliente VALUES(012, "Napda", "De Nap", "1999-10-05", "Provincia0", "Ciudad0", 1);

-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.
-- 1: Muestra el nombre completo de todos los clientes ordenados por apellido
SELECT CONCAT(nombre, ' ', apellido) "Nombre Completo" FROM cliente ORDER BY apellido;
-- 2: Muestra el nombre completo de todos los clientes con planes de 250mb
SELECT CONCAT(c.nombre, ' ', c.apellido) "Nombre Completo" 
FROM cliente c JOIN plan p ON(c.id_plan = p.id) 
WHERE p.velocidad = 250;
-- 3: Muestra los precios de todos los planes
SELECT precio FROM plan;
-- 4: Muestra a todos los clientes que han contratado el plan numero 3
SELECT CONCAT(c.nombre, ' ', c.apellido) "Nombre Completo" 
FROM cliente c JOIN plan p ON(c.id_plan = p.id) 
WHERE p.id = 3;
-- 5: Muestra toda la información de los planes con velocidades superiores a 250mb
SELECT * FROM plan WHERE velocidad > 250;
-- 6: Muestra toda la informacion de los clientes nacidos antes de 1997;
SELECT  * FROM cliente WHERE YEAR(fecha_de_nacimiento) < 1997;
-- 7: Muestra el nombre de todos los clientes y el precio del plan que contrataron
SELECT CONCAT(c.nombre, ' ', c.apellido) "Nombre Completo", p.precio
FROM cliente c JOIN plan p ON(c.id_plan = p.id);
-- 8: Muestra la provincia de los clientes que contrataron planes de precio menor a 25000
SELECT c.provincia, p.precio
FROM cliente c JOIN plan p ON(c.id_plan = p.id)
WHERE p.precio < 25000;
-- 9: Muestra el nombre y la ciudad de los clientes que contrataron el plan 2
SELECT CONCAT(c.nombre, ' ', c.apellido) "Nombre Completo", c.ciudad
FROM cliente c JOIN plan p ON(c.id_plan = p.id)
WHERE p.id = 2;
-- 10: Muestra el descuento del plan de 500mb
SELECT descuento FROM plan WHERE velocidad = 500;






