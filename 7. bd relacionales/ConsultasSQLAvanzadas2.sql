USE movies_db;

/* Agregar una película a la tabla movies. */
INSERT INTO movies(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES(null, null, "Pelicula", 8.0, 1, "2022-12-01", 120, 4);

/* Agregar un género a la tabla genres. */
INSERT INTO genres(created_at, updated_at, name, ranking, active)
VALUES(NOW(), null, "Genero", 13, 1);

/* Asociar a la película del punto 1. genre el género creado en el punto 2. */
UPDATE movies SET genre_id = 13 WHERE id = 22;

/* Modificar la tabla actors para que al menos un actor tenga como favorita 
	la película agregada en el punto 1.
 */
 UPDATE actors SET favorite_movie_id = 24 WHERE id = 22;
 
 /* Crear una tabla temporal copia de la tabla movies. */
 CREATE TEMPORARY TABLE movies_copy(id int, created_at timestamp, updated_at timestamp, 
 title varchar(500), rating decimal(3,1), awards int, release_date timestamp, length int,
 genre_id int);
 
 INSERT INTO movies_copy
 SELECT * FROM movies;
 
 SELECT * FROM movies_copy;
 
 /* Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */
 DELETE FROM movies_copy WHERE awards < 5;
 
 /* Obtener la lista de todos los géneros que tengan al menos una película. */
 SELECT DISTINCT g.id, g.name FROM movies m 
 INNER JOIN genres g
 ON m.genre_id = g.id;
 
 /* Obtener la lista de actores cuya película favorita haya ganado más de 3 awards. */
 SELECT a.id, concat(first_name, " ", last_name) FROM actors a
 INNER JOIN movies m
 ON a.favorite_movie_id = m.id AND m.awards > 3;
 
 /* Crear un índice sobre el nombre en la tabla movies. */
 CREATE INDEX movies_name
 ON movies(title);
 
 /* Chequee que el índice fue creado correctamente. */
 SHOW INDEX FROM movies;
 
 