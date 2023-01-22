/* Agregar una película a la tabla movies.
Agregar un género a la tabla genres.
Asociar a la película del punto 1. genre el género creado en el punto 2.
Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Crear una tabla temporal copia de la tabla movies.
Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Obtener la lista de todos los géneros que tengan al menos una película.
Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Crear un índice sobre el nombre en la tabla movies.
Chequee que el índice fue creado correctamente.
En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/


-- INSERT INTO `movies_db`.`movies` (`id`, `title`, `rating`, `awards`, `release_date`, `length`) VALUES ('22', 'xxx No porno', '8.0', '5', '2012-05-04 00:00:00', '90');
-- INSERT INTO `movies_db`.`genres` (`id`, `created_at`, `name`, `ranking`, `active`) VALUES ('13', '2023-01-22 00:00:00', 'No porno', '13', '1');
-- UPDATE `movies_db`.`movies` SET `genre_id` = '13' WHERE (`id` = '22');
-- UPDATE `movies_db`.`actor_movie` SET `movie_id` = '22' WHERE (`id` = '14');
-- CREATE TEMPORARY TABLE temporaryMovies
-- select * from movies; 
--  delete from temporaryMovies where awards <5;
-- select g.* from genres g inner join movies m on g.id = m.genre_id group by g.id
-- select a.* from actors a inner join actor_movie am on a.id = am.actor_id inner join movies m on m.id = am.movie_id where m.awards >3
/*ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title_index` (`title` ASC) VISIBLE;
;*/
-- La creacion del indice en la tabla movies en el atributo title mejora la manera de encontrar la pelicula.
-- En actor en el atributo name tambien mejoraria la eficiencia.