# --------- PARTE 1 ---------
# 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
DROP TABLE TWD;
CREATE TEMPORARY TABLE TWD (SELECT ep.*, sea.number as number_season FROM seasons AS sea JOIN series AS ser JOIN episodes as ep ON (sea.serie_id = ser.id AND ser.title LIKE "%The Walking Dead%" AND ep.season_id = sea.id));
SELECT * FROM TWD;

# 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE number_season = 1;


# --------- PARTE 2 ---------
# 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX titulos_peliculas ON episodes(title);

# 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
SHOW INDEXES FROM episodes
