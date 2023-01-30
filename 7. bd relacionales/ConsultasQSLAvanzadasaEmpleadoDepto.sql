-- insert into empleado (cod_emp,
-- nombre,
-- apellido,
-- puesto,
-- fecha_alta,
-- salario,
-- comision,
-- depto_nro)
-- values 
-- -- ("E-0001", "César", "Piñero", "Vendedor", "2004-01-01", 80000, 15000, "D-000-4"),
-- -- ("E-0007", "n7", "a7", "p7", "2004-01-01", 80001, 15001, "D-000-1"),
-- -- ("E-0008", "n8", "a8", "p8", "2004-01-01", 80002, 15002, "D-000-2"),
-- -- ("E-0009", "n9", "a9", "p9", "2004-01-01", 80003, 15003, "D-000-3"),
-- -- ("E-0010", "n10", "a10", "p10", "2004-01-01", 80004, 15004, "D-000-4"),
-- -- ("E-0011", "n11", "a11", "p11", "2004-01-01", 80005, 15005, "D-000-2");
-- ("E-0011", "n11", "a11", "p11", "2004-01-01", 800005, 150005, "D-000-2");

-- insert into Departamento (depto_nro, nombre_depto, localidad)
-- values
-- ("D-000-1","D1","L1"),
-- ("D-000-2","D2","L2"),
-- ("D-000-3","D3","L3"),
-- ("D-000-4","D4","L4");

select nombre_depto, puesto, localidad from departamento join empleado on empleado.depto_nro = departamento.depto_nro where puesto = "Vendedor";

select nombre_depto from departamento join empleado on empleado.depto_nro = departamento.depto_nro group by nombre_depto having count(1)>5;

select nombre, salarioempleadoempleado, nombre_depto from empleado join departamento where puesto = (select puesto from empleado where nombre = "‘Mito" and apellido = "Barchuk’");

select nombre, apellido from empleado join departamento where nombre_depto = "Contabilidad" order by nombre asc;

select nombre, apellido from empleado where salario = (select min(salario) from empleado);

select nombre, apellido from empleado join departamento where  salario = (select max(salario) from empleado join departamento where  nombre_depto = "Ventas" ) and nombre_depto = "Ventas";