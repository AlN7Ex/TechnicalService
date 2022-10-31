CREATE TABLE IF NOT EXISTS service.owners
(
    id BIGSERIAL PRIMARY KEY ,
    firstname VARCHAR(20) NOT NULL ,
    lastname VARCHAR(20) NOT NULL ,
    age int NOT NULL
);

CREATE TABLE IF NOT EXISTS service.cars
(
    id BIGSERIAL PRIMARY KEY ,
    brand VARCHAR(25) NOT NULL ,
    model VARCHAR(25) NOT NULL ,
    owner_id BIGSERIAL REFERENCES service.owners (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS service.users
(
    id BIGSERIAL PRIMARY KEY ,
    password VARCHAR(25) NOT NULL ,
    firstname VARCHAR(25) NOT NULL ,
    lastname VARCHAR(25) NOT NULL ,
    age int NOT NULL ,
    login VARCHAR(25) NOT NULL UNIQUE
);