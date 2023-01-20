-- 1. Listar los datos de los autores.

SELECT * FROM autor;

-- 2. Listar nombre y edad de los estudiantes

SELECT nombre, edad FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?

SELECT concat(nombre, " " ,apellido) "Nombre Completo", carrera
FROM estudiante
WHERE carrera = "informatica";

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?

SELECT concat(nombre, " " ,apellido) "Nombre Completo", nacionalidad
FROM autor
WHERE nacionalidad IN ("francesa", "italiana");

-- 5. ¿Qué libros no son del área de internet?

SELECT titulo
FROM libro
WHERE area != "internet";

-- 6. Listar los libros de la editorial Salamandra.

SELECT titulo
FROM libro
WHERE editorial = "salamandra";

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre
FROM estudiante
WHERE apellido LIKE "g%";

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT au.nombre
FROM autor au
	JOIN libro_autor
		ON libro_autor.id_autor = au.id_autor
	JOIN libro li
		ON libro_autor.id_libro = li.id_libro
WHERE libro.titulo = "El Universo: Guia de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT li.titulo
FROM libro li
	JOIN prestamo pr
		ON pr.id_libro = li.id_libro
	JOIN estudiante es
		ON pr.id_lector = es.id_lector
WHERE es.id_lector = (
	SELECT id_lector FROM estudiante WHERE concat(es.nombre, " ", es.apellido) = "Filippo Galli"
    );
    
-- 11. Listar el nombre del estudiante de menor edad.

SELECT nombre
FROM estudiante
ORDER BY edad
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT nombre
FROM estudiante es
	JOIN prestamo pr
		ON pr.id_lector = es.id_lector
	JOIN libro li
		ON pr.id_libro = li.id_libro
WHERE li.area = "Base de Datos";

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT li.titulo
FROM libro li
	JOIN libro_autor
		ON libro_autor.id_libro = li.id_libro
	JOIN autor au
		ON au.id_autor = libro_autor.id_autor
WHERE au.nombre = "J.K. Rowling";

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT li.titulo
FROM libro li
         JOIN prestamo pr
			ON li.id_libro = pr.id_libro
WHERE pr.fecha_devolucion < "2021-07-16"
  AND pr.devuelto = 1;