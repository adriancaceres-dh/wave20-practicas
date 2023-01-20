# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma 
# los episodios de todas las temporadas de “The Walking Dead”.
create temporary table TWD (
SELECT e.title, e.number, s.title as title_season FROM episodes e 
inner join seasons s on (s.id = e.season_id) 
where season_id in 
	(Select id from seasons where serie_id in (Select id from series where title like "The Walking Dead"))
);

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from TWD where title_season = "Primer Temporada";

# En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
Create index first_name_index on actors(first_name);