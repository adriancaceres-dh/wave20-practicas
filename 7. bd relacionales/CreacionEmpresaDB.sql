-- Sentencias de creacion de base de datos e inserción de registros EMPRESA_DB

CREATE TABLE departamento (
depto_nro VARCHAR(7), 
nombre_depto VARCHAR(50), 
localidad VARCHAR(50), PRIMARY KEY (depto_nro)
);

CREATE TABLE empleado 
(cod_emp VARCHAR(7),
nombre VARCHAR(50), 
apellido VARCHAR(50), 
puesto VARCHAR(50), 
fecha_alta DATE,
salario DOUBLE,
comision DOUBLE,
depto_nro VARCHAR(7),  PRIMARY KEY (cod_emp), FOREIGN KEY(depto_nro) REFERENCES departamento(depto_nro)) ;


CREATE TABLE departamento (
depto_nro VARCHAR(6), 
nombre_depto VARCHAR(50), 
localidad VARCHAR(50), primary key (depto_nro)
);


INSERT INTO departamento VALUE ("D-000-1", "Software", "Los Tigres");
INSERT INTO departamento VALUE ("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO departamento VALUE ("D-000-3", "Contabilidad", "La Roca");
INSERT INTO departamento VALUE ("D-000-4", "Ventas", "Plata");


INSERT INTO empleado VALUE ("E-0001", "César", "Piñero", "Vendedor", str_to_date('12/05/2018', '%d/%m/%Y'), 80000, 15000, "D-000-4");
INSERT INTO empleado VALUE ("E-0002", "Yosep", "Kowaleski", "Analista", str_to_date('14/07/2015', '%d/%m/%Y'), 140000, 0, "D-000-2"); 
INSERT INTO empleado VALUE("E-0003", "Mariela", "Barrios", "Director", str_to_date('05/06/2014', '%d/%m/%Y'), 185000, 0,"D-000-3"); 
INSERT INTO empleado VALUE ("E-0004", "Jonathan", "Aguilera", "Vendedor", str_to_date('03/06/2015', '%d/%m/%Y'), 85000, 10000, "D-000-4");
INSERT INTO empleado VALUE ("E-0005", "Daniel", "Brezezicki", "Vendedor", str_to_date('03/03/2018', '%d/%m/%Y'), 83000, 10000, "D-000-4");
INSERT INTO empleado VALUE ("E-0006", "Mito", "Barchuk", "Presidente", str_to_date('05/06/2014', '%d/%m/%Y'), 190000, 0, "D-000-3");
INSERT INTO empleado VALUE ("E-0007", "Emilio", "Galarza", "Desarrollador", str_to_date('02/08/2014', '%d/%m/%Y'), 60000, 0, "D-000-1");

SELECT * FROM empleado;
SELECT * FROM departamento;


-- SENTENCIAS AUXILIARES
ALTER TABLE empleado
ADD FOREIGN KEY (depto_nro) 
REFERENCES departamento(depto_nro);

ALTER TABLE empleado
MODIFY COLUMN cod_emp VARCHAR(6);

ALTER TABLE departamento
MODIFY COLUMN depto_nro VARCHAR(6);
				  
DROP TABLE empleado;
DROP TABLE departamento; 

DELETE FROM empleado WHERE cod_emp = "E-0001" ; 
-- FIN DE SENTENCIAS AUXILIARES










