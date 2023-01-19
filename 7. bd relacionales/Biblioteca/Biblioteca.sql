-- Datos tabla AUTOR
insert into autor (nombre, nacionalidad) values
("Escritor 1", "Argentina"),("Escritor 2", "España"),("Escritor 3", "Uruguay"),("Escritor 4", "Colombia"),("Escritor 5", "Chile");

-- Datos tabla ESTUDIANTE
insert into estudiante (nombre, apellido, direccion, carrera, edad) values
("Juan", "Perez", "Los condores 12", "Abogacia", 22),
("Pedro", "Pascal", "Corrientes 250", "Economia", 19),
("Carlos", "Gimenez", "Malvinas Argentinas 21", "Ing. Quimica", 25),
("Maria", "Alves", "Catamarca 45", "Medicina", 24),
("Carla", "Estrada", "General Paz 1545", "Educ. Fisica", 18);

-- Datos tabla LIBRO
insert into libro (titulo, editorial, area) values
("Libro 1", "Editorial 1", "Area 1"),
("Libro 2", "Editorial 1", "Area 2"),
("Libro 3", "Editorial 2", "Area 3"),
("Libro 4", "Editorial 3", "Area 3"),
("Libro 5", "Editorial 3", "Area 4");

-- Datos tabla LIBRO_AUTOR
insert into libro_autor (autor_id, libro_id) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

update libro_autor set libro_id = 1 where id = 2;
insert into libro_autor (autor_id, libro_id) value (2,2); 

-- Datos tabla PRESTAMO
insert into prestamo (estudiante_id, libro_id, fecha_prestamo, fecha_devolucion, devuelto) values
(1, 1, "2023-01-01", "2023-01-20", 1),
(2, 2, "2023-01-05", "2023-01-25", 1),
(3, 3, "2023-01-20", null, 0),
(4, 4, "2023-01-06", "2023-01-26", 1),
(4, 1, "2023-01-21", null, 0);

-- CONSULTAS -- [ * -> Consignas adaptadas ]

-- 1 Listar los datos de los autores
select * from autor;

-- 2 Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- 3 *¿Qué estudiantes pertenecen a la carrera Abogacia?
select concat(nombre, " ", apellido) "nombre completo" from estudiante where carrera = "Abogacia";

-- 4 *¿Qué autores son de nacionalidad Argentina o Uruguaya?
select nombre from autor where nacionalidad in ("Argentina", "Uruguay");

-- 5 *¿Qué libros no son del área de Area 1?
select titulo from libro where area = "Area 1";

-- 6 *Listar los libros de la editorial Editorial 3
select titulo from libro where editorial = "Editorial 3";

-- 7 Listar los datos de los estudiantes cuya edad es mayor al promedio
select concat(nombre, " ", apellido) "nombre completo" from estudiante where edad > (select avg(edad) from estudiante);

-- 8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G
select nombre, apellido from estudiante where apellido like "g%";

-- 9 *Listar los autores del libro “Libro 1”. (Se debe listar solamente los nombres)
select autor.nombre from libro
inner join libro_autor on libro.id = libro_autor.libro_id
inner join autor on autor.id = libro_autor.autor_id
where libro.titulo = "Libro 1";

-- 10 *¿Qué libros se prestaron al lector “Maria Alves”?
select l.titulo from libro l
inner join prestamo p on l.id = p.libro_id
inner join estudiante e on e.id = p.estudiante_id
where concat(nombre, " ", apellido) = "Maria Alves";

-- 11 Listar el nombre del estudiante de menor edad
select nombre from estudiante where edad <= (select min(edad) from estudiante);

-- 12 *Listar nombres de los estudiantes a los que se prestaron libros de Area 3.
select concat(nombre, " ", apellido) "nombre completo" from estudiante
inner join prestamo on estudiante.id = prestamo.estudiante_id
inner join libro on libro.id = prestamo.libro_id
where libro.area = "Area 3";

-- 13 *Listar los libros que pertenecen a la autora Escritor 5.
select titulo from libro
inner join libro_autor on libro.id = libro_autor.libro_id
inner join autor on autor.id = libro_autor.autor_id
where autor.nombre = "Escritor 5";

-- 14 *Listar títulos de los libros que debían devolverse el 26-01-2023
select titulo from libro
inner join prestamo on libro.id = prestamo.libro_id
where prestamo.fecha_devolucion = "2023-01-26";




