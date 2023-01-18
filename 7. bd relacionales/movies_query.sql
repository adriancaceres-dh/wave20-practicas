#Mostrar todos los registros de la tabla de movies
SELECT * 
FROM movies;

#Mostrar el nombre, apellido y rating de todos los actores
SELECT 	first_name, l
		ast_name, 
		rating 
FROM actors;

SELECT 	concat(first_name, ' ', last_name) 	AS 	Nombre,
		rating								AS	Puntaje
FROM	actors;

#Mostrar el titulo de todas las series y usar alias para que tanto el nombre de la tabla como el campo esten en español
SELECT  title 	AS	Titulo
FROM 	series 	AS	SERIES;

#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5
SELECT 	concat(first_name, ' ', last_name) 	AS Nombre,
		rating								AS Puntaje
FROM	actors								
WHERE 	rating > 7.5;

#Mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con mas de dos premios.
SELECT 	title	AS	Titulo, 
		rating	AS	Puntaje,
        awards	AS	Premios
FROM	movies
WHERE 	rating > 7.5
AND		awards > 2; 		
		
#Mostrar el titulo de las peliculas y el rating ordenadas por rating en forma ascendente        
SELECT 		title	AS	Titulo,
			rating	AS	Puntaje
FROM		movies
ORDER BY 	rating 	ASC;

#Mostrar los titulos de las primeras tres peliculas en la base de datos
SELECT	id,
		title	AS	Titulo
FROM	movies
LIMIT	3;

#Mostrar el top 5 de las peliculas con mayor rating
SELECT		rating	AS	Puntaje,
			title	AS	Titulo
FROM		movies
ORDER BY 	rating 	DESC
LIMIT 		5;

#Listar los primeros 10 actores
SELECT 	id,
		concat(first_name, ' ', last_name)	AS Nombre
FROM	actors
LIMIT 	10;

#Mostrar el titulo y rating de todas las peliculas cuyo titulo sea de Toy Story
SELECT 	title			AS	Titulo,
		rating			AS	Puntaje,
		release_date	AS	Lanzamiento
FROM	movies
WHERE 	title	LIKE '%Toy Story%';

#Mostrar a todos los actores cuyos nombres empiezan con Sam
SELECT 	concat(first_name, ' ', last_name)	AS	 Nombre
FROM 	actors
WHERE 	first_name	LIKE '%sam';

#Mostrar el titulo de las peliculas que salieron entre el 2004 y 2008
SELECT 	title			AS	Titulo,
		release_date	AS 	Lanzamiento
FROM	movies
WHERE 	YEAR(release_date) 
BETWEEN 2004
		AND 
		2008;

#Traer el titulo de las peliculas con el rating mayor a 3, con mas de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT		title	AS	Titulo
FROM		movies
WHERE		rating > 3
AND			awards > 1
AND 		YEAR(release_date) 
BETWEEN 	1988
			AND 
			2009
ORDER BY 	rating DESC;





