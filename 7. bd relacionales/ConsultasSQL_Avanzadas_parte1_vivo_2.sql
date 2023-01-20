-- ¿Qué libros no son del área de internet?

SELECT *
FROM libro as l
WHERE NOT l.area = "Internet"; 