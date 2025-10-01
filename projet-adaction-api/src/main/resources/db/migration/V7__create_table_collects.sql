CREATE TABLE "collects" (
    "id" BIGINT NOT NULL,
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