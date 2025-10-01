DROP TABLE if EXISTS volunteers CASCADE;
DROP TABLE if EXISTS collects CASCADE;

-- Add a table volunteers
CREATE TABLE "volunteers" (
    "id" BIGINT GENERATED ALWAYS AS IDENTITY,
    "firstname" VARCHAR(255) NOT NULL,
    "lastname" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "location" VARCHAR(255) NOT NULL,
    "created_at" DATE NOT NULL,
    "updated_at" DATE NOT NULL,
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
