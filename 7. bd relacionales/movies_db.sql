-- Mostrar el título y el nombre del género de todas las series.
SELECT title, g.name 
FROM series 
INNER JOIN genres g 
ON genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name
from series 
inner join seasons 
on series.id = seasons.serie_id 
inner join episodes 
on episodes.season_id = seasons.id
inner join actor_episode 
on actor_episode.episode_id = episodes.id
inner join actors
ON actor_episode.actor_id = actors.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(*) AS seasons 
FROM series
INNER JOIN seasons
ON serie_id = series.id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name AS genre, count(*) AS movies 
FROM movies
INNER JOIN genres
ON genre_id = genres.id
GROUP BY genre
HAVING movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT  a.first_name, a.last_name from movies
inner join actor_movie
on movie_id = movies.id
inner join actors a
on actor_id = a.id
where movies.title like "la guerra de las galaxias%"
GROUP BY a.id;
