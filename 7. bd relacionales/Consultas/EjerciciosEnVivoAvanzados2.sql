-- Mostrar el título y el nombre del género de todas las series.
SELECT se.title, gen.name
FROM series se
INNER JOIN genres gen
ON se.genre_id = gen.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, act.first_name, act.last_name
FROM episodes ep
INNER JOIN actor_episode ae ON ep.id = ae.episode_id
INNER JOIN actors act ON ae.actor_id = act.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title, COUNT(*)
FROM series se
INNER JOIN seasons seas
ON se.id = seas.serie_id
GROUP BY se.title;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name, COUNT(*) as Cantidad_Peliculas
FROM genres ge
INNER JOIN movies mo
ON ge.id = mo.genre_id
GROUP BY ge.id
HAVING Cantidad_Peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT CONCAT(act.first_name, act.last_name) "full_name"
FROM actors act
INNER JOIN actor_movie am ON act.id = am.actor_id
INNER JOIN movies mo ON am.movie_id = mo.id
WHERE mo.title LIKE "%la guerra de las galaxias%";
