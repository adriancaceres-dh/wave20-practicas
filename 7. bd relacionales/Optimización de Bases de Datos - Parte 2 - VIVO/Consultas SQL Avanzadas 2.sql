# Agregar una película a la tabla movies.
INSERT INTO movies (`id`, `title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) 
VALUES ('22', 'El gato con botas', '8.0', '2', '2022-12-07', '112', '10');

# Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres` (`id`, `created_at`, `name`, `ranking`, `active`)
 VALUES ('13', '2023-01-20', 'Thriller', '13', '1');

# Asociar a la película del punto 1. genre el género creado en el punto 2.
Update movies set genre_id = 13 where id = 22;

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Update actors set favorite_movie_id = 22 where first_name = "sam";

# Crear una tabla temporal copia de la tabla movies.
create temporary table temporary_movies (
select * from movies
);

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from temporary_movies where awards < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.
select * from genres where id in (select distinct genre_id from movies);

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select concat(a.first_name, " ", a.last_name) as complete_name from actors a 
where a.favorite_movie_id in (select id from movies where awards > 3);

# Crear un índice sobre el nombre en la tabla movies.
create index title_index on movies (title);

# Chequee que el índice fue creado correctamente.
show indexes in movies;