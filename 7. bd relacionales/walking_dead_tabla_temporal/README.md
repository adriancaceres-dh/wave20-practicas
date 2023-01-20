## Ejercicio 1 - Tablas temporales

- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios
  de todas las temporadas de “The Walking Dead”.
- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

~~~~sql
SELECT episodes.title AS nombre_episodio, episodes.rating, seasons.title AS temporada
FROM episodes
         JOIN seasons ON episodes.season_id = seasons.id
         JOIN series ON seasons.serie_id = series.id
WHERE series.title = "the walking dead";
~~~~

~~~~sql
CREATE
TEMPORARY TABLE walking_dead_temp (
 id int unsigned NOT NULL AUTO_INCREMENT,
 nombre_episode varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
 rating decimal(3,1) NOT NULL,
 temporada varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
 PRIMARY KEY (id));
~~~~

~~~~sql
INSERT INTO walking_dead_temp (nombre_episode, rating, temporada)
SELECT episodes.title AS nombre_episodio,
       episodes.rating,
       seasons.title  AS temporada
FROM episodes
         JOIN seasons ON episodes.season_id = seasons.id
         JOIN series ON seasons.serie_id = series.id
WHERE series.title = "the walking dead";
~~~~

~~~~sql
SELECT *
FROM walking_dead_temp
WHERE temporada = "primer temporada";
~~~~
