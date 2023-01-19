-- Inserción de 5 tipos de planes:
Insert into PlanInternet values (1,50.0,30.000,"no");
Insert into PlanInternet values (2,100.0,70.000,"no");
Insert into PlanInternet values (3,200.0,100.000,"no");
Insert into PlanInternet values (4,500.0,150.000,"no");
Insert into PlanInternet values (5,10.0,10.000,"no");


-- Inserción de 10 clientes con su respectivo plan: 
Insert into cliente values (1,"1010","Diego", "Malagon", "1991-02-06","Suba","Bogota", 1);
Insert into cliente values (2,"1011","Camilo", "Lopez", "1992-02-06","Suba","Bogota", 2);
Insert into cliente values (3,"1012","Damian", "Castro", "1993-02-06","Suba","Bogota", 3);
Insert into cliente values (4,"1013","Andres", "Alarcon", "1994-02-06","Suba","Bogota", 4);
Insert into cliente values (5,"1014","Felipe", "Ruiz", "1995-02-06","Suba","Bogota", 5);
Insert into cliente values (6,"1015","Sebastian", "Nieto", "1996-02-06","Suba","Bogota",1);
Insert into cliente values (7,"1016","Juan", "Barbosa", "1997-02-06","Suba","Bogota", 2);
Insert into cliente values (8,"1017","Alex", "Sema", "1998-02-06","Suba","Bogota", 3);
Insert into cliente values (9,"1018","Adrian", "Pineda", "1999-02-06","Suba","Bogota", 4);
Insert into cliente values (10,"1020","Jose", "Poveda", "2000-02-06","Suba","Bogota", 5);

-- CONSULTAS:
-- 1) Mostrar el nombre de los clientes con plan 2:
Select nombre, apellido from Cliente
where PlanInternet_idPlanInternet=2;

-- 2) Mostar el costo promedio de los planes de internet:
Select avg(precio) from PlanInternet;

-- 3)Mostrar el nombre de todos los clientes que viven en Suba:
Select nombre from Cliente where provincia like "Suba";

-- 4) Modificar los clientes que tengan plan 1 y setearles plan 2:
update Cliente set PlanInternet_idPlanInternet=2 where PlanInternet_idPlanInternet=1;

-- 5) Verificar que no existan usuarios con plan 1
Select count(*) from Cliente where PlanInternet_idPlanInternet=1;

-- 6) Eliminar el plan con id 1
Delete from PlanInternet where idPlanInternet = 1;

-- 7) Mostrar los nombres de los clientes nacidos en el año 1999
Select nombre from Cliente where fechaNacimiento between "1999-01-01" and "1999-12-31";

-- 8) Mostrar los planes existentes con su precio:
Select idPlanInternet, precio from PlanInternet;

-- 9) Mostrar el nombre y apellido de los clientes que tienen planes con precio mayor a 70.0
Select nombre, apellido from Cliente join PlanInternet on (PlanInternet_idPlanInternet = idPlanInternet)
where precio >70.0;

-- 10) Mostrar el nombre y apellido de los clientes que tienen plan 2 o 5:
Select nombre, apellido from Cliente where PlanInternet_idPlanInternet = 2 or PlanInternet_idPlanInternet=5;
