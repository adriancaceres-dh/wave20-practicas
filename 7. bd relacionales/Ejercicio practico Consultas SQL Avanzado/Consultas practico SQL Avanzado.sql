# 1- Mostrar el título y el nombre del género de todas las series.
SELECT ser.title, gen.name FROM genres AS gen JOIN series AS ser;

# 2- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, act.first_name, act.last_name FROM episodes AS ep JOIN actors AS act;

# 3- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(sea.number) AS total_de_temporadas FROM series AS ser JOIN seasons AS sea ON (ser.id = sea.serie_id) GROUP BY sea.serie_id;


# 4- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, COUNT(mo.genre_id) FROM genres AS gen JOIN movies AS mo ON (mo.genre_id = gen.id) GROUP BY mo.genre_id;

# 5- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT act.first_name, act.last_name FROM actors AS act JOIN actor_movie AS act_mov JOIN movies AS mo ON (act.id = act_mov.actor_id AND act_mov.movie_id = mo.id AND mo.title LIKE "%La guerra de las galaxias%");