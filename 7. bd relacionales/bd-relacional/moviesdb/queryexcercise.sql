use movies_db;

-- Mostrar todos los registros de la tabla de movies. 
select * from movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT id, first_name, last_name, rating
FROM actors;

SELECT id, concat(first_name, ' ',last_name) as full_name, rating
FROM actors;

SELECT title, awards FROM movies order by awards DESC limit 1;
SELECT MAX(awards)  FROM movies;
-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español
SELECT title as titulo FROM series;
-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name from actors where rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
select title, rating, awards from movies where rating > 7.5 and awards >2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies order by rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM movies order by rating DESC LIMIT 5;

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies where rating > 3 and awards > 1 and YEAR(release_date) between 1988 AND 2009 order by rating;