-- mostrar  titulo y genero de todas las series
-- realcion uno a muchos

SELECT title, name
FROM series s JOIN genres g
ON s.genre_id = g.id;

-- mostrar el titulo de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos
-- relacion muchos a muchos

SELECT CONCAT(a.first_name, ' ' , a.last_name) "Full Name", e.title "Episode Title"
FROM actors a
JOIN actor_episode ap ON( a.id = ap.actor_id)
JOIN episodes e ON (ap.episode_id = e.id);

-- mostrar el titulo de todas las series y el total de temporadas  que tiene cada una de ellas

SELECT sr.title, (Select count(*) from seasons s where s.serie_id = sr.id) AS tot_seasons
fROM series sr;

-- mostrar el nombre de todos los generos y la cantidad de peliculas por cada una, siempre que sea mayor o igual a 3

SELECT g.name, (select count(*) from movies mo where mo.genre_id = g.id) AS tot_movies
FROM genres g
HAVING tot_movies >= 3;

-- mostrar solo el nombre y apellido de los actores que trabajan en todas las peliculas de la guerra de las galaxias y que estos no se repitan

SELECT DISTINCT ac.first_name, ac.last_name
FROM actors ac JOIN actor_movie actMov JOIN movies mo
ON ac.id = actMov.actor_id AND mo.id = actMov.movie_id
WHERE mo.title LIKE "%la guerra de las galaxias%";
