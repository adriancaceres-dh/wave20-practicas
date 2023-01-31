-- Insert into vehicles
INSERT INTO vehicles (id, patent, brand, model, production_year, wheel_count)
VALUES
    (1, "ABC", "Nissan", "Model 1", 2005, 4),
    (2, "DEF", "Toyota", "Model 2", 2010, 6),
    (3, "GHI", "BMW", "Model 4", 1999, 8),
    (4, "JKL", "VW", "Model 5", 2020, 4),
    (5, "MNO", "Nissan", "Model 6", 2019, 6),
    (6, "PQR", "Ford", "Model 7", 2023, 8),
    (7, "STV", "VW", "Model 8", 2023, 8);

-- Insert into accidents
INSERT INTO accidents (id, date, economic_loss, vehicle_id)
VALUES
    (1, "2023-01-13", 10000, 1),
    (2, "2023-01-13", 100, 2),
    (3, "2023-01-14", 2000, 3),
    (4, "2023-01-15", 30000, 4),
    (5, "2023-01-16", 300, 5),
    (6, "2023-01-17", 15000, 6),
    (7, "2023-01-17", 12000, 3),
    (8, "2023-01-18", 10000, 6);