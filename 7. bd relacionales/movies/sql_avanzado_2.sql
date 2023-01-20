-- Usar movies_db.
USE movies_db;

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies
VALUES (22, "2022-01-20", "2022-01-20", "La guerra de las galaxias: Episodio V", 9.7, 5, "1980-12-25", 124, null);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres
VALUES (13, "2022-01-20", "2022-01-20", "Clásicos", 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE first_name LIKE "Mark" AND last_name LIKE "Hamill";

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (
	id INT NOT NULL PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR(500) NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    awards INT NOT NULL,
    release_date DATETIME NOT NULL,
    length INT,
    genre_id INT
);

INSERT INTO movies_copy
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id 
FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.created_at, g.updated_at, g.name, g.ranking, g.active, COUNT(*) AS movie_count
FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id
GROUP BY g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.id, a.created_at, a.updated_at, a.first_name, a.last_name, a.rating, a.favorite_movie_id
FROM actors AS a
INNER JOIN movies AS m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index
ON movies (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Creo que sí podría existir una mejora notable si se crean índices en campos que se utilicen frecuentemente para el filtrado de las películas, y, sobre todo, si la tabla tuviera muchos más registros.
-- Campos como: "awards" o "release_date".

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta.
-- Crearía un índice en la tabla "actores", probablemente en el campo "rating".
-- Creo que la tabla "actores" es igualmente usada para realizar consultas frecuentes, como el filtrado por "rating"; el index en ese campo podría optimizar las búsquedas.