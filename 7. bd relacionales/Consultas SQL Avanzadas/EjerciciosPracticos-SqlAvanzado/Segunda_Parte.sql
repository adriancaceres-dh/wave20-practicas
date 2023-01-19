/*
Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
*/

-- Mostrar el título y el nombre del género de todas las series.
SELECT title, name
FROM movies_db.series as s
INNER JOIN movies_db.genres as g
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT ep.title,a.first_name, a.last_name
FROM movies_db.episodes as ep
JOIN movies_db.actor_episode as aep
ON ep.id = aep.episode_id
JOIN movies_db.actors as a
ON aep.actor_id = a.id;