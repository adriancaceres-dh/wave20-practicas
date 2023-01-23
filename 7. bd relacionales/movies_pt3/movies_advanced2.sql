-- Ejercicio Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies
INSERT INTO movies (id, title, rating, awards, release_date)
VALUES (22, "Everything Everywhere All At Once", 9.5, 7, "2022-03-11");


-- Agregar un género a la tabla genres.
INSERT INTO genres (id, name, ranking, active)
VALUES (13, "Comedia Negra", 13, 1);


-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;


-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 13;


-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp (
SELECT * FROM movies
);


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp
WHERE awards <= 5;


-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(*) as cantidad_peliculas FROM genres g 
JOIN movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING COUNT(*) > 1;


-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT CONCAT(ac.first_name, " ", ac.last_name) "Nombre" FROM actors ac 
JOIN movies m ON ac.favorite_movie_id = m.id
WHERE m.awards > 3;


-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx
ON movies (title);


-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;


-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Podría existir una mejora notable en cuanto al costo en las consultas, sobre todo si la tabla tuviera muchos mas registros o sea consultada con mucha frecuencia


-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía un índice en la tabla actores ya que es una de las tablas que más frecuentemente se ha consultado durante todos los ejercicios

