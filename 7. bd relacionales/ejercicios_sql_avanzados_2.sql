-- Agregar una película a la tabla movies.

INSERT INTO MOVIES 
(title,rating,awards,release_date,genre_id) 
VALUES 
('Metegol',8.0,3,'2003-04-04',5);

select * from movies; 

-- Agregar un género a la tabla genres.

INSERT INTO GENRES
(name,ranking,created_at)
VALUES
('Deporte',13,'2023-01-19');




-- Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE MOVIES m  
SET genre_id = 13 
WHERE m.id = 22;


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE ACTORS a
SET a.favorite_movie_id = 22
WHERE a.id = 1 ;

-- Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE MOVIES_COPY
AS (SELECT * FROM MOVIES);

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM MOVIES_COPY m 
WHERE m.awards < 5;
 
-- Obtener la lista de todos los géneros que tengan al menos una película.

SELECT g.name FROM Movies_Copy m
INNER JOIN Genres g 
ON m.genre_id = g.id
GROUP BY g.name;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.first_name,a.last_name FROM Actors a 
INNER JOIN  Movies_Copy m
ON (a.favorite_movie_id = m.id )
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX title on movies(title);

-- Chequee que el índice fue creado correctamente.

SHOW INDEX FROM MOVIES;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

SELECT m.title FROM MOVIES m ORDER BY m.title ;
-- query cost : 2.45

DROP INDEX title ON MOVIES;

SELECT m.title FROM MOVIES m ORDER BY m.title ;
-- query cost : 24.45
-- rta : El costo de la consulta aumenta mucho al eliminar el indice

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- rta : Crearia un indice cada vez que necesite ordenar un resultado por una columna

