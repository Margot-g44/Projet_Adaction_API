CREATE TABLE "associations" (
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "points" INTEGER NOT NULL,
    "image" VARCHAR(255) NOT NULL
);
ALTER TABLE "associations" ADD PRIMARY KEY("id");