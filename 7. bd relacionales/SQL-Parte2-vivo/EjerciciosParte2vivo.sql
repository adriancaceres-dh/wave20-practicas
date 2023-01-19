-- mostrar todos los registros de la tabla movies.
SELECT * FROM movies;
SELECT * FROM actors;
-- mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;
-- mostrar el titulo de todas las series y usar alias, para que tanto el nombre de la tabla como el campo esten en español.
SELECT  title "titulo de series" FROM series;
-- mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
-- mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con mas de dos premios
SELECT title, rating
FROM movies
WHERE rating > 7.5 and awards > 2;
-- mostrar el titulo de las peliculas y el rating ordenadas por rating en forma ascendente
SELECT title, rating
FROM movies
ORDER BY rating asc;
-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title "titulos de las primeras tres peliculas"
FROM movies
limit 3;
-- Mostrar el top 5 de las películas con mayor rating.
SELECT title "top 5"
FROM movies
ORDER BY rating desc
limit 5;
-- Listar los primeros 10 actores.
SELECT first_name, last_name
FROM actors
order by id
limit 10;
-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating
FROM movies
WHERE title like "Toy Story";
-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name, last_name
FROM actors
WHERE first_name like "Sam";
-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title
FROM movies
WHERE release_date
between "2004-01-01"
and "2008-12-31";
-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title
FROM movies
WHERE rating > 3
and awards > 1
and release_date BETWEEN "1988-01-01" and "2009-12-31"
ORDER BY rating asc;
