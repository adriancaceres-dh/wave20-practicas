use internetdb;

SELECT nombre, provincia from cliente where provincia = 'Antioquia';

SELECT velocidad_en_megas as megas from plan where precio between 150 and 250;

SELECT nombre, idplan from cliente where idplan = 1;

SELECT nombre, apellido from cliente where ciudad LIKE 'B%';

SELECT concat(nombre, ' ',apellido) as nombre_completo from cliente;

SELECT concat(nombre, ' ',apellido) as nombre_completo from cliente where YEAR(fecha_de_nacimiento) = 1994;

SELECT avg(precio) as promedio_precios FROM plan;

SELECT velocidad_en_megas, descuento from plan where descuento <> 0.00;

SELECT nombre, apellido from cliente order by nombre, apellido;

SELECT concat(c.nombre, ' ',c.apellido) as nombre_completo, p.velocidad_en_megas
FROM cliente as c
join plan as p where c.idplan = p.idplan;

