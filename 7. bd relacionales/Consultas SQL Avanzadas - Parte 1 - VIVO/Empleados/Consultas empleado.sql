# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
Select concat(e.nombre, " ", e.apellido) as nombre, e.puesto, d.localidad from empleado e
inner join departamento d on (d.depto_nro = e.depto_nro) where e.puesto = "vendedor";

# Visualizar los departamentos con más de cinco empleados.
Select depto_nro, nombre_depto from departamento where depto_nro in (Select depto_nro from empleado group by depto_nro having count(*) > 5);

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
Select concat(e.nombre, " ", e.apellido) as nombre, e.salario, d.nombre_depto from empleado e
inner join departamento d on (d.depto_nro = e.depto_nro) where e.puesto = (Select puesto from empleado e where nombre = "Mito" and apellido = "Barchuk");

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
Select * from empleado where depto_nro = (Select depto_nro from departamento where nombre_depto = "Contabilidad") order by nombre, apellido asc;

# Mostrar el nombre del empleado que tiene el salario más bajo.
Select concat(e.nombre, " ", e.apellido) as nombre from empleado e where e.salario = (Select min(salario) from empleado);

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
with salario_max_depto_ventas as (
	Select max(salario) as salario_maximo ,depto_nro from empleado where depto_nro = (Select depto_nro from departamento where nombre_depto = "Ventas") group by depto_nro
)
Select * from empleado e  inner join salario_max_depto_ventas rel on (e.depto_nro = rel.depto_nro) where e.salario = rel.salario_maximo;
