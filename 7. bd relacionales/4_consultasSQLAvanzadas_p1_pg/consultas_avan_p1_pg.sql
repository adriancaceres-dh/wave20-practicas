-- Mostrar el título y el nombre del género de todas las series.

SELECT se.title, ge.name
FROM series se INNER JOIN genres ge
ON se.genre_id = ge.id;

SELECT * from actors;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT ep.title, ac.first_name, ac.last_name
FROM episodes ep INNER JOIN actor_episode actEpi
ON ep.id = actEpi.episode_id
INNER JOIN actors ac 
ON actEpi.actor_id = ac.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT ser.title, COUNT(1)
FROM series ser, seasons sea
WHERE ser.id = sea.serie_id
GROUP BY ser.id;

SELECT * FROM SERIES;
SELECT * FROM SEASONS;
SELECT COUNT(1) FROM seasons sea WHERE serie_id = 2;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT ge.name, COUNT(1) cantPeli
FROM genres ge, movies mo
WHERE mo.genre_id = ge.id
GROUP BY ge.name
HAVING cantPeli >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac JOIN actor_movie actMov JOIN movies mo
ON ac.id = actMov.actor_id AND mo.id = actMov.movie_id
WHERE mo.title LIKE "%la guerra de las galaxias%";

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac INNER JOIN actor_movie actMov
ON ac.id = actMov.actor_id
INNER JOIN movies mo 
ON mo.id = actMov.movie_id
WHERE mo.title LIKE "%la guerra de las galaxias%";

-- Sacar el actor con mas rating y su nombre - No es muy buena opcion con subconsulta

SELECT rating, first_name
FROM actors
WHERE rating = (SELECT MIN(rating) from actors);

SELECT first_name, rating FROM actors ORDER BY rating DESC LIMIT 1;

