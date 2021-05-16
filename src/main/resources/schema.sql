CREATE TABLE customers
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    delivery_address TEXT NOT NULL

);

CREATE TABLE books
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    price    INTEGER NOT NULL CHECK (price > 0),
    quantity INTEGER NOT NULL DEFAULT 0 CHECK (quantity >= 0),
    author TEXT NOT NULL,
    weight INTEGER NOT NULL CHECK (weight > 0)
);
CREATE TABLE posts (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       content TEXT,
                       media TEXT
);

CREATE TABLE orders
(
    order_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customer_id INTEGER NOT NULL REFERENCES customers,
    book_id INTEGER NOT NULL REFERENCES books,
    order_price INTEGER NOT NULL CHECK (order_price > 0),
    order_weight INTEGER NOT NULL CHECK (order_weight > 0)
);

