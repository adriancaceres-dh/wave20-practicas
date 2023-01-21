-- Creación de tablas temporales e índices
/*
Ejercicio 1
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/
-- ALTER TABLE TWD ADD (TEMPORADA varchar(25)); AGREGUÉ EL CAMPO: TEMPORADA
CREATE TEMPORARY TABLE TWD
(ID int NOT NULL PRIMARY KEY auto_increment,
EPISODIOS varchar(45) NOT NULL)

SELECT EP.TITLE AS EPISODIOS, SR.TITLE AS SERIE, SA.TITLE AS TEMPORADA FROM SERIES SR
JOIN SEASONS SA ON SR.ID = SA.SERIE_ID
JOIN EPISODES EP ON SA.ID = EP.SEASON_ID
WHERE SR.TITLE LIKE 'THE WALKING DEAD';

-- TRUNCATE TWD; OLVIDÉ AGREGAR EL CAMPO: TEMPORADA
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('Days Gone Bye', 'Primer Temporada');
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('What Lies Ahead', 'Segunda Temporada');
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('Seed', 'Tercer Temporada');
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('30 Days Without an Accident', 'Cuarta Temporada');
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('No Sanctuary', 'Quinta Temporada');
INSERT INTO TWD (EPISODIOS, TEMPORADA) VALUES('First Time Again', 'Sexta Temporada');

SELECT * FROM TWD 
WHERE TEMPORADA LIKE 'Primer Temporada';

/*
Ejercicio 2
En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
*/
ALTER TABLE MOVIES ADD INDEX RATING_MOVIES(RATING);

SHOW INDEX FROM MOVIES;

select max(m.rating), g.name, m.title
from movies m 
join genres g on g.id = m.genre_id 
where m.rating >= 8.0
group by g.name, m.title
order by g.name,1;

