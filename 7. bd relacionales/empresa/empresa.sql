-- Ejercicio con empresa_db hipotética implementación:

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT * , count(*) as cantidad_empleados FROM departamento d
JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY depto_nro
HAVING cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE e.puesto = (SELECT puesto FROM empleado WHERE concat(nombre, " ", apellido) = "Mito Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM empleados e 
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "contabilidad"
ORDER BY nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo. 
-- De la forma con mejor performance:
SELECT nombre FROM empleado 
ORDER BY salario 
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
-- De la forma con mejor performance:
SELECT * FROM empleados e 
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "ventas"
ORDER BY salario DESC
LIMIT 1;

