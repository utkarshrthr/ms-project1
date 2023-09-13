--DROP TABLE IF EXISTS users_schema.users;
--DROP TABLE IF EXISTS users_schema.roles;
--DROP TABLE IF EXISTS users_schema.user_roles;
-- DROP SCHEMA IF EXISTS users_schema;

CREATE SCHEMA IF NOT EXISTS users_schema;

CREATE TABLE IF NOT EXISTS users_schema.users (
	username        VARCHAR(50)     NOT NULL    PRIMARY KEY,
	first_name      VARCHAR(100)    NOT NULL,
	last_name       VARCHAR(100)    NOT NULL,
	email           VARCHAR(100)    NOT NULL,
	title           VARCHAR(100)    NOT NULL,
	password        VARCHAR(255)    NOT NULL,
    is_active      BOOLEAN         NOT NULL    DEFAULT TRUE,
    created_by      VARCHAR(50)     NOT NULL,
    created_date    TIMESTAMP       NOT NULL    DEFAULT NOW(),
    modified_by     VARCHAR(50)     NOT NULL,
    modified_date   TIMESTAMP       NOT NULL
);

CREATE TABLE IF NOT EXISTS users_schema.roles (
    id              INT             NOT NULL    PRIMARY KEY,
	name            VARCHAR(40)     NOT NULL,
	description     VARCHAR(255)    NOT NULL,
    created_by      VARCHAR(50)     NOT NULL,
    created_date    TIMESTAMP       NOT NULL    DEFAULT NOW(),
    modified_by     VARCHAR(50)     NOT NULL,
    modified_date   TIMESTAMP       NOT NULL
);