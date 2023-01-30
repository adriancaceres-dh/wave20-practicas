SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS Titulo FROM series as Series;

SELECT first_name, last_name FROM actors WHERE rating >7.5;

SELECT title, rating, awards FROM movies WHERE rating>7.5 AND awards>2;

SELECT title FROM movies LIMIT 3;

SELECT title, rating FROM movies ORDER BY rating ASC;

SELECT title FROM movies ORDER BY rating ASC LIMIT 5;

SELECT first_name, last_name FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title="Toy Story";

SELECT first_name, last_name FROM actors WHERE first_name LIKE "Sam%" LIMIT 10;

SELECT title, release_date FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';