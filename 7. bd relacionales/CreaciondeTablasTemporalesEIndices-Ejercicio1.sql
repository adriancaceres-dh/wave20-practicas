/*
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
*/

USE movies_db;

CREATE TEMPORARY TABLE twd (id integer, title varchar(40), season_id integer);

SELECT * FROM twd;

INSERT INTO twd
SELECT id, title, season_id 
FROM episodes 
WHERE season_id IN
(SELECT sea.id FROM seasons sea INNER JOIN series ser
ON ser.title = "The Walking Dead" AND ser.id = sea.serie_id);

/*
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/

SELECT twd.id, twd.title, twd.season_id 
FROM twd INNER JOIN seasons s
ON s.id IN 
	(SELECT sea.id FROM seasons sea INNER JOIN series ser
	ON ser.title = "The Walking Dead" 
	AND ser.id = sea.serie_id
	AND sea.number = 1)
AND twd.season_id = s.id;
