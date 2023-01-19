
-- 1) Mostrar todos los registros de la tabla movies:
Select * from movies;

-- 2) Mostrar nombre apellido y rating de todos los actores:
Select first_name, last_name, rating from actors;

-- 3) Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select title as "Titulo de la pelicula "from series;

-- 4) Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select first_name, last_name from actors where rating >7.5;

-- 5) Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
Select title, rating , awards
from movies
where rating>7.5 and awards>2;

-- 6) Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
Select title, rating from movies order by rating;

-- 7) Mostrar los títulos de las primeras tres películas en la base de datos.
Select title from movies limit 3;

-- 8) Mostrar el top 5 de las películas con mayor rating.
Select title from movies order by rating desc limit 5;

-- 9) Listar los primeros 10 actores.
Select * from actors limit 10;

-- 10) Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
Select title, rating from movies where title like "%Toy Story%";

-- 11) Mostrar a todos los actores cuyos nombres empiezan con Sam.
Select * from actors where first_name like "Sam%";

-- 12) Mostrar el título de las películas que salieron entre el 2004 y 2008.
Select title from movies where release_date between "2004-01-01" and "2008-01-01"; 

-- 13) Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
Select title from movies
where rating>3 and awards>1 and release_date between "1988-01-01" and "2009-01-01"
order by rating;

