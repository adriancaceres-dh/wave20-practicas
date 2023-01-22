USE movies_db;

SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title as titulo FROM series AS Programas;

SELECT first_name, last_name FROM actors WHERE rating > 7.5;

SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

SELECT title, rating FROM movies order by rating;

SELECT title FROM movies LIMIT 3;

SELECT * FROM movies order by rating desc LIMIT 5;

SELECT * FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title LIKE "Toy Story%";

SELECT * FROM actors WHERE first_name LIKE "sam%";

Select * from movies where release_date between '2004/01/01' and '2007/12/31';

Select * from movies where rating > 3 AND awards > 1 AND release_date between '1988/01/01' and '2008/12/31';