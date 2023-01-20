-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT em.nombre, em.puesto, de.localidad
FROM empleado em
	JOIN departamento de
		ON em.depto_nro = de.depto_nro
WHERE em.puesto = "vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.

SELECT de.nombre_depto, COUNT(*) AS cantidad_empleados
FROM departamento de
	JOIN empleado em
		ON em.depto_nro = de.depto_nro
GROUP BY 1
HAVING cantidad_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados
-- que tengan el mismo puesto que ‘Mito Barchuk’.

SELECT em.nombre, em.salario, de.nombre_depto
FROM empleado em
	JOIN departamento de
		ON em.depto_nro = de.depto_nro
WHERE em.puesto = (
	SELECT puesto FROM empleado WHERE concat(nombre, " ", apellido) = "Mito Barchuk"
    );

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad,
-- ordenados por nombre.

SELECT *
FROM empleado
WHERE depto_nro = "D-000-3"
ORDER BY nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre
FROM empleado
ORDER BY salario LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT *
FROM empleado
WHERE depto_nro = "D-000-4"
ORDER BY salario DESC LIMIT 1;