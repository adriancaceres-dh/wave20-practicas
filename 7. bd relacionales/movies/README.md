## Ejercicio - Consultas a base de datos
### Descripción
Se propone realizar las siguientes consultas a la base de datos movies_db.sql.
Importar el archivo movies_db.sql desde PHPMyAdmin o MySQL Workbench y resolver las siguientes consultas:

- Mostrar todos los registros de la tabla de movies.
```
SELECT * FROM movies;
```
- Mostrar el nombre, apellido y rating de todos los actores.
```
SELECT first_name, last_name, rating FROM actors;
```
- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
```
SELECT title as titulo FROM series;
```
```
+---------------------+
| titulo              |
+---------------------+
| Game of Thrones     |
| Supernatural        |
| The Walking Dead    |
| Person of Interest  |
| The Big Bang Theory |
| Breaking Bad        |
+---------------------+
```
- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
```
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
```
```
+------------+-----------+
| first_name | last_name |
+------------+-----------+
| Sigourney  | Weaver    |
| Shia       | LaBeouf   |
| Sean       | Penn      |
| Renee      | Zellweger |
| Emilia     | Clarke    |
| Bryan      | Cranston  |
+------------+-----------+
```
- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
```
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
```
```
+-----------------------------------------+--------+--------+
| title                                   | rating | awards |
+-----------------------------------------+--------+--------+
| Avatar                                  | 7.9    | 3      |
| Titanic                                 | 7.7    | 11     |
| La Guerra de las galaxias: Episodio VI  | 9.1    | 7      |
| La Guerra de las galaxias: Episodio VII | 9.0    | 6      |
| Parque Jurasico                         | 8.3    | 5      |
| El rey león                             | 9.1    | 3      |
| La vida es bella                        | 8.3    | 5      |
| Carrozas de fuego                       | 9.9    | 7      |
| I am Sam                                | 9.0    | 4      |
+-----------------------------------------+--------+--------+  
```
- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
```
SELECT title, rating FROM movies ORDER BY rating;
```
```
+-----------------------------------------------------+--------+
| title                                               | rating |
+-----------------------------------------------------+--------+
| Transformers: el lado oscuro de la luna             | 0.9    |
| Toy Story 2                                         | 3.2    |
| Mi pobre angelito                                   | 3.2    |
| Harry Potter y la cámara de los secretos            | 3.5    |
| Alicia en el país de las maravillas                 | 5.7    |
| Toy Story                                           | 6.1    |
| Hotel Transylvania                                  | 7.1    |
| Big                                                 | 7.3    |
| Titanic                                             | 7.7    |
| Avatar                                              | 7.9    |
| Parque Jurasico                                     | 8.3    |
| Buscando a Nemo                                     | 8.3    |
| La vida es bella                                    | 8.3    |
| La Guerra de las galaxias: Episodio VII             | 9.0    |
| Harry Potter y las Reliquias de la Muerte - Parte 2 | 9.0    |
| Intensamente                                        | 9.0    |
| I am Sam                                            | 9.0    |
| La Guerra de las galaxias: Episodio VI              | 9.1    |
| El rey león                                         | 9.1    |
| Carrozas de fuego                                   | 9.9    |
| Harry Potter y la piedra filosofal                  | 10.0   |
+-----------------------------------------------------+--------+
```
- Mostrar los títulos de las primeras tres películas en la base de datos.
```
SELECT title FROM movies LIMIT 3;
```
```
+----------------------------------------+
| title                                  |
+----------------------------------------+
| Avatar                                 |
| Titanic                                |
| La Guerra de las galaxias: Episodio VI |
+----------------------------------------+
```
- Mostrar el top 5 de las películas con mayor rating.
```
SELECT title, rating FROM movies ORDER BY RATING DESC LIMIT 5;
```
```
+-----------------------------------------------------+--------+
| title                                               | rating |
+-----------------------------------------------------+--------+
| Harry Potter y la piedra filosofal                  | 10.0   |
| Carrozas de fuego                                   | 9.9    |
| El rey león                                         | 9.1    |
| La Guerra de las galaxias: Episodio VI              | 9.1    |
| Harry Potter y las Reliquias de la Muerte - Parte 2 | 9.0    |
+-----------------------------------------------------+--------+

```
- Listar los primeros 10 actores.
```
SELECT first_name, last_name, rating FROM actors LIMIT 10;
```
```
+------------+-------------+--------+
| first_name | last_name   | rating |
+------------+-------------+--------+
| Sam        | Worthington | 7.5    |
| Zoe        | Saldana     | 5.5    |
| Sigourney  | Weaver      | 9.7    |
| Leonardo   | Di Caprio   | 3.5    |
| Kate       | Winslet     | 1.5    |
| Billy      | Zane        | 7.5    |
| Mark       | Hamill      | 6.5    |
| Harrison   | Ford        | 7.5    |
| Carrie     | Fisher      | 7.5    |
| Sam        | Neill       | 2.5    |
+------------+-------------+--------+
```
- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
```
SELECT title, rating FROM movies WHERE title LIKE "%toy story%";
```
```
+-------------+--------+
| title       | rating |
+-------------+--------+
| Toy Story   | 6.1    |
| Toy Story 2 | 3.2    |
+-------------+--------+
```
- Mostrar a todos los actores cuyos nombres empiezan con Sam.
```
SELECT first_name, last_name, rating FROM actors WHERE first_name LIKE "sam%";
```
```
+------------+-------------+--------+
| first_name | last_name   | rating |
+------------+-------------+--------+
| Sam        | Worthington | 7.5    |
| Sam        | Neill       | 2.5    |
+------------+-------------+--------+

```
- Mostrar el título de las películas que salieron entre el 2004 y 2008.
```
SELECT title FROM movies WHERE YEAR(release_date) BETWEEN 2004 AND 2008;
```
```
+-----------------------------------------------------+
| title                                               |
+-----------------------------------------------------+
| La Guerra de las galaxias: Episodio VI              |
| Harry Potter y las Reliquias de la Muerte - Parte 2 |
| Transformers: el lado oscuro de la luna             |
| Harry Potter y la piedra filosofal                  |
| Alicia en el país de las maravillas                 |
| Toy Story                                           |
| Intensamente                                        |
+-----------------------------------------------------+
```
- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.

```
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN 1988 AND 2009 ORDER BY rating;
```

```
+-----------------------------------------------------+
| title                                               |
+-----------------------------------------------------+
| Toy Story 2                                         |
| Harry Potter y la cámara de los secretos            |
| Alicia en el país de las maravillas                 |
| Big                                                 |
| Titanic                                             |
| Parque Jurasico                                     |
| Buscando a Nemo                                     |
| La vida es bella                                    |
| La Guerra de las galaxias: Episodio VII             |
| Harry Potter y las Reliquias de la Muerte - Parte 2 |
| Intensamente                                        |
| I am Sam                                            |
| La Guerra de las galaxias: Episodio VI              |
| El rey león                                         |
+-----------------------------------------------------+
```
