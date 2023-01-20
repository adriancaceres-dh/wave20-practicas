
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


SELECT lib.titulo, lib.editorial, lib.area
FROM libro lib INNER JOIN prestamo pre ON (lib.idlibro = pre.idlibro)
JOIN estudiante est ON (pre.idlector = est.idlector)
GROUP BY est.nombre 
HAVING est.nombre LIKE "Filippo" AND est.apellido LIKE "Galli"


11) Listar el nombre del estudiante de menor edad.
Consulta: 
 Pueden haber 2 formas de hacer:
 
Primera)
 
SELECT est.nombre, est.apellido, est.direccion, est.carrera, est.edad
FROM estudiante est
WHERE est.edad = (SELECT MIN(edad) FROM estudiante);

Segunda)

SELECT est.nombre, est.apellido, est.direccion, est.carrera, est.edad
FROM estudiante est
ORDER BY est.edad ASC LIMIT 1;


12) Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Consulta:

SELECT est.nombre
FROM estudiante est INNER JOIN prestamo prest ON est.idlector = prest.idlector
JOIN libro lib ON prest.idlibro = lib.idlibro
ORDER BY lib.titulo
HAVING lib.titulo LIKE "Base de Datos";


13)	istar los libros que pertenecen a la autora J.K. Rowling.
Consulta:

SELECT lib.titulo, lib.editorial, lib.area
FROM libro lib INNER JOIN libroautor libaut ON lib.idlibro = libautor.idautor
JOIN autor aut ON libaut.idautor = aut.idautor
GROUP BY aut.nombre
HAVING aut.nombre LIKE "J.K. Rowling"


14) Listar títulos de los libros que debían devolverse el 16/07/2021.
Consulta:

SELECT lib.titulo
FROM libro lib INNER JOIN prestamo prest ON lib.idlibro = prest.idlibro
WHERE prest.fechadevolucion = '16/07/2021'
