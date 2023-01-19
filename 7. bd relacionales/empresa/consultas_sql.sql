-- Usar empresa;
USE empresa;

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleados AS e
INNER JOIN departamentos AS d ON d.depto_nro = e.depto_nro
WHERE e.puesto LIKE "Vendedor";

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro, d.nombre_depto, d.localidad, COUNT(*) numero_empleados
FROM departamentos AS d
INNER JOIN empleados e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING numero_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados AS e
LEFT JOIN departamentos AS d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleados WHERE nombre LIKE "Mito" AND apellido LIKE "Barchuk");

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM empleados AS e
INNER JOIN departamentos AS d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto LIKE "contabilidad"
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleados
ORDER BY salario
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro
FROM empleados AS e
INNER JOIN departamentos AS d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto LIKE "ventas"
ORDER BY salario DESC
LIMIT 1;