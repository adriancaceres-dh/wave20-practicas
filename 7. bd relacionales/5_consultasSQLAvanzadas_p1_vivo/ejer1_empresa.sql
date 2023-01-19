-- Insercion de datos

-- Departamento
INSERT INTO Departamento VALUES("D-000-1","Software","Los Tigres");
INSERT INTO Departamento VALUES("D-000-2","Sistemas","Guadalupe");
INSERT INTO Departamento VALUES("D-000-3","Contabilidad","La Roca");
INSERT INTO Departamento VALUES("D-000-4","Ventas","Plata");
-- Empleado

INSERT INTO Empleado VALUES("E-0001","César","Piñero","Vendedor","2018-05-12",80000,15000,"D-000-4");
INSERT INTO Empleado VALUES("E-0002","Yosep","Kolaweski","Analista","2015-07-14",140000,0,"D-000-2");
INSERT INTO Empleado VALUES("E-0003","Mariela","Barrios","Director","2014-06-05",185000,0,"D-000-3");
INSERT INTO Empleado VALUES("E-0004","Jonathan","Aguilera","Vendedor","2015-06-03",85000,10000,"D-000-4");
INSERT INTO Empleado VALUES("E-0005","Daniel","Brezezicki","Vendedor","2018-03-03",83000,10000,"D-000-4");
INSERT INTO Empleado VALUES("E-0006","Mito","Barchuk","Presidente","2014-06-05",190000,0,"D-000-3");
INSERT INTO Empleado VALUES("E-0007","Emilio","Galarza","Desarrollador","2014-08-02",60000,0,"D-000-1");
INSERT INTO Empleado VALUES("E-0008","Manuel","Diaz","Vendedor","2018-09-10",90000,12000,"D-000-4");
INSERT INTO Empleado VALUES("E-0009","Alejandro","Isaza","Vendedor","2020-04-09",85000,10000,"D-000-4");
INSERT INTO Empleado VALUES("E-0010","Jennifer","Mino","Vendedor","2019-10-12",81000,10000,"D-000-4");
INSERT INTO Empleado VALUES("E-0011","Liam","Gutierrez","Desarrollador","2014-08-02",90000,0,"D-000-1");
INSERT INTO Empleado VALUES("E-0012","Julian","Chavarro","Vendedor","2016-05-15",90000,12000,"D-000-4");

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT em.nombre, em.puesto, dep.localidad
FROM empleado em INNER JOIN departamento dep
ON em.depto_nro = dep.depto_nro
ORDER BY em.cod_emp;

-- Visualizar los departamentos con más de cinco empleados.

SELECT DISTINCT dep.depto_nro, dep.nombre_depto, COUNT(1) cantEmp
FROM departamento dep JOIN empleado emp
ON emp.depto_nro = dep.depto_nro
GROUP BY dep.depto_nro
HAVING cantEmp > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
-- Lo cambie por Manuel Diaz porque Mito Barchuk es el unico presidente

SELECT emp.nombre, emp.salario, dep.nombre_depto
FROM empleado emp INNER JOIN departamento dep
ON emp.depto_nro = dep.depto_nro
WHERE emp.puesto = (SELECT puesto FROM empleado WHERE CONCAT(nombre,' ',apellido) = "Manuel Diaz");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT emp.*
FROM empleado emp INNER JOIN departamento dep
ON dep.nombre_depto = "Contabilidad" and emp.depto_nro = dep.depto_nro
ORDER BY emp.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT DISTINCT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Esta solo funciona si se desea mostrar solo uno
SELECT nombre FROM empleado
ORDER BY salario DESC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT *
FROM empleado
WHERE salario = (SELECT MAX(salario) 
				FROM empleado emp INNER JOIN departamento dep 
				ON emp.depto_nro = dep.depto_nro
				WHERE dep.nombre_depto = "Ventas")
AND depto_nro = (SELECT depto_nro FROM departamento WHERE nombre_depto = "Ventas");

-- En caso que solo se quiera mostrar 1
SELECT nombre
FROM EMPLEADO E JOIN DEPARTAMENTO D
ON D.depto_nro = E.depto_nro
WHERE nombre_depto="ventas"
ORDER BY salario DESC
LIMIT 1;
