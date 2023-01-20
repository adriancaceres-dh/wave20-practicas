-- Consultas SQL Avanzado

-- 1) Mostrar el título y el nombre del género de todas las series.
-- 2) Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
-- 3) Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
-- 4) Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
-- 5) Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

select title, name as genre from movies_db.series inner join movies_db.genres on series.genre_id = genres.id;

select title as titulo, first_name as nombre, last_name as apellido 
from actors inner join actor_episode inner join episodes on actor_episode.actor_id = actors.id AND actor_episode.episode_id = episodes.id;

select series.title, MAX(number) from series left join seasons on seasons.serie_id = series.id group by series.title;

select name, COUNT(*) as peliculas from genres join movies on movies.genre_id = genres.id group by name having peliculas >= 3;

select distinct first_name as nombre, last_name as apellido from movies inner join actor_movie on movies.id = actor_movie.movie_id inner join 
actors on actors.id = actor_movie.actor_id where movies.title like '%la guerra de las galaxias%' group by actors.id, first_name, last_name
having count(movies.id) = (select count(movies.id) from movies where movies.title like '%la guerra de las galaxias%');

 -- Mejoro la query anterior
SELECT DISTINCT act.first_name, act.last_name FROM actors AS act JOIN actor_movie AS act_mov JOIN movies AS mo ON 
(act.id = act_mov.actor_id AND act_mov.movie_id = mo.id AND mo.title LIKE "%La guerra de las galaxias%");


