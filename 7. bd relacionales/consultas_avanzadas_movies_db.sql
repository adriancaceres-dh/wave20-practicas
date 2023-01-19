-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title,g.name as genre
FROM series s
INNER JOIN genres g 
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title,a.first_name,a.last_name
FROM actor_episode ae
INNER JOIN actors a
ON ae.actor_id = a.id
INNER JOIN episodes e
ON ae.episode_id = e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT count(*),s.title 
FROM seasons sea
INNER JOIN series s
ON sea.serie_id = s.id
GROUP BY s.title
;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name,count(*) as movies
FROM movies m
INNER JOIN genres g 
ON g.id = m.genre_id
GROUP BY g.name
HAVING movies > 3;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT concat(a.first_name,' ',a.last_name) as full_name
FROM actors a
INNER JOIN actor_movie 
ON a.id = actor_movie.actor_id
INNER JOIN movies m
ON m.id = actor_movie.movie_id
WHERE m.title 
LIKE '%La guerra de las galaxias%';