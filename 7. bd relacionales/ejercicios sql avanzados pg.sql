-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s INNER JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, concat(a.first_name, ' ', a.last_name) "full name" 
FROM episodes e 
LEFT JOIN actor_episode ae 
ON e.id = ae.episode_id 
INNER JOIN  actors a
ON ae.actor_id = a.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) as seasons
FROM series s
INNER JOIN seasons seasons
ON s.id = seasons.serie_id
GROUP BY seasons.serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) as quantity_movies
FROM genres g
LEFT JOIN movies m
ON g.id = m.genre_id
GROUP BY g.name
HAVING quantity_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT CONCAT(a.first_name, ' ', a.last_name) "Full name", a.id
FROM actors a
INNER JOIN actor_movie am
ON a.id = am.actor_id
INNER JOIN movies m
ON am.movie_id = m.id and m.title LIKE '%la guerra de las galaxias%';

