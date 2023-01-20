INSERT INTO Autor VALUES(null, "lucas", "argentina");
INSERT INTO Autor VALUES(null, "martin", "uruguaya");
INSERT INTO Autor VALUES(null, "lucia", "argentina");
INSERT INTO Autor VALUES(null, "luciana", "francesa");
INSERT INTO Autor VALUES(null, "matias", "colombiana");
INSERT INTO Autor VALUES(null, "J.K. Rowling", "inglesa");

SELECT * FROM Autor;

INSERT INTO Estudiante VALUES(null, "Carlos", "Rodriguez", "dir1", "abogacia", 22);
INSERT INTO Estudiante VALUES(null, "Carla", "Suarez", "dir2", "abogacia", 32);
INSERT INTO Estudiante VALUES(null, "Gonzalo", "Barreiro", "dir3", "arquitectura", 27);
INSERT INTO Estudiante VALUES(null, "Luciano", "Benavides", "dir4", "ingenieria", 55);
INSERT INTO Estudiante VALUES(null, "Santiago", "Valdez", "dir5", "arquitectura", 38);
INSERT INTO Estudiante VALUES(null, "Andrea", "Ruiz", "dir5", "informatica", 38);
INSERT INTO Estudiante VALUES(null, "Nicolas", "Chiesa", "dir5", "informatica", 38);
INSERT INTO Estudiante VALUES(null, "Filippo", "Galli", "dir5", "letras", 77);

SELECT * FROM Estudiante;

INSERT INTO Libro VALUES(null, "Carta Robada", "Ediciones3K", "cuentos");
INSERT INTO Libro VALUES(null, "Carta Rosa", "Ediciones2K", "novelas");
INSERT INTO Libro VALUES(null, "Las cartas", "Edic", "historia");
INSERT INTO Libro VALUES(null, "Los carteristas", "Edic", "novelas");
INSERT INTO Libro VALUES(null, "Cartaman", "Ediciones3K", "cuentos");
INSERT INTO Libro VALUES(null, "Harry Potter", "Edics", "novelas");
INSERT INTO Libro VALUES(null, "Harry Potter3", "Edics", "novelas");
INSERT INTO Libro VALUES(null, "El Universo: Guía de viaje", "Ediciones3K", "cientifico");
INSERT INTO Libro VALUES(null, "Harry Potter5", "Salamanca", "novelas");

SELECT * FROM Libro;

INSERT INTO LibroAutor VALUES(1,2);
INSERT INTO LibroAutor VALUES(1,1);
INSERT INTO LibroAutor VALUES(2,2);
INSERT INTO LibroAutor VALUES(2,4);
INSERT INTO LibroAutor VALUES(3,3);
INSERT INTO LibroAutor VALUES(4,2);
INSERT INTO LibroAutor VALUES(4,3);
INSERT INTO LibroAutor VALUES(5,2);
INSERT INTO LibroAutor VALUES(5,1);
INSERT INTO LibroAutor VALUES(5,4);
INSERT INTO LibroAutor VALUES(6,6);
INSERT INTO LibroAutor VALUES(7,6);
INSERT INTO LibroAutor VALUES(8,5);

SELECT * FROM LibroAutor;

INSERT INTO Prestamo VALUES(5,4,"2001-01-01","2023-08-01",0);
INSERT INTO Prestamo VALUES(5,2,"2011-03-01","2022-03-10",1);
INSERT INTO Prestamo VALUES(5,5,"2002-02-01","2008-05-03",1);
INSERT INTO Prestamo VALUES(4,4,"2003-05-01","2011-03-05",0);
INSERT INTO Prestamo VALUES(4,3,"2010-06-01","2014-07-11",1);
INSERT INTO Prestamo VALUES(4,8,"2010-06-01","2017-07-11",1);
INSERT INTO Prestamo VALUES(1,8,"2010-06-01","2010-02-24",1);
INSERT INTO Prestamo VALUES(6,8,"2010-06-01","2022-05-04",1);

SELECT * FROM Prestamo;