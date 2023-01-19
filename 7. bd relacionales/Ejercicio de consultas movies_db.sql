USE movies_db;

-- SELECT series.title, genres.name From series INNER JOIN genres ON series.genre_id = genres.id;

-- SELECT episodes.title, actors.first_name, actors.last_name FROM episodes INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id INNER JOIN actors ON actors.id = actor_episode.actor_id;

-- SELECT series.title, COUNT(series.title) as cant_temporadas From series INNER JOIN seasons ON series.id = seasons.serie_id GROUP BY series.title;

-- SELECT genres.name, COUNT(movies.title) as total from genres INNER JOIN movies ON movies.genre_id = genres.id GROUP BY genres.name HAVING total >= 3;

-- SELECT actors.first_name, actors.last_name, movies.title FROM actors INNER JOIN actor_movie ON actors.id = actor_movie.actor_id INNER JOIN movies ON movies.id = actor_movie.movie_id WHERE movies.title LIKE "%la guerra de las galaxias%";

