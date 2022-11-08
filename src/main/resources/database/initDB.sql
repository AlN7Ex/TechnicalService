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

CREATE TABLE IF NOT EXISTS service.roles
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(40) NOT NULL
);

-- CREATE TABLE IF NOT EXISTS service.users_roles
-- (
--     user_id BIGSERIAL REFERENCES service.users (id) ON DELETE CASCADE,
--     role_id BIGSERIAL REFERENCES service.roles (id) ON DELETE CASCADE,
--     PRIMARY KEY (user_id, role_id)
-- );

-- alter table if exists service.users_roles
--     add constraint fk_role_id
--         foreign key (role_id)
--             references service.roles;
--
-- alter table if exists service.users_roles
--     add constraint fk_user_id
--         foreign key (user_id)
--             references service.users

CREATE TABLE IF NOT EXISTS service.users_roles
(
    user_id BIGSERIAL,
    role_id BIGSERIAL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES service.users (id),
    CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES service.roles (id)
)

-- alter table if exists service.users
--     add constraint UK_ow0gan20590jrb00upg3va2fn
--         unique (login)
-- alter table if exists service.cars
--     add constraint FKhcsx2hgskre1qwetp67r7qfr
--         foreign key (owner_id) references service.owners
-- alter table if exists service.users_roles
--     add constraint FKj6m8fwv7oqv74fcehir1a9ffy
--         foreign key (role_id) references service.roles
-- alter table if exists service.users_roles
--     add constraint FK2o0jvgh89lemvvo17cbqvdxaa
--         foreign key (user_id) references service.users