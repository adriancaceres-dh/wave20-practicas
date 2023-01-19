1) Mostrar el titulo y el nombre del genero de todas las series.
Consulta:

SELECT title, name
FROM movies INNER JOIN genres ON genres.id = movies.genre_id;

2) Mostrar el titulo de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
Consulta:

SELECT title, first_name, last_name name
FROM actors, episodes INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id;

3) Mostrar el titulo de todas las series y el total de temporadas que tiene cada una de ellas.
Consulta:

SELECT COUNT(*) AS cant_temporadas, seri.title 
FROM series seri INNER JOIN seasons ON seri.id = seasons.serie_id
GROUP BY seri.title;


4) Mostrar el nombre de todos los generos y la cantidad total de peliculas por cada uno, siempre que sea mayor o igual a 3.
Consulta:

SELECT COUNT(*), g.name 
FROM movies INNER JOIN genres g ON g.id = movies.genre_id
GROUP BY g.name
HAVING COUNT(*) >= 3;

5) Mostrar solo el nombre y apellido de los actores que trabajan en todas las peliculas de la guerra de las galaxias y que estos no se repitan.
Consulta:

SELECT DISTINCT(CONCAT(act.first_name, ' ', act.last_name)) "Full Name"
FROM actors act INNER JOIN actor_movie actmov ON (act.id = actmov.actor_id)
JOIN movies mov ON actmov.movie_id = mov.id
WHERE mov.title LIKE "%guerra de las galaxias%";

