-- Mostrar el título y el nombre del género de todas las series.
SELECT title, g.name "genero" 
FROM series s INNER JOIN genres g
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, ac.first_name, ac.last_name FROM actor_episode
INNER JOIN actors ac ON actor_episode.actor_id = ac.id
INNER JOIN episodes e ON actor_episode.episode_id = e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(*) "Temporadas" FROM seasons
JOIN series ON seasons.serie_id = series.id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(*) AS cantidad_peliculas FROM movies m 
JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING cantidad_peliculas > 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT ac.first_name, ac.last_name FROM actor_movie am
JOIN actors ac ON ac.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE "%guerra de las galaxias%";