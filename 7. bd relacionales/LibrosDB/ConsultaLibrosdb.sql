USE librosdb;
-- Listar los datos de los autores.
SELECT * FROM Autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre ,edad FROM Estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante as est
WHERE est.carrera LIKE "informática";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor as a
WHERE a.nacionalidad IN ("francesa","italiana");
-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro as lbr
WHERE lbr.area NOT LIKE "%internet%";
-- Listar los libros de la editorial Salamandra.
SELECT * FROM Libro as lbr
WHERE lbr.editorial LIKE "%Salamandra%";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante as est
WHERE est.edad > (
	SELECT AVG(est.edad) FROM Estudiante
);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM Estudiante as est
WHERE est.apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre 
FROM Libro as l
INNER JOIN LibroAutor as la ON l.idLibro=la.idLibro
INNER JOIN Autor as a ON la.idAutor=a.idAutor
WHERE l.titulo LIKE "%El Universo: Guía de viaje%";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM Libro as l
INNER JOIN Prestamo as p ON l.idLibro=p.idLibro
INNER JOIN Estudiante as est ON p.idLector=est.idLector
WHERE est.nombre LIKE "Filippo Galli";
-- Listar el nombre del estudiante de menor edad.
	SELECT nombre FROM Estudiante
    ORDER BY nombre
    LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT est.nombre
FROM Libro as l
INNER JOIN Prestamo as p ON l.idLibro=p.idLibro
INNER JOIN Estudiante as est ON p.idLector=est.idLector
WHERE l.titulo LIKE "Base de Datos";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo 
FROM Libro as l
INNER JOIN LibroAutor as la ON l.idLibro=la.idLibro
INNER JOIN Autor as a ON la.idAutor=a.idAutor
WHERE a.nombre LIKE "%J.K. Rowling%";
-- Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo
FROM Libro as l
INNER JOIN Prestamo as p ON l.idLibro=p.idLibro
WHERE DATE(p.fechaDevolucion)="2021/07/16";
