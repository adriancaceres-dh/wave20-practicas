-- título y el nombre del género de todas las series
SELECT sr.title as "título",gr.name as "nombreGenero" FROM series as sr
INNER JOIN genres as gr 
ON sr.genre_id= gr.id;

-- título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ello
SELECT eps_filter.eps_title as "tituloEpisodio", act.first_name as "nombre", act.last_name as "apellido"
FROM(
	SELECT eps.title as eps_title,act_eps.actor_id as actor_id 
	FROM episodes as eps
	INNER JOIN actor_episode as act_eps
	ON eps.id= act_eps.episode_id
    )as eps_filter
INNER JOIN actors as act ON eps_filter.actor_id=act.id
;

--  título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title,COUNT(seasons.id) as "total temporadas" FROM seasons 
INNER JOIN series 
ON seasons.serie_id= series.id
GROUP BY series.id;

-- nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.id) as total_peliculas FROM genres 
INNER JOIN movies 
ON genres.id= movies.genre_id
GROUP BY genres.id
HAVING total_peliculas>=3;

-- el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan
SELECT mv_act.name_actor as "Nombre actor", mv_act.lstname_actor as "Apellido actor" 
FROM(
	SELECT act_mv.id as id_movie,act.first_name as name_actor,act.last_name as lstname_actor,act.id as act_id 
	FROM actor_movie as act_mv
	INNER JOIN actors as act
	ON act_mv.actor_id= act.id
    )as mv_act
INNER JOIN movies as mv ON mv.id=mv_act.id_movie
WHERE mv.title LIKE "%guerra de las galaxias%"
GROUP BY mv_act.act_id;
