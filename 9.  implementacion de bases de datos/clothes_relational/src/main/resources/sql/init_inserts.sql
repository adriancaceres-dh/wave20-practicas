-- Insert into clothes
INSERT INTO clothes (id, name, type, brand, color, size, quantity, price)
VALUES
    (1, "Running shorts", "Shorts", "Adidas", "Black", "M", 3, 300),
    (2, "Running shirt", "Shirt", "Nike", "Blue", "S", 2, 500),
    (3, "Polo shirt", "Shirt", "Adidas", "Black", "M", 3, 300),
    (4, "Training pants", "Pants", "Under Armour", "Black", "L", 5, 900),
    (5, "Training tank", "Shirt", "Venum", "Black", "M", 2, 400),
    (6, "Jeans", "Pants", "Levis", "Blue", "S", 3, 800),
    (7, "Soccer shirt", "Shirt", "Nike", "Green", "XL", 2, 1000);

-- Insert into sales
INSERT INTO sales (id, date, total, payment_method)
VALUES
    (1, "2022-11-09", 900, "Cash"),
    (2, "2022-12-12", 1900, "Credit card"),
    (3, "2023-01-21", 2800, "Debit card"),
    (4, "2023-01-21", 7900, "Credit card");

-- Insert into sale_garment
INSERT INTO sale_garment (sale_id, garment_id)
VALUES
    (1, 1),
    (2, 1),
    (2, 2),
    (3, 5),
    (3, 7),
    (4, 2),
    (4, 4),
    (4, 6);
