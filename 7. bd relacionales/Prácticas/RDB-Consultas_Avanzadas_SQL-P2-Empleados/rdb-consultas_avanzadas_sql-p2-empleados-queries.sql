-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT DISTINCT d.nombre_depto, d.localidad
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = "Vendedor";

-- Visualizar los departamentos con más de 2 empleados.
SELECT d.nombre_depto, count(1) as total_empleados
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro HAVING total_empleados > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados del mismo departamento que ‘Mito Barchuk’.
SELECT concat(e.nombre, " ", e.apellido) as empleado, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.depto_nro = (SELECT depto_nro FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk" LIMIT 1);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT concat(e.nombre, " ", e.apellido) as empleado, e.salario
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
ORDER BY e.salario ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY salario DESC
LIMIT 1;