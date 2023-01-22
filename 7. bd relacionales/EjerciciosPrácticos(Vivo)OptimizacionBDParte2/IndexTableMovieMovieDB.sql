 -- EXPLAIN SELECT * FROM movies_db.movies where length = 180;
 -- ALTER TABLE `movies_db`.`movies` 
-- ADD INDEX `length_index` (`length` ASC) VISIBLE;
-- ;
 explain SELECT * FROM movies_db.movies where length = 180;