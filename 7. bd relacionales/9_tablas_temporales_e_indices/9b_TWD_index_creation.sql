-- 1
CREATE INDEX name_index ON genres (name);

-- 2
-- En los generos tanto de peliculas o series, dificilmente se vayan a estar creando nuevos. Las operaciones en general vayan a ser solo de lectura, y el nombre parece mas indicado para la busqueda que el numero de id.