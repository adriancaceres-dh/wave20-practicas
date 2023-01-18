-- Usar empresa_internet
USE empresa_internet;

-- Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO planes
VALUES
	(null, "Mejor", 50, 500, 0.2),
	(null, "Veloz", 30, 300, 0.1),
	(null, "Neutro", 20, 200, 0.05),
	(null, "Normal", 10, 150, 0.0),
	(null, "Malo", 5, 100, 0.0);
    
INSERT INTO clientes
VALUES
	(null, "ABC123", "Pedro", "Hernandez", "1998-05-25", "Guadalajara", null);
    
-- Realizar las asociaciones/relaciones correspondientes entre estos registros.


-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.
