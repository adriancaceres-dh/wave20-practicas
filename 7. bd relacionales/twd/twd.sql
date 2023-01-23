-- Creación de tablas temporales e índices

-- Ejercicio 1:
CREATE TEMPORARY TABLE twd (
	id INT unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(500),
    season INT, 
    number INT, 
    release_date DATETIME NOT NULL,
    rating DECIMAL(3,1)
    );


INSERT INTO twd (title, season, number, release_date, rating)
SELECT e.title, ss.number, e.number, e.release_date, e.rating FROM episodes e
JOIN seasons ss ON e.season_id = ss.id
JOIN series s ON s.id = ss.serie_id
WHERE s.title LIKE "%the walking dead%";


-- Consulta para ver los episodios de la primera temporada
SELECT * FROM twd WHERE season = 1;


-- Ejercicio 2:
CREATE INDEX title_idx ON movies(title);

SHOW INDEX FROM movies;

-- Se crearía un índice ne la tabla movies ya que es la tabla principal en nuestra base de datos y particularmente el campo title puede involucrar muchas consultas.


