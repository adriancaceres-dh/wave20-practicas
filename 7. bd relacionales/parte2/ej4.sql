select * from customers as c join pack as p on c.idcustomers = p.customer_id where idcustomers > 3;
select name, city, p.speed from customers as c join pack as p on c.idcustomers = p.customer_id where city = "mendoza";
select avg(p.price) as precio_promedio_x_ciudad, c.city from customers as c join pack as p on c.idcustomers = p.customer_id where city = "mendoza";
select sum(pack.speed) as velocidadTtoal from pack; 
