DROP TABLE IF EXISTS PEOPLE cascade;
DROP TABLE IF EXISTS CONVERSATIONS cascade;
DROP TABLE IF EXISTS ACTIONS_IN_CONVERSATIONS cascade;
DROP TABLE IF EXISTS ROBOTS cascade;
DROP TABLE IF EXISTS ROBOT_FEATURES cascade;
DROP TABLE IF EXISTS EMOTIONS cascade;
DROP TABLE IF EXISTS FEATURES cascade;

CREATE TYPE CONVERSATION_MOOD as enum ('вялый', 'бесплодный', 'скучный', 'глубокий');
CREATE TYPE CONVERSATION_LENGTH as enum('краткий', 'долгий');

CREATE TABLE CONVERSATIONS(
    id serial PRIMARY KEY,
    about text NULL,
    length CONVERSATION_LENGTH,
    mood CONVERSATION_MOOD
);

CREATE TABLE PEOPLE(
    id serial PRIMARY KEY,
    gender boolean,
    name varchar(64),
    conversation_id bigint references CONVERSATIONS(id)
);

CREATE TABLE ACTIONS_IN_CONVERSATIONS(
    id serial PRIMARY KEY,
    acting_person_id bigint references PEOPLE(id),
    action_description text,
    conversation_id bigint references CONVERSATIONS(id)
);

CREATE TABLE ROBOTS(
    id serial PRIMARY KEY,
    model text,
    conversation_id bigint references CONVERSATIONS(id)
);

CREATE TABLE ROBOT_FEATURES(
    id serial PRIMARY KEY,
    description text,
    robot_id bigint references ROBOTS(id)
);

CREATE TABLE EMOTIONS(
    id serial PRIMARY KEY,
    person_id bigint references PEOPLE(id),
    description text,
    cause text NULL,
    intensity float CONSTRAINT intensity_range CHECK ( intensity>=0 AND intensity <= 10 )
);

CREATE TABLE FEATURES(
    id serial PRIMARY KEY,
    description text,
    person_id bigint references PEOPLE(id)
);

INSERT INTO CONVERSATIONS(id, about, length, mood) VALUES
   (DEFAULT, 'допрос', 'краткий', 'глубокий');

INSERT INTO ROBOTS(id, model, conversation_id) VALUES
    (DEFAULT, 'r2d2', 0);

INSERT INTO ROBOT_FEATURES(id, description, robot_id) VALUES
    (DEFAULT, 'краткость', 0),
    (DEFAULT, 'точность', 0),
    (DEFAULT, 'может привести в отчаяние', 0);

INSERT INTO PEOPLE(id, gender, name, conversation_id) VALUES
    (DEFAULT, false, 'Олвин', 0),
    (DEFAULT, false, 'ХИВЛА', 0);

INSERT INTO EMOTIONS(id, person_id, description, cause, intensity) VALUES
    (DEFAULT, 0, 'отчаяние', 'диалог с роботом', 8),
    (DEFAULT, 0, 'обессилен', 'диалог с роботом', 6);

INSERT INTO ACTIONS_IN_CONVERSATIONS(id, acting_person_id, action_description, conversation_id) VALUES
    (DEFAULT, 1, 'вмешался в диалог', 0);
