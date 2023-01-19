# Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

# 1- Obtener el dni, nombre y apellido de todos los clientes que posee la empresa.
SELECT dni, nombre, apellido FROM clientes;

# 2- Obtener el identificador del plan y la velocidad en megas de todos los planes que existen.
SELECT id_plan,velo_megas FROM plan_internet;

# 3- Obtener el dni y nombre de todas las personas que poseen el plan 1.
SELECT dni, nombre FROM clientes WHERE plan_internet_id_plan = 1;

# 4- Obtener el dni y nombre de todas personas que poseen el plan 1 y 2 ordenadas por nombre de forma ascendente.
SELECT dni, nombre FROM clientes WHERE plan_internet_id_plan BETWEEN 1 AND 2 ORDER BY nombre;

# 5- Obtener todas las personas de la ciudad de Montevideo.
SELECT * FROM clientes WHERE ciudad="Montevideo";

# 6- Otener el precio de los planes que poseen una velocidad de megas mayor a 120.
SELECT precio FROM plan_internet WHERE velo_megas > 120;

# 7- Obtener todas las personas nacidas luego del 1980.
SELECT * FROM clientes WHERE fecha_nac > "1980-01-01";

# 8- Obtener los descuentos de cada uno de los planes con sus respectivos dni.
SELECT id_plan, descuentos FROM plan_internet;

# 9- Obtener todas las personas que poseen el plan 2 y su ciudad comience con "Du".
SELECT * FROM clientes WHERE plan_internet_id_plan = 2 AND ciudad LIKE "Du%";

# 10- Obtener dni y precio del plan que debe pagar cada persona.
SELECT dni, precio FROM clientes, plan_internet;