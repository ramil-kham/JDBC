INSERT INTO customers (id, name, email, delivery_address) VALUES
(1, 'Иван', 'ivan@mail.ru', 'Москва'),
(2, 'Сергей', 'sergey@mail.ru', 'Казань'),
(3, 'Александр', 'alex@mail.ru', 'Ульяновск'),
(4, 'Петр', 'petr@mail.ru', 'Новосибирск'),
(5, 'Василий', 'vasya@mail.ru', 'Тверь');


INSERT INTO books (id, name, price, quantity, author, weight) VALUES
(1, 'Записки юного врача', 317, 20, 'Булгаков', 252),
(2, 'Капитанская дочка', 165, 30, 'Пушкин', 300),
(3, 'Подросток', 201, 25, 'Достоевский', 450),
(4, 'Дети капитана Гранта', 245, 15, 'Верн', 250),
(5, 'Граф Монте-Кристо', 464, 19, 'Дюма', 678),
(6, 'Вий', 171, 27, 'Гоголь', 247);

INSERT INTO orders (order_id, customer_id, book_id,  order_price, order_weight) VALUES
(1, 1, 1, 317, 252),
(2, 2, 2, 165, 300),
(3, 3, 3, 201, 450),
(4, 4, 4, 245, 250);


