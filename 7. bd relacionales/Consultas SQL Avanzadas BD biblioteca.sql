Insert into Libro values (1,"El universo","Norma","Geografia");
Insert into Libro values (2,"Libro de culinaria","Salamandra","Recreacion");
Insert into Libro values (3,"Bases de datos","Norma","Educacion");
Insert into Libro values (4,"Libro de Religion","Salamandra","Religion");
Insert into Libro values (5,"Libro de ESports","Norma","Internet");

Insert into Autor values (1,"Pedro","Colombia");
Insert into Autor values (2,"Juan","Italiana");
Insert into Autor values (3,"Antonio","Alemania");
Insert into Autor values (4,"J.K. Rowling","Canada");
Insert into Autor values (5,"Alejandro","Francesa");

Insert into LibroAutor values (1,3);
Insert into LibroAutor values (2,5);
Insert into LibroAutor values (4,1);
Insert into LibroAutor values (3,2);
Insert into LibroAutor values (5,4);

Insert into Estudiante values (1,"Diego","Malagon","cll 93","Fisica",23);
Insert into Estudiante values (2,"Filippo","Galli","cll 75","Quimica",22);
Insert into Estudiante values (3,"David","Mendoza","cll 23","Deportes",30);
Insert into Estudiante values (4,"Camilo","Castro","cll 101","Matematica",18);
Insert into Estudiante values (5,"Alberto","Garcia","cll 12","Informatica",19);

Insert into Prestamo values (1,"2022-02-04", "2022-05-04", true,1,5);
Insert into Prestamo values (2,"2021-02-04", "2021-07-16", true,2,4);
Insert into Prestamo values (3,"2022-03-14", "2022-04-14", true,3,3);
Insert into Prestamo values (4,"2022-08-10", "2022-12-10", true,4,2);
Insert into Prestamo values (5,"2022-05-27", "2022-06-08", true,5,1);

-- CONSULTAS PLANTEADAS:

-- 1) Listar los datos de los autores.
Select Nombre, Nacionalidad from Autor;

-- 2) Listar nombre y edad de los estudiantes
Select Nombre, Edad from Estudiante;

-- 3) ¿Qué estudiantes pertenecen a la carrera informática?
Select Nombre, Apellido from Estudiante where Carrera like "%Informatica%";

-- 4) ¿Qué autores son de nacionalidad francesa o italiana?
Select Nombre from Autor where Nacionalidad like "Francesa" or Nacionalidad like "Italiana";

-- 5) ¿Qué libros no son del área de internet?
Select Titulo from Libro where Area not like "%Internet%";

-- 6) Listar los libros de la editorial Salamandra.
Select Titulo from Libro where Editorial like "Salamandra";

-- 7) Listar los datos de los estudiantes cuya edad es mayor al promedio.
Select Nombre, Apellido from Estudiante
where Edad > (Select avg(Edad) from Estudiante);

-- 8) Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
Select Nombre, Apellido from Estudiante where Apellido like "G%";

-- 9) Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
Select Autor.Nombre from Autor
join LibroAutor on (Autor.idAutor= LibroAutor.Autor_idAutor) 
join Libro on (Libro.idLibro = LibroAutor.Libro_idLibro)
where Libro.Titulo ="El universo";

-- 10) ¿Qué libros se prestaron al lector “Filippo Galli”?
Select Libro.Titulo from Libro 
join Prestamo on (Libro.idLibro = Prestamo.Libro_idLibro)
join Estudiante on (Estudiante.idEstudiante = Prestamo.Estudiante_idEstudiante)
where Estudiante.Nombre = "Filippo" and Estudiante.Apellido = "Galli";

-- 11) Listar el nombre del estudiante de menor edad.
Select Nombre, Apellido from Estudiante
where Edad = (Select Min(Edad) from Estudiante);

-- 12) Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
Select Estudiante.Nombre, Estudiante.Apellido from Estudiante 
join Prestamo on (Estudiante.idEstudiante = Prestamo.Estudiante_idEstudiante)
join Libro on (Prestamo.Libro_idLibro = Libro.idLibro)
where Libro.Titulo = "Bases de datos"; 

-- 13) Listar los libros que pertenecen a la autora J.K. Rowling.
Select Libro.Titulo from Libro
join LibroAutor on (Libro.idLibro = LibroAutor.Libro_idLibro)
join Autor on (LibroAutor.Autor_idAutor = Autor.idAutor)
where Autor.Nombre = "J.K. Rowling";

-- 14) Listar títulos de los libros que debían devolverse el 16/07/2021.
Select Libro.Titulo from Libro 
join Prestamo on (Libro.idLibro= Prestamo.Libro_idLibro)
where Prestamo.FechaDevolucion = "2021-07-16";


