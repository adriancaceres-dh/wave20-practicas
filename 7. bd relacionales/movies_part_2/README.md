### Segunda parte

- Mostrar el título y el nombre del género de todas las series.
~~~~sql
SELECT title, genres.name AS genero FROM series
    JOIN genres ON genres.id = series.genre_id;
~~~~

- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
~~~~sql
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes
  JOIN actor_episode ON episodes.id = actor_episode.episode_id
  JOIN actors ON actors.id = actor_episode.actor_id;
~~~~

- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

~~~~sql
SELECT COUNT(*) AS cantidad_temporadas, series.title 
  FROM seasons
  JOIN series ON series.id = seasons.serie_id
  GROUP BY series.title;
~~~~

- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

~~~~sql
SELECT genres.name, COUNT(*) AS cantidad_peliculas FROM movies
  JOIN genres ON genres.id = movies.genre_id
  GROUP BY genres.name
  HAVING cantidad_peliculas > 3;
~~~~

- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
~~~~sql
  SELECT DISTINCT actors.first_name, actors.last_name FROM actors
  JOIN actor_movie ON actor_movie.actor_id = actors.id
  JOIN movies ON actor_movie.movie_id = movies.id
  WHERE movies.title LIKE "%galaxia%"
~~~~

