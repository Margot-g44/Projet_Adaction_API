-- Deleting all the previous tables, we need to change the properties of the id
DROP TABLE if EXISTS coordinates CASCADE;
DROP TABLE if EXISTS cities CASCADE;
DROP TABLE if EXISTS waste_types;
DROP TABLE if EXISTS associations;
DROP TABLE if EXISTS coordinates;
DROP TABLE if EXISTS collects;
DROP TABLE if EXISTS volunteers;

-- Recreating all the tables with the correct property

-- Add a table cities
CREATE TABLE "cities" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "name" VARCHAR(255) NOT NULL
);
ALTER TABLE "cities" ADD PRIMARY KEY("id");

-- Add a table wastes_types
CREATE TABLE "wastes_types" (
"id" BIGINT GENERATED ALWAYS AS IDENTITY,
"value" VARCHAR(255) NOT NULL,
"label" VARCHAR (255) NOT NULL,
"className" VARCHAR (255) NOT NULL
);
ALTER TABLE "wastes_types" ADD PRIMARY KEY("id");

-- Add a table associations
CREATE TABLE "associations" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "name" VARCHAR(255) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "points" INTEGER NOT NULL,
    "image" VARCHAR(255) NOT NULL
);
ALTER TABLE "associations" ADD PRIMARY KEY("id");

-- Add a table coordinates
CREATE TABLE "coordinates" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "lat" FLOAT(53) NOT NULL,
    "lng" FLOAT(53) NOT NULL
);
ALTER TABLE "coordinates" ADD PRIMARY KEY("id");

-- Add a table volunteers
CREATE TABLE "volunteers" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "firstname" VARCHAR(255) NOT NULL,
    "lastname" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "location" VARCHAR(255) NOT NULL,
    "created_at" DATE NOT NULL,
    "updated_ad" DATE NOT NULL,
    "total_points" INTEGER NOT NULL,
    "donation_points" INTEGER NOT NULL
);
ALTER TABLE "volunteers" ADD PRIMARY KEY("id");
ALTER TABLE "volunteers" ADD CONSTRAINT "volunteers_email_unique" UNIQUE("email");

-- Add a table collects
CREATE TABLE "collects" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "date" DATE NOT NULL,
    "city" VARCHAR(255) NOT NULL,
    "glass_nb" INTEGER NOT NULL,
    "butt_nb" INTEGER NOT NULL,
    "plastic_nb" INTEGER NOT NULL,
    "electronics_nb" INTEGER NOT NULL,
    "others_nb" INTEGER NOT NULL,
    "volunteer_id" BIGINT NOT NULL
);
ALTER TABLE "collects" ADD PRIMARY KEY("id");

ALTER TABLE "collects" ADD CONSTRAINT "collects_volunteer_id_foreign" FOREIGN KEY("volunteer_id") REFERENCES "volunteers"("id");
ALTER TABLE "cities" ADD CONSTRAINT "cities_id_foreign" FOREIGN KEY("id") REFERENCES "collects"("id");
ALTER TABLE "coordinates" ADD CONSTRAINT "coordinates_id_foreign" FOREIGN KEY("id") REFERENCES "cities"("id");