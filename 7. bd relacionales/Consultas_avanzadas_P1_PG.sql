SELECT se.title, gen.name 
FROM series se 
JOIN genres gen
ON se.genre_id = gen.id;

SELECT e.title, ac.first_name, ac.last_name 
FROM episodes e
JOIN actor_episode ae ON e.id = ae.episode_id
JOIN actors ac ON ae.actor_id = ac.id ;

SELECT se.title, COUNT(*) 
FROM series se 
JOIN seasons sea
ON se.id = sea.serie_id
GROUP BY se.title;

SELECT ge.name, COUNT(*) AS CantidadDePeliculas
FROM genres ge
JOIN movies mov
ON ge.id = mov.genre_id
GROUP BY ge.name
HAVING CantidadDePeliculas >= 3;

SELECT DISTINCT ac.first_name, ac.last_name 
FROM actors ac
JOIN actor_movie acmov ON ac.id = acmov.actor_id
JOIN movies mov ON mov.id = acmov.movie_id
WHERE mov.title LIKE "%la guerra de las galaxias%";

SELECT DISTINCT CONCAT(act.first_name, act.last_name) "full_name"
FROM actors act
INNER JOIN actor_movie am ON act.id = am.actor_id
INNER JOIN movies mo ON am.movie_id = mo.id
WHERE mo.title LIKE "%la guerra de las galaxias%";
