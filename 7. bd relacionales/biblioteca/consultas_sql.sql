-- Usar biblioteca.
USE biblioteca;

-- Insertar datos en las tablas
INSERT INTO estudiantes
VALUES
	(null, "Armando", "Prieto", "Jardines 105", "Negocios", 22),
	(null, "Lucas", "Estévez", "Monte 402", "Informática", 20),
	(null, "Humberto", "Solera", "Lomas 975", "Negocios", 19),
	(null, "Marita", "Crespi", "Bosques 14", "Industrial", 24),
	(null, "Filippo", "Galli", "Campestre 167", "Quiímica", 17),
    (null, "Jimena", "Álvarez", "Rosas 632", "Informática", 27);

INSERT INTO autores
VALUES
	(null, "J.K. Rowling", "Reino Unido"),
    (null, "Michelle Boucher", "Francia"),
    (null, "Oliver Berry", "Reino Unido"),
    (null, "Mark Jones", "Estados Unidos"),
    (null, "Luigi Bajardi", "Italia");
    
INSERT INTO libros
VALUES
	(null, "Harry Potter y la piedra filosofal", "Salamandra", "Ficción"),
    (null, "Harry Potter y la cámara secreta", "Salamandra", "Ficción"),
    (null, "Bases de datos para principiantes", "Informa", "Base de datos"),
    (null, "Internet de las cosas", "Librociencia", "Internet"),
    (null, "Bases de datos para expertos", "Informa", "Base de datos"),
    (null, "Protocolo HTTP", "Librociencia", "Internet"),
    (null, "El Universo: Guía de viaje", "Salamandra", "Aventura");
    
INSERT INTO libro_autor
VALUES
	(null, 1, 1),
    (null, 1, 2),
    (null, 2, 3),
    (null, 5, 4),
    (null, 4, 5),
    (null, 5, 6),
    (null, 3, 7);
    
INSERT INTO prestamos
VALUES
	(null, 5, 5, "2022-01-01", "2022-01-18", 1),
    (null, 2, 3, "2021-01-04", "2021-07-16", 0),
    (null, 1, 1, "2022-01-06", "2022-01-15", 1),
    (null, 5, 2, "2021-04-15", "2021-07-16", 1),
    (null, 4, 5, "2022-01-09", "2022-01-12", 0);

-- 1. Listar los datos de los autores.
SELECT id_autor, nombre, nacionalidad
FROM autores;

-- 2. Listar nombre y edad de los estudiantes.
SELECT nombre, edad
FROM estudiantes;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT id_estudiante, nombre, apellido, direccion, carrera, edad
FROM estudiantes
WHERE carrera LIKE "informática";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT id_autor, nombre, nacionalidad
FROM autores
WHERE nacionalidad IN ("francia", "italia");

-- 5. ¿Qué libros no son del área de internet?
SELECT id_libro, titulo, editorial, area
FROM libros
WHERE area NOT LIKE "internet";

-- 6. Listar los libros de la editorial Salamandra.
SELECT id_libro, titulo, editorial, area
FROM libros
WHERE editorial LIKE "salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT id_estudiante, nombre, apellido, direccion, carrera, edad
FROM estudiantes
WHERE edad > (SELECT AVG(edad) FROM estudiantes);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM estudiantes
WHERE apellido LIKE "g%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autores AS a
INNER JOIN libro_autor AS lxa ON lxa.id_autor = a.id_autor
INNER JOIN libros AS l ON l.id_libro = lxa.id_libro
WHERE l.titulo LIKE "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.id_libro, l.titulo, l.editorial, l.area
FROM libros AS l
INNER JOIN prestamos AS p ON p.id_libro = l.id_libro
INNER JOIN estudiantes AS e ON e.id_estudiante = p.id_lector
WHERE e.nombre LIKE "Filippo" AND e.apellido LIKE "Galli";

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiantes
ORDER BY edad
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM estudiantes AS e
INNER JOIN prestamos AS p ON p.id_lector = e.id_estudiante
INNER JOIN libros AS l ON l.id_libro = p.id_libro
WHERE area LIKE "base de datos"
GROUP BY e.id_estudiante;

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.id_libro, l.titulo, l.editorial, l.area
FROM libros AS l
INNER JOIN libro_autor AS lxa ON lxa.id_libro = l.id_libro
INNER JOIN autores AS a ON a.id_autor = lxa.id_autor
WHERE a.nombre LIKE "J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libros AS l
INNER JOIN prestamos AS p ON p.id_libro = l.id_libro
WHERE p.fecha_devolucion = "2021-07-16"
GROUP BY l.id_libro;