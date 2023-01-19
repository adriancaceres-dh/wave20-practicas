-- 1. Mostrar el título y el nombre del género de todas las series.

SELECT se.title, ge.name
FROM series se
	INNER JOIN genres ge
		ON se.genre_id = ge.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido
-- de los actores que trabajan en cada uno de ellos.

SELECT ep.title, concat(ac.first_name, " ", ac.last_name) as full_name
FROM actor_episode
	INNER JOIN actors ac
		ON actor_episode.actor_id = ac.id
	INNER JOIN episodes ep
		ON actor_episode.episode_id = ep.id;
        
-- 3. Mostrar el título de todas las series y el total de temporadas
-- que tiene cada una de ellas.

SELECT COUNT(*) AS cantidad_temporadas, se.title 
FROM seasons ss
  INNER JOIN series se
	ON se.id = ss.serie_id
GROUP BY se.title;
  
-- 4. Mostrar el nombre de todos los géneros y la cantidad total
-- de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT COUNT(*) AS cantidad_peliculas, ge.name
FROM movies mo
  INNER JOIN genres ge
	ON ge.id = mo.genre_id
GROUP BY ge.name
HAVING COUNT(*) >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan
-- en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac
	INNER JOIN actor_movie
		ON actor_movie.actor_id = ac.id
	INNER JOIN movies mo
		ON actor_movie.movie_id = mo.id
WHERE mo.title LIKE "%galaxias%";
