-- 1) Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

-- 2) En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

-- 1
create temporary table TWD like episodes;

insert into TWD 
(select * from episodes where season_id in 
(select seasons.id from seasons 
join series on seasons.serie_id = series.id 
and series.title like "%The Walking Dead%")); 

select * from TWD;

-- 2

explain select * from TWD;

explain select * from TWD where rating = 7.5;

create index index_twd on TWD (rating);

explain select * from TWD where rating = 7.5;

