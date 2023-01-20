-- 1. Agregar una película a la tabla movies.
INSERT INTO movies
VALUES
	(99, null, null, "Perro", 2.2, 0, "2019-11-10 00:00:00", 55, 2); 

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres
VALUES
	(99, "2019-11-10 00:00:00", null, "Malisima", 99, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 99
WHERE id = 99;

-- 4. Modificar la tabla actors para que al menos un actor tenga como
-- favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 99
WHERE id = 24;

-- 5. Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE temp_movies
AS (
	SELECT * FROM movies
);

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE
FROM temp_movies
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT ge.name
FROM genres ge
	JOIN movies mo
		ON mo.genre_id = ge.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT concat(ac.first_name, " ", ac.last_name) AS full_name, mo.title
FROM actors ac
	JOIN movies mo
		ON mo.id = ac.favorite_movie_id
WHERE mo.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.

CREATE
INDEX title_index
ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.

SHOW INDEXES IN movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices?
-- Analizar y justificar la respuesta.


-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
