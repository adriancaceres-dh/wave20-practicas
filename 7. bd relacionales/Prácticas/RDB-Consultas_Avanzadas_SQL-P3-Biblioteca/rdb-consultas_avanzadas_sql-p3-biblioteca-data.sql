INSERT INTO autor VALUES(null, "lucas", "argentina");
INSERT INTO autor VALUES(null, "martin", "uruguaya");
INSERT INTO autor VALUES(null, "lucia", "argentina");
INSERT INTO autor VALUES(null, "luciana", "francesa");
INSERT INTO autor VALUES(null, "matias", "colombiana");

INSERT INTO estudiante VALUES(null, "Carlos", "Rodriguez", "dir1", "abogacia", 22);
INSERT INTO estudiante VALUES(null, "Carla", "Suarez", "dir2", "abogacia", 32);
INSERT INTO estudiante VALUES(null, "Gonzalo", "Barreiro", "dir3", "arquitectura", 27);
INSERT INTO estudiante VALUES(null, "Luciano", "Benavides", "dir4", "ingenieria", 55);
INSERT INTO estudiante VALUES(null, "Santiago", "Valdez", "dir5", "arquitectura", 38);
INSERT INTO estudiante VALUES(null, "Andrea", "Ruiz", "dir5", "informatica", 38);
INSERT INTO estudiante VALUES(null, "Nicolas", "Chiesa", "dir5", "informatica", 38);

INSERT INTO libro VALUES(null, "Carta Robada", "Ediciones3K", "cuentos");
INSERT INTO libro VALUES(null, "Carta Rosa", "Ediciones2K", "novelas");
INSERT INTO libro VALUES(null, "Las cartas", "Edic", "historia");
INSERT INTO libro VALUES(null, "Los carteristas", "Edic", "novelas");
INSERT INTO libro VALUES(null, "Cartaman", "Ediciones3K", "cuentos");

INSERT INTO libro_autor VALUES(1,2);
INSERT INTO libro_autor VALUES(1,1);
INSERT INTO libro_autor VALUES(2,2);
INSERT INTO libro_autor VALUES(2,4);
INSERT INTO libro_autor VALUES(3,3);
INSERT INTO libro_autor VALUES(4,2);
INSERT INTO libro_autor VALUES(4,3);
INSERT INTO libro_autor VALUES(5,2);
INSERT INTO libro_autor VALUES(5,1);
INSERT INTO libro_autor VALUES(5,4);

INSERT INTO prestamo VALUES(null,5,4,"2001-01-01","2023-08-01",0);
INSERT INTO prestamo VALUES(null,5,2,"2011-03-01","2022-03-10",1);
INSERT INTO prestamo VALUES(null,5,5,"2002-02-01","2008-05-03",1);
INSERT INTO prestamo VALUES(null,4,4,"2003-05-01","2011-03-05",0);
INSERT INTO prestamo VALUES(null,4,3,"2010-06-01","2014-07-11",1);