-- SEGUNDA PARTE
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title "Title", g.name "Genre" FROM
series s JOIN genres g ON(s.genre_id = g.id);

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title "Title", CONCAT(a.first_name, ' ', a.last_name) "Full Name" FROM
episodes e JOIN actor_episode ae ON(e.id = ae.episode_id)
JOIN actors a ON(ae.actor_id = a.id);

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title "Title", COUNT(sea.id) "Seasons" FROM
series ser JOIN seasons sea ON(ser.id = sea.serie_id)
GROUP BY ser.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name "Genre", COUNT(m.id) "Movie Count" FROM
movies m JOIN genres g ON(m.genre_id = g.id)
GROUP BY g.name
HAVING COUNT(m.id) > 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
-- la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT CONCAT(first_name, ' ', last_name) "Full Name" FROM
movies m JOIN actor_movie am ON(m.id = am.movie_id)
JOIN actors a ON(am.actor_id = a.id)
WHERE title LIKE "La Guerra de las Galaxias%";
