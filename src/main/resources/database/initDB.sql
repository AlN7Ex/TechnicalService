CREATE TABLE IF NOT EXISTS service.owners
(
    id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(20) NOT NULL ,
    last_name VARCHAR(20) NOT NULL ,
    age int NOT NULL
);

CREATE TABLE IF NOT EXISTS service.cars
(
    id BIGSERIAL PRIMARY KEY ,
    brand VARCHAR(25) NOT NULL ,
    model VARCHAR(25) NOT NULL ,
    owner_id BIGSERIAL REFERENCES service.owners (id) ON DELETE CASCADE
);