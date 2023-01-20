-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title as serie, g.name as genre
FROM series s
	JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title as episode, concat(a.first_name, " ", a.last_name) as actor
FROM episodes e
	JOIN actor_episode ae ON e.id = ae.episode_id
	JOIN actors a ON ae.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title as serie, count(1) as seasons
FROM series
	JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(1) as total_movies
FROM genres g
	JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING total_movies > 3;


-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT concat(first_name, " ", last_name) as actor
FROM actors a
	JOIN actor_movie am ON a.id = am.actor_id
	JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE "%Guerra de las Galaxias%"
GROUP BY a.id
HAVING count(1) = (SELECT count(1) FROM movies WHERE title LIKE "%Guerra de las Galaxias%");