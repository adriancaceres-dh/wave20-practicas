## Ejercicio 2 - Indices
- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

~~~~sql
CREATE INDEX actors_name_index
    ON actors (first_name, last_name);
~~~~

+-------------------+--------------+------+-----+---------+----------------+
| Field             | Type         | Null | Key | Default | Extra          |
+-------------------+--------------+------+-----+---------+----------------+
| id                | int unsigned | NO   | PRI | <null>  | auto_increment |
| created_at        | timestamp    | YES  |     | <null>  |                |
| updated_at        | timestamp    | YES  |     | <null>  |                |
| first_name        | varchar(100) | NO   | MUL | <null>  |                |
| last_name         | varchar(100) | NO   |     | <null>  |                |
| rating            | decimal(3,1) | YES  |     | <null>  |                |
| favorite_movie_id | int unsigned | YES  | MUL | <null>  |                |
+-------------------+--------------+------+-----+---------+----------------+

- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

Creo que por la forma en que estamos utilizando las queries, lo más importante es que haya indice en cada PK y en las FK.
Además, si queremos buscar actores específicos (con su nombre y apellido) este indice compuesto nos va a ayudar