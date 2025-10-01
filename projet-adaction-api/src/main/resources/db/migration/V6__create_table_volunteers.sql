CREATE TABLE "volunteers" (
    "id" BIGINT NOT NULL,
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