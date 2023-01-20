
-- Mostrar el título y el nombre del género de todas las series.
SELECT title, name
FROM series as s
INNER JOIN genres as g
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title,a.first_name, a.last_name
FROM episodes as ep
JOIN actor_episode as aep
ON ep.id = aep.episode_id
JOIN actors as a
ON aep.actor_id = a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT seasons.serie_id, series.title as "TITULO", COUNT(seasons.serie_id) as "TOTAL DE TEMPORADAS"
FROM seasons 
JOIN series  
ON seasons.serie_id = series.id
GROUP BY serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.id, g.name as "GENERO", count(g.id) as "CANTIDAD DE PELICULAS"
FROM genres as g
JOIN movies as m 
ON g.id = m.genre_id
GROUP BY g.id;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name, m.title
FROM actor_movie as am
JOIN movies as m
ON am.movie_id = m.id
JOIN actors as ac
ON am.actor_id = ac.id
WHERE m.title LIKE "La Guerra%";