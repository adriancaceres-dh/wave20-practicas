use movies_db;

-- 1
SELECT * FROM movies;

-- 2
SELECT concat(first_name," ", last_name) as fullName, rating FROM actors;

-- 3
SELECT title as titulo FROM series; 
-- FALTA EL QUE LA TABLA SEA DEVUELTA EN ESPAÑOL

-- 4
SELECT concat(first_name, " ", last_name) as fullName, rating FROM actors
WHERE rating > "7.5";

-- 5
SELECT title, rating, awards FROM movies 
WHERE rating > "7.5" AND awards > 2;

-- 6
SELECT id, title, rating FROM movies
ORDER BY rating ASC;

-- 7
SELECT id, title FROM movies
WHERE id <= 3;

-- 8
SELECT id, title, rating FROM movies
ORDER BY rating DESC LIMIT 5;

-- 9
SELECT id, concat(first_name, " ", last_name) as fullName FROM actors
LIMIT 10;

-- 10
SELECT title, rating FROM movies
WHERE title LIKE "%Toy Story%";

-- 11
SELECT id, concat(first_name, " ", last_name) as fullName FROM actors
WHERE first_name IN ("sam");

-- 12
SELECT id, title, release_date FROM movies 
WHERE YEAR (release_date) BETWEEN "2004" AND "2008";

-- 13
SELECT id, title, rating, awards, release_date FROM movies 
WHERE rating > 3 AND awards > 1 AND YEAR (release_date) BETWEEN "1988" AND "2009"
ORDER BY rating;
