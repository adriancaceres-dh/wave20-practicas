INSERT INTO genres (id, created_at, updated_at, name, ranking, active)
VALUES (1, '2022-08-10', '2023-03-11', 'Terror', 1, 1),
       (2, '2022-08-10', '2023-03-11', 'Comedia', 2, 1);

INSERT INTO movies(id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (1, '2022-08-10', '2023-03-11', 'Toy story', 10, 5, '1998-01-01', 90, 2),
       (2, '2022-08-10', '2023-03-11', 'Madagascar', 8, 3, '2000-01-01', 100, 2),
       (3, '2022-08-10', '2023-03-11', 'Destino final', 6, 1, '2005-01-01', 110, 1);

INSERT INTO actors (id, created_at, updated_at, first_name, last_name, rating, favorite_movie_id)
VALUES (1, '2022-08-10', '2023-03-11', 'Pedro', 'Gonzalez', 5.5, 3),
       (2, '2022-02-15', '2023-02-15', 'Laura', 'Perito', 7.0, 2),
       (3, '2022-05-30', '2023-05-30', 'Carlos', 'Mirito', 3.5, 1),
       (4, '2022-03-06', '2023-03-06', 'Lautaro', 'Benavidez', 7.4, null),
       (5, '2022-06-11', '2023-06-11', 'Ernesto', 'Actorazo', 8.9, null),
       (6, '2022-11-09', '2023-11-09', 'Milena', 'Luna', 10.0, 1),
       (7, '2022-10-24', '2023-10-24', 'Florencia', 'Perez', 9.4, 3);

INSERT INTO actor_movie (id, created_at, updated_at, actor_id, movie_id)
VALUES (1,'2022-08-10', '2022-08-10', 1, 1),
       (2,'2022-08-10', '2022-08-10', 3, 1),
       (3,'2022-08-10', '2022-08-10', 7, 1),
       (4,'2022-08-10', '2022-08-10', 7, 2);
