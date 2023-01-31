-- Insert into vehicles
INSERT INTO vehicles (id, patent, brand, model, production_year, wheel_count)
VALUES
    (1, "ABC", "Nissan", "Model 1", 2005, 4),
    (2, "DEF", "Toyota", "Model 2", 2010, 6),
    (3, "GHI", "BMW", "Model 4", 1999, 8),
    (4, "JKL", "VW", "Model 5", 2020, 4),
    (5, "MNO", "Nissan", "Model 6", 2019, 6),
    (6, "PQR", "Ford", "Model 7", 2022, 8);

-- Insert into accidents
INSERT INTO accidents (id, economic_loss, vehicle_id)
VALUES
    (1, 10000, 1),
    (2, 100, 2),
    (3, 2000, 3),
    (4, 30000, 4),
    (5, 300, 5),
    (6, 15000, 6),
    (7, 12000, 3),
    (8, 10000, 6);