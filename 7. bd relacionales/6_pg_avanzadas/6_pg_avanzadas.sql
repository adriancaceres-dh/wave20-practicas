SELECT nombre, puesto, localidad
FROM EMPLEADO E INNER JOIN DEPARTAMENTO D
ON E.depto_nro = D.depto_nro
WHERE puesto="Vendedor";

SELECT nombre_depto
FROM DEPARTAMENTO D INNER JOIN EMPLEADO E
ON D.depto_nro = E.depto_nro
GROUP BY D.depto_nro
HAVING COUNT(*)>5;

SELECT nombre, salario, nombre_depto
FROM EMPLEADO E INNER JOIN DEPARTAMENTO D
ON D.depto_nro = E.depto_nro
WHERE puesto = (SELECT puesto FROM EMPLEADO WHERE concat(nombre," ",apellido) ="mito barchuk");

SELECT *
FROM EMPLEADO E LEFT JOIN DEPARTAMENTO D
ON D.depto_nro = E.depto_nro
WHERE D.nombre_depto = "contabilidad"
ORDER BY nombre ASC;

SELECT nombre
FROM EMPLEADO
ORDER BY salario ASC
LIMIT 1;

SELECT nombre
FROM EMPLEADO E JOIN DEPARTAMENTO D
ON D.depto_nro = E.depto_nro
WHERE nombre_depto="ventas"
ORDER BY salario DESC
LIMIT 1;

