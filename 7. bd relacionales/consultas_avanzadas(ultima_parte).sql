

Ejercicio avanzado

1) Agregar una película a la tabla movies.
Consulta:

INSERT INTO movies (id, created_at, updated_at, title, rating, awards, release_date,length,genre_id) VALUES (22, null,null,"maria de las nieves", 8.9,2, "2015-05-02",120,5);


2) Agregar un género a la tabla genres.
Consulta:

INSERT INTO genres (id,created_at,updated_at,name,ranking,active) VALUES (13,"2023-01-20",null,"thirller",13,1);


3) Asociar a la película del punto 1. genre el género creado en el punto 2.
Consulta:

UPDATE movies SET genre_id=13 WHERE id=22;

4) Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Consulta:

UPDATE actors SET favorite_movie_id=13 WHERE id=49;

5) Crear una tabla temporal copia de la tabla movies.
Consulta: 

Para crearla:

CREATE
TEMPORARY TABLE temp_movies LIKE movies;

Para agregar los datos de la table movies a la tabla temporal:

INSERT INTO temp_movies
SELECT *
FROM movies;

6) Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Consulta:

DELETE FROM temp_movies WHERE awards < 5;

7) Obtener la lista de todos los géneros que tengan al menos una película.
Consulta:

SELECT distinct(gen.name), gen.ranking
FROM genres gen INNER JOIN movies mov ON gen.id = mov.genre_id;

8) Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Consulta:

SELECT distinct(act.first_name), act.last_name
FROM actors act INNER JOIN movies mov ON act.favorite_movie_id = mov.id
WHERE mov.awards > 3;

9) Crear un índice sobre el nombre en la tabla movies.
Consulta:

create index IDX_Nombre
ON movies(title);

10) Chequee que el índice fue creado correctamente.
Consulta: 

SHOW INDEX FROM movies;

11) En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
Consulta: 
Los indices nos permiten hacer consultas de forma mas optima, por lo que al agregar un indice en la tabla movies y realizar una búsqueda esto mejorara el tiempo de búsqueda.

12) ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
Consulta:

Podría indices en una tabla donde existan muchos registros para que sea mas optima la búsqueda como por ejemplo en este acaso la tabla actors.
