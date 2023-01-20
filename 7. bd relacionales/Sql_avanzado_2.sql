-- Se requiere obtener las siguientes consultas:
-- 1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
-- 2 Visualizar los departamentos con más de cinco empleados.
-- 3 Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
-- 4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
-- 5 Mostrar el nombre del empleado que tiene el salario más bajo.
-- 6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

-- 1 
select e.nombre, d.nombre, e.puesto, d.localidad from departamento as d 
inner join empleado as e on (e.puesto = 'vendedor' and e.depto_nro = d.depto_nro);

-- 2
SELECT departamento.nombre, COUNT(*) as cantidad_empleados
FROM departamento JOIN empleado ON empleado.depto_nro = departamento.depto_nro
GROUP BY 1
HAVING cantidad_empleados > 5;

-- 3
SELECT empleado.nombre, empleado.salario, departamento.nombre
FROM empleado JOIN departamento ON departamento.depto_nro = empleado.depto_nro
WHERE empleado.puesto = "presidente";


-- 4 Deberia funcionar con el subselect ?

select * from empleado as e where (select depto_nro from departamento as d where d.nombre = 'Contabilidad') = e.depto_nro
order by e.nombre asc;

-- 5
SELECT nombre FROM empleado ORDER BY salario LIMIT 1;

-- 6 
SELECT * FROM empleado
WHERE depto_nro = "D-000-4"
ORDER BY salario DESC LIMIT 1;





