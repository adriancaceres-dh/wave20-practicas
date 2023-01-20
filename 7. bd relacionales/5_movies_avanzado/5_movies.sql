SELECT title, name
FROM series AS S
INNER JOIN genres AS G
WHERE S.genre_id = G.id;

SELECT title, concat(first_name," ",last_name) AS full_name
FROM episodes AS e
INNER JOIN actor_episode AS ae
ON e.id = ae.episode_id
INNER JOIN actors AS a
ON a.id = ae.actor_id
ORDER BY title, first_name;

SELECT s.title, COUNT(*) AS cant_seasons
FROM series AS s
INNER JOIN seasons AS sn
ON sn.serie_id = s.id
GROUP BY s.title;

SELECT name, COUNT(*) AS cant
FROM genres AS g
INNER JOIN movies as m
ON g.id = m.genre_id
GROUP BY name
HAVING cant>=3;

SELECT DISTINCT(concat(first_name," ",last_name)) AS full_name
FROM actors AS a
INNER JOIN actor_movie AS am
ON a.id = am.actor_id
INNER JOIN movies AS m
ON m.id = am.movie_id
WHERE m.title LIKE "La Guerra de las galaxias%";