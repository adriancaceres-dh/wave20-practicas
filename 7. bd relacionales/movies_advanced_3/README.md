## Ejercicio - Consultas Sql Avanzadas a movies_db

Resolver las siguientes consignas, tomando la base de datos movies_db.sql, se solicita:

- Agregar una película a la tabla movies.

~~~~sql
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES ("2023-01-20", "2023-01-20", "Best movie ever", 9.9, 15, "2022-01-01 00:00:00", 115, null);
~~~~

- Agregar un género a la tabla genres.

~~~~sql
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES ("2023-01-20", "2023-01-20", "Biografia", 13, 1);
~~~~

- Asociar a la película del punto 1. genre el género creado en el punto 2.

~~~~sql
  UPDATE movies
  SET genre_id = 13
  WHERE title = "Best movie ever";
~~~~

- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

~~~~sql
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 3;
~~~~

- Crear una tabla temporal copia de la tabla movies.

~~~~sql
CREATE
TEMPORARY TABLE temp_movies LIKE movies; -- crear una tabla vacía con la misma definicion de columnas
    
-- https://stackoverflow.com/questions/9206433/best-way-to-create-a-temp-table-with-same-columns-and-type-as-a-permanent-table
~~~~

~~~~sql
INSERT INTO temp_movies
SELECT *
FROM movies;
~~~~

- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

~~~~sql
DELETE
FROM temp_movies
WHERE awards <= 5;
~~~~


- Obtener la lista de todos los géneros que tengan al menos una película.

~~~~sql
SELECT genres.name
FROM genres
         JOIN movies ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING COUNT(*) > 1;
~~~~

```
+-----------------+----------+
| name            | COUNT(*) |
+-----------------+----------+
| Drama           | 3        |
| Ciencia Ficcion | 5        |
| Animacion       | 4        |
| Aventuras       | 3        |
| Infantiles      | 2        |
+-----------------+----------+
```

- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

~~~~sql
SELECT actors.first_name, actors.last_name, movies.title, movies.awards
FROM actors
         JOIN movies ON movies.id = actors.favorite_movie_id
WHERE movies.awards > 3;
~~~~

```
+------------+------------+-----------------------------------------+--------+
| first_name | last_name  | title                                   | awards |
+------------+------------+-----------------------------------------+--------+
| Zoe        | Saldana    | Titanic                                 | 11     |
| Mia        | Wasikowska | Titanic                                 | 11     |
| Johnny     | Galecki    | Titanic                                 | 11     |
| Albert     | Brooks     | La Guerra de las galaxias: Episodio VI  | 7      |
| Jim        | Parsons    | La Guerra de las galaxias: Episodio VI  | 7      |
| Leonardo   | Di Caprio  | La Guerra de las galaxias: Episodio VII | 6      |
| Ellen      | DeGeneres  | La Guerra de las galaxias: Episodio VII | 6      |
| Kaley      | Cuoco      | La Guerra de las galaxias: Episodio VII | 6      |
| Kate       | Winslet    | Parque Jurasico                         | 5      |
| Alexander  | Gould      | Parque Jurasico                         | 5      |
| Rupert     | Grint      | La vida es bella                        | 5      |
| Jensen     | Ackles     | La vida es bella                        | 5      |
| Matthew    | Broderick  | Carrozas de fuego                       | 7      |
| Jeremy     | Irons      | I am Sam                                | 4      |
| Jim        | Caviezel   | I am Sam                                | 4      |
| Sigourney  | Weaver     | Best movie ever                         | 15     |
+------------+------------+-----------------------------------------+--------+
```

- Crear un índice sobre el nombre en la tabla movies.
-

~~~~sql
CREATE INDEX title_index ON movies (title);
~~~~

- Chequee que el índice fue creado correctamente.

~~~~sql
DESCRIBE movies;
~~~~

```
+--------------+-----------------------+------+-----+---------+----------------+
| Field        | Type                  | Null | Key | Default | Extra          |
+--------------+-----------------------+------+-----+---------+----------------+
| id           | int unsigned          | NO   | PRI | <null>  | auto_increment |
| created_at   | timestamp             | YES  |     | <null>  |                |
| updated_at   | timestamp             | YES  |     | <null>  |                |
| title        | varchar(500)          | NO   | MUL | <null>  |                |
| rating       | decimal(3,1) unsigned | NO   |     | <null>  |                |
| awards       | int unsigned          | NO   |     | 0       |                |
| release_date | datetime              | NO   |     | <null>  |                |
| length       | int unsigned          | YES  |     | <null>  |                |
| genre_id     | int unsigned          | YES  | MUL | <null>  |                |
+--------------+-----------------------+------+-----+---------+----------------+
```

- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.


~~~~sql
EXPLAIN SELECT * FROM movies WHERE  title = "toy story";
~~~~


```
#SIN INDICE
+----+-------------+--------+------------+------+---------------+--------+---------+--------+------+----------+-------------+
| id | select_type | table  | partitions | type | possible_keys | key    | key_len | ref    | rows | filtered | Extra       |
+----+-------------+--------+------------+------+---------------+--------+---------+--------+------+----------+-------------+
| 1  | SIMPLE      | movies | <null>     | ALL  | <null>        | <null> | <null>  | <null> | 22   | 10.0     | Using where |
+----+-------------+--------+------------+------+---------------+--------+---------+--------+------+----------+-------------+
```

```
#CON INDICE
+----+-------------+--------+------------+------+---------------+-------------+---------+-------+------+----------+--------+
| id | select_type | table  | partitions | type | possible_keys | key         | key_len | ref   | rows | filtered | Extra  |
+----+-------------+--------+------------+------+---------------+-------------+---------+-------+------+----------+--------+
| 1  | SIMPLE      | movies | <null>     | ref  | title_index   | title_index | 1502    | const | 👉 1 | 100.0    | <null> |
+----+-------------+--------+------------+------+---------------+-------------+---------+-------+------+----------+--------+
```

👉 Se trae la row específica cuando está agregado el índice, lo que hace que la consulta sea mucho más rapido

- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta?

Podria crearse un indice compuesto en **first_name** y **last_name** de **actors** para que la busqueda por nombre completo (nombre y apellido) sea más rápida
