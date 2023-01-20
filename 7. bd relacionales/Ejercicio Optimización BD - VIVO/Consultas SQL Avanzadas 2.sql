# 1. Agregar una película a la tabla movies.
SELECT * FROM movies;
#INSERT INTO movies VALUE (33,null,null, "La marca", 8.3, 2, "2010-09-10", 4, 2);

# 2. Agregar un género a la tabla genres.
SELECT * FROM genres;
#INSERT INTO genres VALUE (13,"1997-09-10", null, "Ficcion", 13, 2);

# 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id=33; 

# 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 33 WHERE id=8;


# 5. Crear una tabla temporal copia de la tabla movies.
# CREATE TEMPORARY TABLE copia_movies(SELECT * FROM movies);
SELECT * FROM copia_movies;

# 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM copia_movies WHERE awards<5;
SELECT * FROM copia_movies;

# 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT gn.* FROM genres AS gn, movies AS mo WHERE (mo.genre_id = gn.id) GROUP BY gn.id;


# 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT act.* FROM actors AS act JOIN movies AS mo ON(act.favorite_movie_id = mo.id) WHERE awards>3;

# 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX titulos_peliculas ON movies(title);

# 10. Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;

# 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.


# 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

