
-- P2 - EN VIVO 

-- TODOS LOS REGISTROS DE LA TABLA MOVIES
SELECT * FROM movies_db.movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM movies_db.actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS titulo FROM movies_db.series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name 
FROM movies_db.actors 
WHERE rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards 
FROM movies_db.movies
WHERE rating > 7.5
AND	awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating
FROM movies_db.movies
ORDER BY rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title 
FROM movies_db.movies
LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT *
FROM movies_db.movies
ORDER BY rating DESC
LIMIT 5;

-- Listar los primeros 10 actores.
SELECT *
FROM movies_db.actors
LIMIT 10;
