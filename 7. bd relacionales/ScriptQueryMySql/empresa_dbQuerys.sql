use empresa_db;
-- SELECT nombre, puesto, d.localidad from Empleado e inner join Departamento d on e.idDepto = d.idDepartamento;
-- select d.idDepartamento, count(*) as cantidadEmpleados from Departamento d inner join Empleado e on e.idDepto = d.idDepartamento group by d.idDepartamento having cantidadEmpleados >= 5;
-- SELECT e.nombre, e.salario, d.nombreDepartamento from Empleado e inner join Departamento d on e.idDepto = d.idDepartamento where puesto = (select puesto from Empleado where nombre = "Mito" and apellido = "Barchuk" );
-- SELECT e.* from Empleado e inner join Departamento d on e.idDepto = d.idDepartamento where d.nombreDepartamento = "Contabilidad" order by nombre asc;
-- select nombre from Empleado where salario = (select min(salario) from Empleado);
-- SELECT e.* from Empleado e where e.salario = (select max(salario) from Empleado e inner join Departamento d on e.idDepto = d.idDepartamento where nombreDepartamento = "Ventas");
