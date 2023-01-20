-- CONSULTAS AVANZADAS
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT S.TITLE, G.NAME FROM SERIES S JOIN GENRES G
ON S.GENRE_ID = G.ID;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT E.TITLE, CONCAT(A.FIRST_NAME , ' ', A.LAST_NAME) FROM EPISODES E
JOIN ACTOR_EPISODE AE ON E.ID = AE.EPISODE_ID
JOIN ACTORS A ON A.ID = AE.ACTOR_ID;
 
-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT SI.TITLE AS SERIE, MAX(SA.NUMBER) AS SEASONS FROM SERIES SI
JOIN SEASONS SA ON SI.ID = SA.SERIE_ID
GROUP BY SI.TITLE;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT G.NAME AS GENRE, COUNT(M.GENRE_ID) AS 'MOVIES' FROM GENRES G
JOIN MOVIES M ON G.ID = M.GENRE_ID
WHERE GENRE_ID >= 3
GROUP BY G.NAME;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT CONCAT(A.FIRST_NAME , ' ', A.LAST_NAME) FROM ACTORS A 
JOIN ACTOR_MOVIE AM ON A.ID = AM.ACTOR_ID
JOIN MOVIES M ON M.ID = AM.MOVIE_ID;



