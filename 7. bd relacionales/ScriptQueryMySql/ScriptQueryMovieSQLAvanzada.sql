use movies_db;
-- select title, name from series s inner join genres g on s.genre_id = g.id;
-- select title, first_name, last_name from episodes e inner join actor_episode ae on e.id = ae.episode_id inner join actors a on ae.actor_id = a.id;
-- select s.title, count(*) as cantidadTemp from series s inner join seasons ss on s.id = ss.serie_id group by s.title; 
-- select g.name , count(*) as totalPeliculas from genres g inner join movies m on g.id = m.genre_id group by g.name having count(*) >= 3;
-- SELECT first_name, last_name from actors a inner join actor_movie am on a.id = am.actor_id inner join movies m on am.movie_id = m.id where m.title like "La Guerra de las galaxias: Episodio%" group by first_name, last_name;