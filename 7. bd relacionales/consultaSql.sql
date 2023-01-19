SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS Titulo FROM series;

SELECT first_name, last_name, rating FROM actors
WHERE rating >7.5;

SELECT title,rating, awards FROM movies
WHERE rating >7.5 AND awards >2;

SELECT title,rating FROM movies
Order by rating DESC;

SELECT title FROM movies
LIMIT 3;

SELECT title, rating FROM movies
ORDER BY rating DESC
LIMIT 5;

SELECT first_name FROM actors 
LIMIT 10;

SELECT title, rating FROM movies
WHERE title = 'Toy Story';

SELECT title, rating FROM movies
WHERE title LIKE 'Toy Story%';

SELECT first_name,last_name FROM actors
WHERE first_name LIKE 'sam%';

SELECT title,release_date FROM movies
WHERE YEAR(release_date)between 2004 and 2008;

SELECT title,rating, awards FROM movies
WHERE rating >3 AND awards >1 AND YEAR(release_date)between 1988 and 2009
ORDER BY rating;
