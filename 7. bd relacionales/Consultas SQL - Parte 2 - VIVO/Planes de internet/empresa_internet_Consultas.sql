# Mostrar el dni y nombre completo de los clientes de Montevideo
SELECT dni, concat(nombre, " ",apellido) as nombre_completo FROM cliente
where provincia = "Montevideo";

# Mostrar el dni y nombre completo de los clientes que nacieron a partir del 2000
SELECT dni, concat(nombre, " ",apellido) as nombre_completo FROM cliente
where year(fechaNacimiento) >= 2000;

# Mostar el total de clientes vinculados al plan 1
Select PlanInternet_idPlan as idPlan, count(*) as CantCliente from cliente where PlanInternet_idPlan = 1;

# Mostrar el dni y nombre completo de los clientes cuyo apellido empiece por R
SELECT dni, concat(nombre, " ",apellido) as nombre_completo FROM cliente where apellido like "R%";

# Mostrar el dni y nombre completo de los primeros 5 clientes
SELECT dni, concat(nombre, " ",apellido) as nombre_completo FROM cliente limit 5;

# Mostrar el precio promedio de los planes de internet
Select avg(precio) as precioPromedio from planInternet;

# Mostrar el precio maximo de los planes de internet
Select max(precio) as precioMaximo from planInternet;

# Mostrar la velocidad minima de los planes de internet
Select min(velocidadMegas) as precioMaximo from planInternet;

# Mostrar los planes de internet con una velocidad mayor a 200 megas
Select idPlan, precio from planInternet where velocidadMegas > 200;

# Mostrar los planes de internet que tienen descuento
Select idPlan, precio from planInternet where descuento > 0;



