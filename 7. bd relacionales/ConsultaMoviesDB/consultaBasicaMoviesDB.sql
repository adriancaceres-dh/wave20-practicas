-- movies
SELECT * FROM movies;

SELECT title,rating,awards FROM movies
WHERE rating>7.5 AND awards>2;

SELECT title,rating,awards FROM movies
ORDER BY rating;

SELECT title FROM movies
LIMIT 3;

SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;

SELECT title,rating FROM movies
WHERE title LIKE "%toy story%";

SELECT title FROM movies
WHERE YEAR(release_date) BETWEEN "2004" AND "2008"; 

SELECT title FROM movies
WHERE YEAR(release_date) BETWEEN "1988" AND "2009"
AND rating>3 AND awards>1; 

-- actors
SELECT first_name, last_name, rating FROM actors;

SELECT first_name, last_name FROM actors
WHERE rating>7.5;

SELECT * FROM actors
LIMIT 10;

SELECT * FROM actors
WHERE first_name LIKE "sam%";

-- series
SELECT title as "título" FROM series;
