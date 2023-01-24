/* En la base de datos “movies”, seleccionar una tabla donde crear
	un índice y luego chequear la creación del mismo. */
USE movies_db;
CREATE INDEX genres_index
ON genres(name);

SHOW INDEX FROM genres;

