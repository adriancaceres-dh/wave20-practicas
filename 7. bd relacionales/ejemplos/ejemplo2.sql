-- JOIN QUE CORRESPONDE A LA RELACION UNO A MUCHOS ENTRE ACTORS Y MOVIES
-- LAS PELICULAS FAVORITAS POR ACTOR
SELECT * FROM actors a JOIN movies m ON a.favorite_movie_id = m.id;

-- JOIN QUE CORRESPONDE A LA RELACION MUCHOS A MUCHOS ENTRE ACTORS Y MOVIES
-- LAS PELICULAS Y LOS ACTORES EN BASE A SI HABIAN PARTICIPADO O NO.
SELECT CONCAT(a.first_name, ' ', a.last_name) "Full Name", m.title "Movie Title", m.rating "Movie Rating", g.name "Genre Name"
FROM actors a 
	JOIN actor_movie am ON(a.id = am.actor_id)
	JOIN movies m ON(am.movie_id = m.id)
    JOIN genres g ON(m.genre_id = g.id)
WHERE m.rating >= 8.0
ORDER BY m.title desc;


SELECT COUNT(*) "Cant Apariciones", CONCAT(a.first_name, ' ', a.last_name) "Full Name" FROM actors a 
	JOIN actor_movie am ON(a.id = am.actor_id)
	JOIN movies m ON(am.movie_id = m.id)
WHERE a.first_name = "Sam"
GROUP BY a.first_name, a.last_name;

SELECT * FROM actors a 
	JOIN actor_movie am ON(a.id = am.actor_id)
	JOIN movies m ON(am.movie_id = m.id) WHERE first_name = "sam";
    
    
    
    
SELECT CONCAT(a.first_name, ' ', a.last_name) "Full Name", COUNT(*) "Cant Peliculas"
FROM actors a JOIN actor_movie am ON(a.id = am.actor_id) 
JOIN movies m ON(am.movie_id = m.id)
GROUP BY CONCAT(a.first_name, ' ', a.last_name)
ORDER BY 2 ASC;    

-- OPCION SUBCONSULTA

SELECT rating, first_name AS nombre
FROM actors
WHERE rating = (SELECT MIN(rating) FROM actors);

-- OPCION POR ORDENAMIENTO

SELECT first_name, rating FROM actors ORDER BY rating DESC LIMIT 1;


SELECT * FROM actors;


SELECT COUNT(*) AS tot_act, mo.title, mo.rating, mo.awards
FROM movies mo JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY title HAVING tot_act > 2;
    
-- PRIMERO SE EJECUTA EL FROM Y ON
-- SEGUNDO SE EJECUTA EL WHERE
-- TERCERO SE EJECUTA EL GROUP BY
-- CUARTO SE EJECUTA EL HAVING LUEGO DE HABER EJECUTADO FUNCIONES DE AGREGACION