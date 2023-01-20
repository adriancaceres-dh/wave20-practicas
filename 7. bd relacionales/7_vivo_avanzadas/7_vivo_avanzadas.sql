-- 1
SELECT * FROM Autor;

-- 2
SELECT nombre, edad FROM Estudiante;

-- 3
SELECT concat(nombre," ",apellido) nombre_completo
FROM Estudiante
WHERE carrera = "informatica";

-- 4
SELECT nombre
FROM Autor
WHERE nacionalidad IN ("francesa", "italiana");

-- 5
SELECT titulo
FROM Libro
WHERE area != "internet";

-- 6
SELECT titulo
FROM Libro
WHERE editorial = "Salamanca";

-- 7
SELECT *
FROM Estudiante
WHERE edad > (SELECT AVG(edad) FROM Estudiante);

-- 8
SELECT nombre
FROM Estudiante
WHERE apellido LIKE "g%";

-- 9
SELECT nombre
FROM Autor A
JOIN LibroAutor LA ON A.idAutor = LA.idAutor
JOIN Libro L ON LA.idLibro = L.idLibro
WHERE L.titulo = "El Universo: Guía de viaje";

-- 10
SELECT titulo
FROM Libro L
JOIN Prestamo P ON L.idLibro = P.idLibro
JOIN Estudiante E ON P.idLector = E.idEstudiante
WHERE concat(E.nombre," ",E.apellido) = "Filippo Galli";

-- 11
SELECT nombre
FROM Estudiante
ORDER BY edad ASC
LIMIT 1;

-- 12
SELECT distinct(nombre)
FROM Estudiante E
JOIN Prestamo P ON E.idEstudiante = P.idLector
JOIN Libro L ON P.idLibro = L.idLibro;

-- 13
SELECT titulo
FROM Libro L
JOIN LibroAutor LA ON L.idLibro = LA.idLibro
JOIN Autor A ON LA.idAutor = A.idAutor
WHERE nombre = "J.K. Rowling";

-- 14
SELECT titulo, idLector
FROM Libro L
JOIN Prestamo P ON L.idLibro = P.idLibro
WHERE fechaDevolucion > "2021-07-16";