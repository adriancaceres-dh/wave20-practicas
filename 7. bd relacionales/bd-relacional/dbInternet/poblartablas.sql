use internetdb;
-- Insertar planes
INSERT INTO plan(idplan,velocidad_en_megas,precio,descuento) VALUES(1,50,100,0),
	(2,100,150,0.10),(3,150,200,0.00),(4,200,250,0.00),(5,250,300,0.20);
    
-- Insertar clientes
INSERT INTO cliente(DNI,nombre,apellido,fecha_de_nacimiento,provincia,ciudad,idplan)
		values (123,'Camilo','Arango','1994-07-26','Antioquia','Medellin',3),
			(124,'Andres','Martinez','1994-05-26','Cundinamarca','Bogota',2),
            (125,'Camilo','Velez','1995-2-06','Antioquia','Cocorna',1),
            (126,'Sara','Correa','1998-05-30','Cordoba','Monteria',4),
            (127,'Daniela','Barragan','2001-07-05','Santander','Bucaramanga',5),
            (128,'Juan','Arango','1994-09-07','Antioquia','Medellin',3),
            (129,'Luisa','Toro','1993-01-03','Sucre','Sincelejo',1);
