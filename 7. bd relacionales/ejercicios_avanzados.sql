-- 1)

SELECT 
    s.title, g.name
FROM
    series s
        JOIN
    genres g ON s.genre_id = g.id;
    
-- 2)
    
SELECT 
    e.title, a.first_name, a.last_name
FROM
    episodes e
        JOIN
    actor_episode ae ON e.id = ae.episode_id
        JOIN
    actors a ON a.id = ae.actor_id;
    
-- 3)

SELECT 
    series.id, series.title, COUNT(*) AS seasons_amount
FROM
    series
        JOIN
    seasons ON seasons.serie_id = series.id
GROUP BY series.id;

-- 4)

SELECT 
    g.name, COUNT(*) AS movies_count
FROM
    genres g
        JOIN
    movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING movies_count >= 3;

-- 5)

SELECT 
    a.first_name, a.last_name
FROM
    actors a
        JOIN
    actor_movie am ON am.actor_id = a.id
        JOIN
    movies m ON m.id = am.movie_id
WHERE
    m.title LIKE '%Guerra de las galaxias%'
GROUP BY a.id
HAVING COUNT(*) = (SELECT 
        COUNT(*)
    FROM
        movies
    WHERE
        title LIKE '%Guerra de las galaxias%');
        