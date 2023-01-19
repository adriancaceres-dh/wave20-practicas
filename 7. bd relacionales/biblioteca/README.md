### Biblioteca

En base al mismo, plantear las consultas SQL para resolver los siguientes requerimientos:

- Listar los datos de los autores.

~~~~sql
SELECT *
FROM autor;
~~~~

- Listar nombre y edad de los estudiantes

~~~~sql
SELECT nombre, edad
FROM estudiante;
~~~~

- ¿Qué estudiantes pertenecen a la carrera informática?

~~~~sql
SELECT nombre, apellido
FROM estudiante
WHERE carrera = "informática";
~~~~

- ¿Qué autores son de nacionalidad francesa o italiana?

~~~~sql
SELECT nombre
FROM autor
WHERE nacionalidad IN ("francesa", "italiana");
~~~~

- ¿Qué libros no son del área de internet?

~~~~sql
SELECT titulo
FROM libro
WHERE area != "internet";
~~~~

- Listar los libros de la editorial Salamandra.

~~~~sql
SELECT titulo
FROM libro
WHERE editorial = "salamandra";
~~~~

- Listar los datos de los estudiantes cuya edad es mayor al promedio.

~~~~sql
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);
~~~~

- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

~~~~sql
SELECT nombre
FROM estudiante
WHERE nombre LIKE "g%";
~~~~

- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

~~~~sql
SELECT autor.nombre
FROM autor
         JOIN libroAutor ON autor.idAutor = libroAutor.idAutor
         JOIN libro ON libroAutor.idLibro = libro.idLibro
WHERE libro.titulo = "El universo: Guía de viaje";
~~~~

- ¿Qué libros se prestaron al lector “Filippo Galli”?

~~~~sql
SELECT libro.titulo
FROM libro
         JOIN prestamo ON libro.idLibro = prestamo.idLibro
         JOIN estudiante ON estudiante.idLector = prestamo.idLector
WHERE estudiante.idLector = (SELECT idLector FROM estudiante WHERE nombre = "Filippo" AND apellido = "Galli")
~~~~

- Listar el nombre del estudiante de menor edad.

~~~~sql
SELECT *
FROM estudiante
ORDER BY edad LIMIT 1;
~~~~

- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

~~~~sql
SELECT estudiante.nombre
FROM estudiante
         JOIN prestamo ON prestamo.idLector = estudiante.idLector
         JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE libro.area = "Base de datos";
~~~~

- Listar los libros que pertenecen a la autora J.K. Rowling.

~~~~sql
SELECT libro.titulo
FROM libro
         JOIN libroAutor ON libroAutor.idLibro = libro.idLibro
         JOIN autor ON autor.idAutor = libroAutor.idAutor
WHERE autor.nombre = "J.K. Rowling";
~~~~

- Listar títulos de los libros que debían devolverse el 16/07/2021.

~~~~sql
SELECT libro.titulo
FROM libro
         JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE prestamo.fechaDevolucion < "2021-07-16"
  AND prestamo.devuelto = true -- or 1 
~~~~

