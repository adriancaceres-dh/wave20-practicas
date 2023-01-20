select s.title, g.name from series as s join genres as g ON s.genre_id = g.id;
select e.title, a.first_name, a.last_name from actors as a join actor_episode as ae on a.id = ae.actor_id join episodes as e on e.id = ae.episode_id;
select s.title, SUM(sea.serie_id) as cant_temp from seasons as sea join series as s on sea.serie_id = s.id group by title;
select g.name, sum(m.genre_id) as moviesXgenre from genres as g join movies as m on g.id = m.genre_id  group by g.name having sum(m.genre_id) >= 3;
select distinct a.first_name, a.last_name from actors as a join actor_movie as am on a.id = am.movie_id join movies as m on m.id = am.movie_id where m.title like 'La Guerra de las galaxias: %';
