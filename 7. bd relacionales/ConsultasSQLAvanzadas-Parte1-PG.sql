USE movies_db;

/* Mostrar el título y el nombre del género de todas las series. */
SELECT m.title, g.name 
FROM movies m INNER JOIN genres g
ON m.genre_id = g.id;

/* Mostrar el título de los episodios, el nombre y apellido de 
	los actores que trabajan en cada uno de ellos. */
SELECT e.title,e.id, concat(a.first_name, " ", a.last_name) as "complete_name"
FROM episodes e INNER JOIN actor_episode ae INNER JOIN actors a
ON e.id = ae.episode_id AND a.id = ae.actor_id;

/* Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas. */
SELECT s.title, COUNT(*)
FROM series s INNER JOIN seasons sea 
ON s.id = sea.serie_id
GROUP BY title;

/* Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre 
	que sea mayor o igual a 3. */
SELECT g.name, COUNT(*) 
FROM genres g INNER JOIN movies m
ON g.id = m.genre_id
GROUP BY g.name;

/*Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas
	de la guerra de las galaxias y que estos no se repitan.*/
    
SELECT DISTINCT a.first_name, a.last_name
FROM actors a INNER JOIN actor_movie am
INNER JOIN movies m
ON a.id = am.actor_id AND m.id = am.movie_id AND m.title LIKE "La guerra de las galaxias%";

