-- Delete the Table utilisateur
DROP TABLE if EXISTS utilisateur;

CREATE TABLE "waste_types" (
"id" BIGINT NOT NULL,
"value" VARCHAR(255) NOT NULL,
"label" VARCHAR (255) NOT NULL,
"className" VARCHAR (255) NOT NULL
);
ALTER TABLE "waste_types" ADD PRIMARY KEY("id");