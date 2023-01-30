SELECT series.title, genres.name FROM series LEFT JOIN genres ON series.genre_id = genres.id;

SELECT episodes.title, actors.first_name, actors.last_name FROM episodes 
JOIN actor_episode ON actor_episode.actor_id = actors.id
JOIN 

SELECT  episodes.title, actors.first_name, actors.last_name FROM episodes 
JOIN actor_episode ON episodes.id = actor_episode.episode_id
JOIN actors ON actors.id = actor_episode.actor_id;

SELECT series.title, count(episodes.id) FROM series 
JOIN seasons ON seasons.serie_id = series.id 
JOIN episodes ON seasons.id = episodes.season_id Group by series.id;

SELECT genres.name,COUNT(genres.id) AS peliculas FROM genres 
JOIN movies ON genres.id = movies.genre_id
GROUP BY genre_id HAVING peliculas>3;

SELECT DISTINCT(actors.first_name), actors.last_name FROM movies
JOIN actor_movie ON movies.id = actor_movie.movie_id
JOIN actors ON actors.id = actor_movie.actor_id