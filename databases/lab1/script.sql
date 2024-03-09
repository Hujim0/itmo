DROP TABLE IF EXISTS People;
DROP TABLE IF EXISTS Actions_with_items;
DROP TABLE IF EXISTS Items;


CREATE TABLE People(
    person_id INT CONSTRAINT person_id_pk PRIMARY KEY,
    name varchar(32)
);

CREATE TABLE Actions_with_items(
    action_id INT CONSTRAINT action_id_pk PRIMARY KEY,
    status varchar(1024) NOT NULL,
    item_id INT,
    consequence_of_action_id INT,
    who_did_it_id INT
);

CREATE TABLE Items(
    item_id INT CONSTRAINT item_id_pk PRIMARY KEY,
    item_name varchar(32) NOT NULL
);

INSERT INTO People(person_id, name)
VALUES (1, "Боумен"),
       (2, "Уайтхед");

INSERT INTO Actions_with_items(action_id, status, item_id, consequence_of_action_id, who_did_it_id)
VALUES (1, 'Сломано', 1, NULL, 1),
       (2, 'Нажата', 2, NULL, 1),
       (3, 'Внешне ничего не изменилось', 3, 2, NULL),
       (4, 'Пульсирующие кривы начали убыстрять темп', 4, 2, NULL),
       (5, 'Уайтхед возвращался к жизни из гипотермического сна', NULL, 4, 2);


INSERT INTO Items(item_id, item_name)
VALUES (1, 'Печать"),
       (2, 'Кнопка''),
       (3, 'Автомат'),
        (4, 'Панель датчиков');