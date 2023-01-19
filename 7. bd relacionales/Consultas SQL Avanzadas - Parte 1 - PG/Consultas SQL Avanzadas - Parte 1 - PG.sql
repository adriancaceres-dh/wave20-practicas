# Mostrar el título y el nombre del género de todas las series.
Select s.title, g.name from series s inner join genres g on (s.genre_id = g.id);

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
Select e.title, a.first_name, a.last_name from actors a inner join actor_episode ae on (ae.actor_id = a.id) inner join episodes e on (e.id = ae.episode_id) order by e.title;

# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
Select ser.title, (Select count(*) from seasons sea where sea.serie_id = ser.id)  as total_temporadas  from series ser;

# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
Select g.name, (select count(*) from movies m where m.genre_id = g.id) as cantidad_total_peliculas  from genres g having cantidad_total_peliculas >= 3;

# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name from actors a inner join actor_movie am on (am.actor_id = a.id) inner join movies m on (m.id = am.movie_id) 
where m.title like "%la guerra de las galaxias%" group by a.id having count(*) = (select count(*) from movies where title like "%la guerra de las galaxias%");