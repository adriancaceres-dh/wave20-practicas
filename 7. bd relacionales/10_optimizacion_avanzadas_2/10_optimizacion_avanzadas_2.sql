-- 1
INSERT INTO movies VALUES (null,"2023-01-20",null,"Mi pelicula inventada 1",10.0,100,"2023-01-01",42,5);

-- 2
INSERT INTO genres VALUES (null, "2023-01-20", null, "generico", 13, 1);

-- 3
UPDATE movies SET genre_id = 13 WHERE id = (SELECT id FROM (SELECT id FROM movies WHERE title = "mi pelicula inventada 1") AS T);

-- 4
UPDATE actors SET favorite_movie_id = (SELECT id FROM movies WHERE title = "mi pelicula inventada 1") WHERE favorite_movie_id IS NULL;

-- 5
CREATE TEMPORARY TABLE temp_movies AS SELECT * FROM movies;

-- 6
DELETE FROM temp_movies WHERE awards<5;

-- 7
SELECT DISTINCT(g.name)
FROM genres g
JOIN movies m ON g.id = m.genre_id;

-- 8
SELECT concat(first_name," ",last_name) AS full_name
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards>3;

-- 9
CREATE INDEX title_index on movies (title);

-- 10
DESCRIBE movies;

-- 11
-- Al crear un indice de titulos, no tendra que buscar en todos los registros para buscar determinada pelicula, solo se limitara a mirar a donde apunta el indice buscado ordenado alfabeticamente. Luego al insertar nuevos datos, modificarlos o eliminarlos, si podria haber una baja de performance porque tambien tendria que modificar los indices.

-- 12
-- Crearia otro index tambien en series con la misma idea de hacerlo con los titulos, ya que deberia ser una busqueda de lectura recurrente.