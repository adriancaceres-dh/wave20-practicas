-- DML (DATA MANIPULATION LANGUAJE)

-- Mostrar todos los registros de la tabla de movies. 
SELECT * FROM movies;

-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM actors;

-- Mostrar el id, la columna como complete_name, y el rating
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors;

-- Mostrar algunos datos de los actores con id = 3
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name = "sam";

-- Mostrar algunos datos de los actores con rating >=7
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors;

-- Mostrar algunos datos de los actores con rating >=7 y <=8 No tan chevere
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating >= 7 AND rating <= 8;

-- Mostrar algunos datos de los actores con rating >=7 y <=8 con BETWEEN chevere
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating BETWEEN 7 AND 8;

-- Mostrar algunos datos de los actores que terminan por am
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name LIKE "%am";

-- Mostrar algunos datos de los actores que tienen como valores especificos en su rating 7.5, 8, 9
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating IN (7.5,8,9);

-- Mostrar algunos datos de los actores que tienen como valores especificos en su nombre ...
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name IN ("sam", "harrison");

-- Mostrar algunos datos de los actores que tienen rating >= 7.5 y solo mostrar 3
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating >= 7.5
LIMIT 3;

-- Mostrar algunos datos de los actores, empezando desde el 36 (37) y avanzando 10.
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
LIMIT 36, 10;

-- Mostrar algunos datos de los actores, de forma ascendente.
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
ORDER BY first_name ASC; 

-- Mostrar algunos datos de los actores, de forma descendente.
SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
ORDER BY first_name DESC; 

-- Mostrar los datos de las peliculas que figuran con un anio entre
SELECT * FROM movies
WHERE YEAR(release_date) BETWEEN "1998" AND "2015";

-- FUNCIONES DE AGREGACION

-- AVG
SELECT AVG(rating) as promedio_rating FROM movies 
WHERE title LIKE "%La guerra de las galaxias%";

-- SUM
SELECT SUM(awards) as sum_premios FROM movies 
WHERE title LIKE "%La guerra de las galaxias%";

-- MAX
SELECT MAX(rating) as max_premios FROM movies;

-- MIN
SELECT MIN(rating) as min_premios FROM movies;

-- COUNT
SELECT COUNT(*) as apariciones FROM movies
WHERE title LIKE "%La guerra de las galaxias%";

-- INSERT
INSERT INTO actors(id, first_name, last_name,rating, favorite_movie_id, created_at, updated_at)
VALUES (50, "Alejandro", "Torres", 5.0, 2, "2015-05-02", "2015-05-02" );
SELECT * FROM actors;

INSERT INTO actors
VALUES (null, "2015-05-02", "2015-05-02","Alejandro", "Torres", 5.0, 2);
SELECT * FROM actors;

-- UPDATE
UPDATE actors
SET last_name = "Munoz", updated_at = "2015-05-04"
WHERE id = 50;

-- DELETE
DELETE FROM actors WHERE id = 50;

-- SENTENCIAS SQL AVANZADAS

-- JOIN 

SELECT movies.*, actors.first_name, actors.last_name
FROM movies INNER JOIN actors 
ON movies.id = actors.favorite_movie_id;

-- ALIAS SQL

SELECT mo.*, ac.first_name, ac.last_name
FROM movies mo INNER JOIN actors ac
ON mo.id = ac.favorite_movie_id;

-- GROUP BY

SELECT COUNT(*), mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac 
ON mo.id = ac.favorite_movie_id 
GROUP BY title;