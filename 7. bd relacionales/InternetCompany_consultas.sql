-- 1 Traer todos los clientes
SELECT * FROM client;

-- 2 Traer nombre y apellido de todos los clientes, que paguen más de $3000
SELECT client.name, client.lastName, internet.price, internet.name
FROM client
INNER JOIN internet
ON client.internet_id = internet.id
WHERE internet.price >3000;

-- 3 ¿Cuantos clientes tiene cada plan?
SELECT COUNT(client.name) as clientes, internet.name 
FROM client
INNER JOIN internet
ON client.internet_id = internet.id
GROUP BY internet.name
ORDER BY clientes DESC;

