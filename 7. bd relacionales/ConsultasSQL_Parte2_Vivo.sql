use movies_db;

-- Query 1: Mostrar todos los registros de la tabla de movies. 
SELECT movies.id, movies.created_at, movies.updated_at, movies.title, 
movies.rating, movies.awards, movies.release_date, movies.`length`, 
movies.genre_id
FROM movies;

-- Query 2: Mostrar el nombre, apellido y rating de todos los actores.
SELECT actors.first_name as "First Name", actors.last_name as "Last Name"
FROM actors;

-- Query 3: Mostrar el título de todas las series y usar alias para que 
tanto el nombre de la tabla como el campo estén en español.
SELECT series.title  as Titulo
FROM series;


-- Query 4: Mostrar el nombre y apellido de los actores cuyo rating sea 
mayor a 7.5.
SELECT actors.first_name as "First Name", actors.last_name as "Last Name"
FROM actors
WHERE actors.rating > 7.5;


-- Query 5: Mostrar el título de las películas, el rating y los premios de 
las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT actors.first_name as "First Name", actors.last_name as "Last Name"
FROM actors JOIN actor_movie ON actors.id = actor_movie.actor_id JOIN 
movies ON movies.id = actor_movie.movie_id
WHERE actors.rating > 7.5 and movies.awards >2;

-- Query 6: Mostrar el título de las películas y el rating ordenadas por 
rating en forma ascendente.
SELECT movies.title, movies.rating 
FROM movies 
ORDER BY movies.rating;

-- Query 7: Mostrar los títulos de las primeras tres películas en la base 
de datos.
SELECT movies.title 
FROM movies 
LIMIT 3;

-- Query 8: Mostrar el top 5 de las películas con mayor rating.
SELECT movies.title 
FROM movies 
ORDER BY movies.rating DESC
LIMIT 5;

-- Query 9: Listar los 10 primeros actores
SELECT actors.first_name as "First Name", actors.last_name as "Last Name"
FROM actors 
LIMIT 10;

-- Query 10: Mostrar el título y rating de todas las películas cuyo título 
sea de Toy Story.
SELECT movies.title, movies.rating 
FROM movies 
WHERE movies.title LIKE '%Toy Story%';

-- Query 11: Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT actors.first_name as "First Name", actors.last_name as "Last Name"
FROM actors 
WHERE actors.first_name  LIKE 'Sam%';

-- Query 12: Mostrar el título de las películas que salieron entre el 2004 
y 2008..
SELECT movies.title
FROM movies 
WHERE YEAR(movies.release_date)  BETWEEN 2001 AND 2004;

-- Query 13: Traer el título de las películas con el rating mayor a 3, con 
más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. 
Ordenar los resultados por rating.
SELECT movies.title
FROM movies 
WHERE movies.rating > 3 AND movies.awards AND YEAR(movies.release_date)  
BETWEEN 1988 AND 2009;
