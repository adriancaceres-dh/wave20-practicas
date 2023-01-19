1) Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
Consulta:

SELECT emp.puesto, emp.nombre, dep.localidad 
FORM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE emp.puesto LIKE “Vendedor”


2) Visualizar los departamentos con mas de cinco empleados.
Consulta:


SELECT COUNT(*), dep .nombre_depto, dep .localidad
FROM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro\
GROUP BY dep.nombre_depto
HAVING COUNT(*) > 5;

3) Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
Consulta:

SELECT emp.nombre, emp.salario, dep.nombre_depto 
FROM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
GROUP BY emp.puesto
HAVING emp.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE “Mito” AND apellido LIKE “Barchuk”)

4) Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.\
Consulta:

SELECT emp.nombre, emp.apellido, emp.puesto, emp.fecha_alta, emp.salario, emp.comision
FROM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
WHERE dep.nombre_depto LIKE “Contabilidad”
ORDER BY emp.nombre

5) Mostrar el nombre del empleado que tiene el salario mas bajo.
Consulta: 

SELECT emp.nombre
FORM empleado
WHERE emp.salario = (SELECT MIN(salario) FROM empleado )


6) Mostrar los datos del empleado que tiene el salario mas alto en el departamento de ventas.
Consulta:

SELECT emp.nombre, emp.apellido, emp.puesto, emp.fecha_alta, emp.salario, emp.comision
FORM empleado emp INNER JOIN departamento dep ON emp.depto_nro = dep.depto_nro
GROUP BY dep.nombre_depto LIKE “Ventas”
HAVING emp.salario = (SELECT MAX(salario) FROM empleado)


