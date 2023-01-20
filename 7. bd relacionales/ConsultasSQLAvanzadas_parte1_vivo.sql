-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT DISTINCT d.nombre_depto, d.depto_nro, d.localidad, e.puesto
FROM departamento as d
INNER JOIN empleado as e
ON d.depto_nro = e.depto_nro
WHERE puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.cod_emp) as cantidad_de_empleados
FROM departamento as d
INNER JOIN empleado as e
ON d.depto_nro = e.depto_nro
group by d.nombre_depto
having cantidad_de_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto, e.puesto
FROM empleado as e
INNER JOIN departamento as d
ON e.depto_nro = d.depto_nro
WHERE e.puesto = (SELECT e.puesto
FROM empleado as e
WHERE e.nombre = "Mito" AND e.apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM empleado as e
INNER JOIN departamento as d 
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto LIKE ("%Contabilidad%")
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.salario
FROM empleado as e
WHERE e.salario = (SELECT MIN(e.salario)
FROM empleado as e);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empleado as e
WHERE e.salario = (SELECT MAX(e.salario)
FROM empleado as e
INNER JOIN departamento as d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas")