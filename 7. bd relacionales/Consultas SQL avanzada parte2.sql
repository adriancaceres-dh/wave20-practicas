-- Agregar una pelicula a la tabla movies.
Insert into movies values(null,null,null,"Pelicula inventada",9.5,9,"1998-06-18",150,3);

-- 1) Agregar un género a la tabla genres.
Insert into genres values (null,"2016-07-03", null, "Genero inventado",13,1);

-- 2) Asociar a la película del punto 1. genre el género creado en el punto 2.
Update movies set genre_id = 13 where id=22;

-- 3) Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
Update actors set favorite_movie_id = 22 where id =5;

-- 4) Crear una tabla temporal copia de la tabla movies.
Create temporary table moviesCopy
Select * from movies;

SET SQL_SAFE_UPDATES=0;
SET FOREIGN_KEY_CHECKS=0;
-- 5) Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
Delete from movies where awards<5;

-- 6) Obtener la lista de todos los géneros que tengan al menos una película.
Select distinct genres.name from genres 
join movies on (genres.id = movies.genre_id);

-- 7) Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
Select actors.first_name, actors.favorite_movie_id, movies.id from actors
join movies on (actors.favorite_movie_id = movies.id)
where movies.awards>3;

-- 8) Crear un índice sobre el nombre en la tabla movies.
Create index moviesName on movies(title);

-- 9)Chequee que el índice fue creado correctamente.
Show indexes in movies;



