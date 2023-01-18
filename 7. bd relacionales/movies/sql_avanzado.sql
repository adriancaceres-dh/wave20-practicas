-- Usar movies_db.
USE movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS series_title, g.name AS genre_name
FROM series AS s
LEFT JOIN genres AS g ON g.id = s.genre_id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title AS episode_title, a.first_name AS actor_first_name, a.last_name AS actor_last_name
FROM episodes AS e
LEFT JOIN actor_episode AS axe ON axe.episode_id = e.id
LEFT JOIN actors AS a ON a.id = axe.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title AS series_title, COUNT(*) AS season_count
FROM series AS s
LEFT JOIN seasons AS se ON se.serie_id = s.id
GROUP BY s.id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name AS genre_name, COUNT(*) AS movie_count
FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id
GROUP BY g.id
HAVING movie_count >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors AS a
LEFT JOIN actor_movie AS axm ON axm.actor_id = a.id
LEFT JOIN movies AS m ON m.id = axm.movie_id
WHERE m.title LIKE "%guerra de las galaxias%"
GROUP BY a.id;