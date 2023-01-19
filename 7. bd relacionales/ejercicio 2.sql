

Ejercicio 2:
Consultas mysql

1) Mostrar todos los registros de la tabla de movies.\
Consulta:

SELECT * FROM movies;

2) Mostrar el nombre, apellido y rating de todos los actores.\
Consulta:

SELECT first_name, last_name, rating 
FROM actors;

3) Mostrar el titulo de todas las series y usar alias para que tanto el nombre de la tabla como el campo este en español.
Consulta:

SELECT title AS titulo 
FROM series;


4) Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
Consulta:

SELECT first_name, last_name 
FROM actors
WHERE rating >= 7.5


5) Mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con mas de dos premios.
Consulta:

SELECT title, rating, awards 
FROM movies
WHERE rating > 7.5 AND awards > 2;


6) Mostrar el titulo de las peliculas y el rating ordenadas por rating en forma ascendente.
Consulta:

SELECT title, rating
FROM movies
ORDER BY rating;


7) Mostrar los titulos de las primeras tres peliculas en la base de datos.
Consulta:

SELECT title
FROM movies
LIMIT 3;

8) Mostrar el top 5 de las peliculas con mayor rating.
Consulta:


9) Listar los primeros 10 actores.
Consulta:

SELECT *
FROM actors
LIMIT 10;

10) Mostrar el titulo y rating de todas las peliculas cuyo titulo sea de Toy Story.
Consulta:

SELECT title, rating
FROM movies
WHERE title LIKE "%Toy Story%";


11) Mostrar a todos los actores cuyos nombres empiezan con Sam.
Consulta:

select *
from actors
where first_name like "Sam%";

12) Mostrar el titulo de las peliculas que salieron entre el 2004 y 2008.
Consulta:

SELECT *
FROM movies
WHERE YEAR(release_date) BETWEEN "1988" AND "2009";


13) Traer el titulo de las peliculas con el rating mayor a 3, con mas de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
Consulta:

SELECT title
FROM movies
WHERE rating>3 AND awards > 1 AND year(release_date) BETWEEN "1988" AND "2009";

