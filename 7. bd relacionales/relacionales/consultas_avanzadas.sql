-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s INNER JOIN genres g ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes as e 
JOIN actor_episode as ae ON e.id = ae.episode_id
JOIN actors a ON a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT ser.title, count(*) "total seasons" FROM series ser JOIN seasons sea ON ser.id = sea.serie_id GROUP BY ser.title; 

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT g.name, count(*) "total_movies" FROM genres g JOIN movies m ON m.genre_id = g.id GROUP BY g.name HAVING total_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name FROM actors a JOIN actor_movie ac ON a.id = ac.actor_id JOIN movies m ON m.id = ac.movie_id WHERE m.title LIKE "%la guerra de las galaxias%";


