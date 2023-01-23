CREATE TEMPORARY TABLE TWD (chapter_title varchar(45), season_title varchar(45));

INSERT INTO TWD 
	SELECT e.title, sn.title
    FROM episodes e
    JOIN seasons sn ON e.season_id = sn.id
    JOIN series s ON sn.serie_id = s.id
    WHERE s.title = "the walking dead"
;

SELECT * FROM TWD WHERE season_title = "primer temporada";