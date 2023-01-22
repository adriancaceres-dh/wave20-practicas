USE movies_db;
DROP TABLE TWD;
CREATE TEMPORARY TABLE TWD
SELECT e.* FROM series s inner join seasons se on s.id = se.serie_id inner join episodes e on e.season_id = se.id where s.title = "The Walking Dead";
select * from TWD;