CREATE SCHEMA blog;

CREATE TABLE "blog"."user" (
    "id" SERIAL PRIMARY KEY,
    "name" VARCHAR(64) NOT NULL,
    "surname" VARCHAR(64) NOT NULL,
    "email" VARCHAR(64) NOT NULL,
    "created" timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
) WITH (oids = false);

