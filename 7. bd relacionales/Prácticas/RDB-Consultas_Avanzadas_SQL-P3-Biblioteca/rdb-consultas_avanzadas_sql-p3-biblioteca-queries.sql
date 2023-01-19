-- Listar los datos de los autores.
SELECT * FROM autor;

-- Listar nombre y edad de los estudiantes.
SELECT concat(nombre, " ", apellido) as nombre_completo, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT concat(nombre, " ", apellido) as nombre_completo, edad, carrera
FROM estudiante
WHERE carrera = "informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad IN ("francesa", "italiana");

-- ¿Qué libros no son del área de historia?
SELECT titulo, area
FROM libro
WHERE area <> "historia";

-- Listar los libros de la editorial Ediciones3K.
SELECT titulo, editorial
FROM libro
WHERE editorial = "Ediciones3K";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE edad > (SELECT avg(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra B.
SELECT concat(nombre, " ", apellido) as nombre_completo
FROM estudiante
WHERE apellido LIKE "B%"; 

-- Listar los autores del libro “Cartaman” (Se debe listar solamente los nombres).
SELECT a.nombre as autor, l.titulo as libro
FROM autor a
	JOIN libro_autor la ON la.idAutor = a.idAutor
    JOIN libro l ON l.idLibro = la.idLibro
WHERE l.titulo = "Cartaman";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT concat(e.nombre, " ", e.apellido) as estudiante, l.titulo as libro
FROM libro l
	JOIN prestamo p ON p.idLibro = l.idLibro
    JOIN estudiante e ON e.idLector = p.idLector
WHERE e.nombre = "Santiago" AND e.apellido = "Valdez";

-- Listar el nombre del estudiante de menor edad.
SELECT concat(nombre, " ", apellido) as estudiante, edad
FROM estudiante
ORDER BY edad ASC
LIMIT 1; 

-- Listar nombres de los estudiantes a los que se prestaron libros de cuentos.
SELECT concat(e.nombre, " ", e.apellido) as estudiante, l.titulo as libro, l.area
FROM estudiante e
	JOIN prestamo p ON e.idLector = p.idLector
    JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = "cuentos";

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo as libro, a.nombre as autor
FROM libro l
	JOIN libro_autor la ON l.idLibro = la.idLibro
    JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 08/01/2023.
