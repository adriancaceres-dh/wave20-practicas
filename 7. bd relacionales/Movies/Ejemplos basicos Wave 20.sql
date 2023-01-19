-- DML (DATA MANIPULATION LANGUAGE)

-- SELECT de todos los atributos

SELECT * FROM actors;

-- SELECT de algunos atributos necesarios

SELECT id, first_name, last_name, rating FROM actors;

-- SELECT de atributos ficticios

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors;

-- Uso WHERE para acotar la busqueda

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE id = 3; -- Busqueda por un id especifico

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name = "sam"; -- Busqueda por un first_name especifico

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating >= 7.0; -- Busqueda por mayor igual

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating >= 7.0 AND rating <= 8.0; -- Filtrado por rangos menos performante

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE rating BETWEEN 7.0 AND 8.0; -- Filtrado por rangos mas performante

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name LIKE "%ar%"; -- Coincidencia

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name = "sam" OR first_name = "harrison"; -- filtrado por valores dentro de dos condiciones

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
WHERE first_name IN ("sam", "harrison"); -- filtrado por valores dentro de los valores de IN

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors LIMIT 1, 50;

SELECT id, concat(first_name, ' ', last_name) as complete_name, rating FROM actors
ORDER BY first_name DESC;


SELECT * FROM movies
WHERE YEAR(release_date) BETWEEN "1998" AND "2015";


-- AVG

SELECT AVG(rating) as promedioRating FROM movies WHERE title LIKE "%La guerra de las galaxias%";

-- SUM

SELECT SUM(awards) as sumPremios FROM movies WHERE title LIKE "%La guerra de las galaxias%";

-- MAX

SELECT MAX(awards) as maxPremios FROM movies;

-- MIN

SELECT MIN(awards) as minPremios FROM movies;

-- COUNT

SELECT COUNT(*) as cantApariciones FROM movies WHERE title LIKE "%La guerra de las galaxias%";


-- INSERT

INSERT INTO actors (id, first_name, last_name, rating, favorite_movie_id, created_at, updated_at)
VALUES (50,"Jean", "Cardo", 5.0, 2, "2015-05-02", "2015-05-02");

INSERT INTO actors
VALUES (null, "2015-05-02", "2015-05-02", "Jean", "Cardo", 5.0, 2);

SELECT * FROM actors;

-- UPDATE

UPDATE actors
	SET 
		last_name = "gregori",
        updated_at = "2023-01-18"
WHERE id = 50;

-- DELETE

DELETE FROM actors WHERE id = 50;


