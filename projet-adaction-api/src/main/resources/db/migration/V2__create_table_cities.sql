-- Delete the Table utilisateurs
DROP TABLE if EXISTS utilisateurs;

-- Add a table cities
CREATE TABLE "cities" (
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL
);
ALTER TABLE "cities" ADD PRIMARY KEY("id");