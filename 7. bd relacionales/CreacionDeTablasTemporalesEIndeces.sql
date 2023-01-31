CREATE TEMPORARY TABLE TWD
SELECT series.*, seasons.number, seasons.title as season_title FROM SERIES JOIN SEASONS ON series.id = seasons.serie_id 
JOIN episodes ON episodes.season_id = seasons.id where series.title="The Walking Dead";

SELECT * FROM TWD WHERE	number = 1;

CREATE INDEX ind ON movies (title);

SHOW INDEX FROM movies;