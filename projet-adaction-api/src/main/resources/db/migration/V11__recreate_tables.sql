-- Deleting all the previous tables, we need to change the properties of the id
DROP TABLE if EXISTS coordinates CASCADE;
DROP TABLE if EXISTS cities CASCADE;
DROP TABLE if EXISTS waste_types;
DROP TABLE if EXISTS associations;
DROP TABLE if EXISTS coordinates;
DROP TABLE if EXISTS collects;
DROP TABLE if EXISTS volunteers;

CREATE TABLE coordinates (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
lat DOUBLE PRECISION NOT NULL,
lng DOUBLE PRECISION NOT NULL
);

CREATE TABLE cities (
id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
name VARCHAR(255) NOT NULL,
coordinate_id BIGINT REFERENCES coordinates(id)
);

