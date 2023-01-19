
/*
CREATE TABLE `empresa_db`.`Empleado` (
  `cod_emp` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `puesto` VARCHAR(45) NULL,
  `fecha_alta` DATETIME NOT NULL,
  `salario` INT NULL,
  `comision` INT NULL,
  `depto_nro` INT NULL,
  PRIMARY KEY (`cod_emp`));


CREATE TABLE `empresa_db`.`Departamento` (
  `depto_nro` INT NOT NULL AUTO_INCREMENT,
  `nombre_depto` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  PRIMARY KEY (`depto_nro`));
  
  ALTER TABLE `empresa_db`.`Empleado` 
ADD INDEX `depto_nro_idx` (`depto_nro` ASC) VISIBLE;

ALTER TABLE `empresa_db`.`Empleado` 
ADD CONSTRAINT `depto_nro`
  FOREIGN KEY (`depto_nro`)
  REFERENCES `empresa_db`.`Departamento` (`depto_nro`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('1', 'Software', 'Los Tigres\n\nLos Tigres');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('2', 'Sistemas', 'Guadalupe');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('3', 'Contabilidad', 'La Roca');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('4Departamento', 'Ventas', 'Plata');

INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('1', 'César', 'Piñero', 'Vendedor', '2018-05-12 15:40:10', '80000', '15000', '4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('2', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14 15:40:10', '140000', '0', '2');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('3', 'Mariela', 'Barrios', 'Director', '2014-06-05 15:40:10', '185000', '0', '3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('4', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03 15:40:10', '85000', '10000', '4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('5', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03 15:40:10', '83000', '10000', '4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('6', 'Mito', 'Barchuk', 'Presidente', '2014-06-05 15:40:10', '190000', '0', '3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('7', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', '60000', '0', '1');

  
  */
  
  /*
  
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
-- Visualizar los departamentos con más de cinco empleados.
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
-- Mostrar el nombre del empleado que tiene el salario más bajo.
Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.


  */

use empresa_db;


-- 1) SELECT d.localidad, e.nombre, e.puesto FROM Departamento d INNER JOIN Empleado e ON e.depto_nro = d.depto_nro;

-- 2) SELECT d.nombre_depto, COUNT(*) as count FROM Departamento d INNER JOIN Empleado e ON e.depto_nro = d.depto_nro GROUP BY d.depto_nro HAVING count > 5;

-- 3) SELECT e.nombre, e.salario, d.nombre_depto, e.puesto FROM Departamento d INNER JOIN Empleado e ON e.depto_nro = d.depto_nro WHERE e.puesto IN (SELECT em.puesto FROM Empleado em WHERE em.nombre = "Mito" AND em.apellido = "Barchuk");
 
-- 4) SELECT e.* FROM Departamento d INNER JOIN Empleado e ON e.depto_nro = d.depto_nro WHERE d.nombre_depto="contabilidad";

-- 4) SELECT nombre FROM Empleado ORDER BY salario LIMIT 1;

-- 5) SELECT e.* FROM Departamento d INNER JOIN Empleado e ON e.depto_nro = d.depto_nro WHERE d.nombre_depto = "ventas" ORDER BY e.salario DESC LIMIT 1;