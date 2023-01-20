-- DML (DATA MANAGEMENT LANGUAGE)

-- SELECT de todos los atributos

SELECT * FROM actors;

-- SELECT de algunos atributos

SELECT id, first_name, last_name, rating FROM actors;

-- SELECT de atributos ficticios

SELECT id, concat(first_name,' ',last_name) as full_name, rating FROM actors;

-- Uso WHERE para acotar la busqueda

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE id = 3; -- Búsqueda por un id específico

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE first_name = "sam"; -- Búsqueda por un first_name específico

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE rating >= 7; -- Búsqueda por mayor igual (operador matemático de comparación)

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE rating >= 7 AND rating <= 8; -- Búsqueda entre un rango usando operadores de comparación

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE rating BETWEEN 7.0 AND 8.0; -- Búsqueda entre un rango usando la cláusula BETWEEN (mayor performance)

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE first_name LIKE "%sa%"; -- Búsqueda por coincidencia de strings

SELECT id, concat(first_name, ' ', last_name) as full_name, rating FROM actors
WHERE rating IN (7.5,8,9); -- Búsqueda por valores específicos (Mayor performance que el comparador lógico OR)

-- Consulta con límite de resultados

SELECT id, first_name, last_name, rating FROM actors
LIMIT 0,10; -- Búsqueda con límite para simular paginado, primer parametro es el índice de la fila inicial, segundo el salto

-- Consultas con ordenamiento

SELECT id, first_name, last_name, rating FROM actors
ORDER BY first_name ASC;

-- Funciones de agregación

-- AVG

SELECT AVG(rating) as promedioRating FROM movies WHERE title LIKE "%la guerra de las galaxias";

-- SUM

SELECT SUM(awards) as sumaPromedios FROM movies WHERE title LIKE "%la guerra de las galaxias%";

-- MAX

SELECT MAX(awards) as maxPremios FROM movies;

-- MIN

SELECT MIN(RATING) as peorPelicula FROM movies;

-- COUNT

SELECT COUNT(*) as cantApariciones FROM movies;

-- CLAUSULAS RESTANTES DEL CRUD (CUD)

-- INSERT

INSERT INTO actors (first_name, last_name, rating, favorite_movie_id, created_at, updated_at) -- Se manifiesta de antemano el orden que le voy a dar a los parámetros
VALUES("Sergio", "Polo", 5, 2, "2015-05-02", "2015-05-02");

-- UPDATE
UPDATE actors
	SET
		last_name = "Martínez",
        updated_at = "2023-01-18"
WHERE id = 53;

-- DELETE
DELETE FROM actors WHERE id = 50;


