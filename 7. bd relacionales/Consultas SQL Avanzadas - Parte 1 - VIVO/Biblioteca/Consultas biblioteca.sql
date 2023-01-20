# Listar los datos de los autores.
Select * from autor;

# Listar nombre y edad de los estudiantes
Select concat(nombre, " ", apellido) as nombre,edad from estudiante; 

# ¿Qué estudiantes pertenecen a la carrera informática?
Select concat(nombre, " ", apellido) as nombre from estudiante where carrera = "informática";

# ¿Qué autores son de nacionalidad francesa o italiana?
Select nombre from autor where nacionalidad in ("francesa", "italiana");

# ¿Qué libros no son del área de internet?
select titulo from libro where area <> "internet";

# Listar los libros de la editorial Salamandra.
Select titulo from libro where editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
Select * from estudiante where edad > (select avg(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
Select concat(nombre, " ", apellido) as nombre from estudiante where apellido like "G%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
Select a.nombre from autor a inner join libro_autor la on (la.idAutor = a.idAutor) inner join libro l on (la.idLibro = l.idLibro)
where l.titulo = "El Universo: Guía de viaje";

# ¿Qué libros se prestaron al lector “Filippo Galli”?
Select l.titulo from libro l inner join prestamo p on (p.idLibro = l.idLibro) inner join estudiante e on (e.idLector = p.idLector)
where e.nombre = "Filippo" and e.apellido = "Galli";

# Listar el nombre del estudiante de menor edad.
Select concat(nombre, " ", apellido) as nombre from estudiante where edad = (Select min(edad) from estudiante);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Select concat(e.nombre, " ", e.apellido) as nombre from estudiante e inner join prestamo p on (e.idLector = p.idLector) inner join libro l on (p.idLibro = l.idLibro)
where l.titulo like "%Base de Datos%";

# Listar los libros que pertenecen a la autora J.K. Rowling.
Select titulo from libro l inner join libro_autor la on (la.idLibro = l.idLibro) inner join autor a on (a.idAutor = la.idAutor)
where a.nombre = "J.K. Rowling";

# Listar títulos de los libros que debían devolverse el 16/07/2021.
Select titulo from libro l inner join prestamo p on (p.idLibro = l.idLibro) where p.fechaDevolucion = "2021/07/16";
