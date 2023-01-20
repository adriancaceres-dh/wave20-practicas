-- DML (DATA MANAGEMENT LANGUAGE)

-- SELECT de todos los atributos

SELECT * FROM actors;

-- SELECT de algunos atributos

SELECT id, first_name, last_name, rating FROM actors;

-- Titulo de series en espaniol
SELECT title as titulo FROM series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5

SELECT first_name, last_name FROM actors WHERE rating > 7.5;

-- Mostrar el título de las peliculas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios

SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente

SELECT title, rating FROM movies ORDER BY rating ASC;

-- Mostrar los títulos de las primeras tres películas en la base de datos

SELECT title FROM movies LIMIT 3;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story

SELECT title, rating FROM movies WHERE title LIKE "%toy story%";

-- Mostrar a todos los actores cuyos nombres empiezan con Sam

SELECT first_name, last_name FROM actors WHERE first_name LIKE "Sam%";

-- Mostrar el título de todas las películas que salieron entre el 2004 y 2008

SELECT title FROM movies WHERE YEAR(release_date) BETWEEN 2004 AND 2008;

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 y 2009. Ordenar los resultados por rating

SELECT title as release_year FROM movies
WHERE rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN 1988 AND 2009 
ORDER BY rating DESC; 

