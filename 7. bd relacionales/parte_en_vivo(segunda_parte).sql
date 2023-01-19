
Ejercicio en vivo 

1) Listar los datos de los autores.
Consulta:

SELECT *
FROM autor;



2) Listar nombre y edad de los estudiantes
Consulta:

SELECT nombre, edad
FROM estudiante;



3) ¿Qué estudiantes pertenecen a la carrera informática?
Consulta:

SELECT nombre, apellido
FROM estudiante
WHERE carrera LIKE “Informatica”;




4) ¿Qué autores son de nacionalidad francesa o italiana?
Consulta:

SELECT nombre
FROM autor
WHERE nacionalidad LIKE “francesa” OR nacionalidad LIKE “italiana” ;



5) ¿Qué libros no son del área de internet?
Consulta: 

SELECT titulo, editorial, area
FROM libro 
WHERE area NOT IN (“internet”);


6) Listar los libros de la editorial Salamandra.
Consulta:

SELECT titulo, editorial, area
FROM libro
WHERE editorial IN (“salamandra”);



7) Listar los datos de los estudiantes cuya edad es mayor al promedio.
Consulta:

SELECT nombre, apellido, dirección, carrera, edad
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante)


8) Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
Consulta:

SELECT nombre
FROM estudiante
WHERE apellido LIKE “G%”



9) Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
Consulta:

SELECT aut.nombre 
FROM autor aut INNER JOIN libroautor libaut ON (aut.idAutor = libaut.idAutor)
JOIN libro lib ON (libautor.idLibro = libro.idLibro)
GROUP BY lib.titulo
HAVING lib.titulo LIKE “El Universo: Guía de viaje”  

10) ¿Qué libros se prestaron al lector “Filippo Galli”?
Consulta: 



11) Listar el nombre del estudiante de menor edad.
Consulta: 


12) Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Consulta:



13)	istar los libros que pertenecen a la autora J.K. Rowling.
Consulta:



14) Listar títulos de los libros que debían devolverse el 16/07/2021.
Consulta:






