-- Sentencias SQL Avanzado EMPRESA_DB

SELECT em.nombre, em.puesto, de.localidad 
FROM empleado em 
INNER JOIN departamento de 
ON em.depto_nro = de.depto_nro;

SELECT de.nombre_depto, COUNT(*) total_empleados
FROM departamento de 
INNER JOIN empleado em 
ON em.depto_nro = de.depto_nro 
GROUP BY de.depto_nro
HAVING total_empleados > 2;
-- se cambio el filtro porque no existe departamento con más de 5 empleados

SELECT em.nombre, em.salario, de.nombre_depto
FROM empleado em
INNER JOIN departamento de 
ON em.depto_nro = de.depto_nro
WHERE em.puesto =
	(SELECT puesto FROM empleado 
    WHERE nombre = "Mito" AND apellido = "Barchuk");

SELECT em.cod_emp, CONCAT(em.nombre, " ", em.apellido) nombre_completo, em.puesto, em.fecha_alta, em.salario, em.comision
FROM empleado em
INNER JOIN departamento de 
ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = "Contabilidad" 
ORDER BY nombre_completo ASC;

SELECT CONCAT(nombre, " ", apellido) nombre_completo , salario
FROM empleado WHERE salario = ( SELECT MIN(salario) FROM empleado );


SELECT em.cod_emp, 
	CONCAT(em.nombre, " ", em.apellido) nombre_completo, 
	em.puesto, 
	em.fecha_alta, 
	em.salario, 
	em.comision
FROM empleado em
WHERE em.salario = ( 
	SELECT MAX(salario) 
    FROM empleado em 
    INNER JOIN departamento de 
	ON em.depto_nro = de.depto_nro 
    WHERE de.nombre_depto = "VENTAS");




