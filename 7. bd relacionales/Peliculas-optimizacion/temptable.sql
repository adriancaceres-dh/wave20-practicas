CREATE TEMPORARY TABLE twd (episode_title VARCHAR(45), release_date DATETIME, season_title VARCHAR(45));

INSERT INTO twd SELECT ep.title, ep.release_date, ss.title
FROM episodes ep
	JOIN seasons ss
		ON ep.season_id = ss.id
	JOIN series se
		ON se.id = ss.serie_id
WHERE se.id = 3;

SELECT *
FROM twd
WHERE season_title = "Primer Temporada";