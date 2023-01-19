-- 1
select se.title, ge.name from series se
inner join genres ge on ge.id = se.genre_id;
-- 2
select ep.title, concat(ac.first_name, " ", ac.last_name) as name from episodes ep
inner join actor_episode on ep.id = actor_episode.episode_id
inner join actors ac on ac.id = actor_episode.actor_id;
-- 3
select se.title, count(*) as seasons_total from seasons
inner join series se on se.id = seasons.serie_id
group by se.title;
-- 4
select ge.name, count(*) as movies_total from movies
inner join genres ge on ge.id = movies.genre_id
group by ge.name having movies_total >= 3;
-- 5
select distinct concat(ac.first_name, " ", ac.last_name) as name from actors ac
inner join actor_movie on ac.id = actor_movie.actor_id
inner join movies mo on mo.id = actor_movie.actor_id
where mo.title like "%la guerra de las galaxias%";


