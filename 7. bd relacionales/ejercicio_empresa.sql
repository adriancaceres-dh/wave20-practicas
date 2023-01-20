#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT	emp.nombre, 
		emp.puesto, 
        dep.localidad 
FROM 	Departamento	AS	dep
JOIN	Empleado 		AS	emp	ON	emp.depto_nro = dep.depto_nro;

#Visualizar los departamentos con mas de cinco empleados.
SELECT 		dep.nombre_depto,
			COUNT(*) 		AS	cantidad_empleados
FROM 		Departamento	AS 	dep
JOIN 		Empleado		AS 	emp 
			ON 	emp.depto_nro = dep.depto_nro
GROUP BY 	dep.nombre_depto
HAVING 		cantidad_empleados > 5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que "Mito Barchuk"
SELECT 	emp.nombre,
		emp.salario,
        dep.nombre_depto
FROM	Empleado			AS	emp
JOIN	Departamento		AS	dep	
		ON	dep.depto_nro =	emp.depto_nro
WHERE	emp.puesto 	LIKE 	(
								SELECT 	puesto
								FROM 	Empleado
								WHERE 	CONCAT(nombre, " ", apellido) = "Mito Barchuk" 
							)
AND		emp.cod_emp	NOT LIKE	"E-0006";

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad ordenados por nombre.
SELECT		emp.cod_emp,
			emp.nombre,
			emp.apellido,
			emp.puesto,
			emp.fecha_alta,
			emp.salario,
			emp.comision,
			emp.depto_nro
FROM		Empleado			AS	emp
JOIN		Departamento		AS 	dep	
			ON	emp.depto_nro = dep.depto_nro
WHERE		dep.nombre_depto	LIKE	"contabilidad"
ORDER BY	emp.nombre			DESC;

#Mostrar el nombre del empleado que tiene el salario mas bajo
SELECT 	CONCAT(nombre, " ", apellido)	AS	nombre
FROM	Empleado
WHERE 	salario =	(
						SELECT 	min(salario)
						FROM	Empleado
					);
				
#Mostrar los datos del empleado que tiene el salario mas alto en el departamento de Ventas
SELECT 	CONCAT(nombre, " ", apellido)	AS	nombre
FROM	Empleado
WHERE 	salario =	(
						SELECT 	MAX(salario)
						FROM	Empleado		AS emp
						JOIN	Departamento	AS dep
								ON	dep.depto_nro = emp.depto_nro
						WHERE	dep.nombre_depto = "ventas"
					);
