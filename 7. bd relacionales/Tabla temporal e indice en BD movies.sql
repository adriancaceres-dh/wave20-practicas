
-- TABLA TEMPORAL LLAMADA TWD:
create temporary table TWD
	Select episodes.title as tituloObra , seasons.title as temporada
	from episodes join seasons on (seasons.id = episodes.season_id)
	join series on (series.id = seasons.serie_id)
	where series.title = "The walking dead";

-- Consulta sobre la tabla temporal
select tituloObra from TWD where temporada = "Primer Temporada";

-- Creación de un indice sobre la tabla 
Create index titleIndex on episodes(title);

-- Chequeo de creación del indice:
Show indexes in episodes;