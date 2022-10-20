CREATE TABLE IF NOT EXISTS service.owners
(
    id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(20) NOT NULL ,
    last_name VARCHAR(20) NOT NULL ,
    age int NOT NULL
);