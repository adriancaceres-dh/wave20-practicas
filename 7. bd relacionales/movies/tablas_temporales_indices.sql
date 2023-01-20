-- Usar movies_db.
USE movies_db;

-- Ejercicio 1

-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE twd (
	id INT NOT NULL PRIMARY KEY,
    season_id INT NOT NULL,
    title VARCHAR(500),
    number INT,
    release_date DATETIME NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
	created_at TIMESTAMP,
    updated_at TIMESTAMP
);

INSERT INTO twd
SELECT e.id, e.season_id, e.title, e.number, e.release_date, e.rating, e.created_at, e.updated_at
FROM episodes AS e
INNER JOIN seasons AS ss ON ss.id = e.season_id
INNER JOIN series AS s ON s.id = ss.serie_id
WHERE s.title LIKE "the walking dead";

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT e.id, e.season_id, e.title, e.number, e.release_date, e.rating, e.created_at, e.updated_at
FROM twd AS e
INNER JOIN seasons AS s ON s.id = e.season_id
WHERE s.number = 1;

-- Ejercicio 2

-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX release_date_index
ON movies (release_date);

SHOW INDEX FROM movies;

-- 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Se crearía un índice en la tabla "movies" debido a que es la tabla más importante de la base de datos.
-- Se crearía sobre el campo "release_date" debido a que es habitual la creación de índices en fechas, pero sobre todo a que es un campo que se suele usar mucho para filtrar películas mediante sentencias "WHERE".