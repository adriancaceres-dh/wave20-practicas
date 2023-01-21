-- Consultas avanzadas 2

-- 1. Agregar una película a la tabla movies.
INSERT INTO MOVIES (TITLE, RATING, AWARDS, RELEASE_DATE, LENGTH, GENRE_ID) VALUES('Life in a year', 8.2, 5,'2020-11-27',180,13);
-- 2.Agregar un género a la tabla genres. 
INSERT INTO GENRES (NAME, RANKING, ACTIVE) VALUES('Romance',13,1);
-- 3.Asociar a la película del punto 1. genre el género creado en el punto 2.
SELECT M.*, G.NAME
FROM MOVIES M
JOIN GENRES G ON M.GENRE_ID = G.ID
WHERE M.TITLE LIKE '%LIFE IN A YEAR%';

-- 4.Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE ACTORS 
SET FAVORITE_MOVIE_ID = 22
WHERE ID = 3;

-- 5.Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE COPY_MOVIES (SELECT * FROM MOVIES);

-- 6.Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM COPY_MOVIES 
WHERE AWARDS < 5;

-- 7.Obtener la lista de todos los géneros que tengan al menos una película.
SELECT G.NAME
FROM GENRES G 
JOIN MOVIES M
ON G.ID = M.GENRE_ID
WHERE M.GENRE_ID IS NOT NULL;

-- 8.Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT A.*, M.AWARDS FROM ACTORS A
JOIN MOVIES M ON A.FAVORITE_MOVIE_ID = M.ID
WHERE M.AWARDS > 3;

-- 9.Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE MOVIES 
ADD INDEX NANE_INDEX(TITLE);

-- 10.Chequee que el índice fue creado correctamente.
SHOW INDEX FROM MOVIES;

-- 11.En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Considero que las mejoras posibles dependen de las necesidades del negocio. 
Necesitaría analizar algunas consultas para poder plantear mejoras.
*/
-- 12.¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
