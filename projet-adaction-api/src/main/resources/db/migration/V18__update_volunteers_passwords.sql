-- Migration Flyway V18 : Mise à jour des mots de passe des volontaires avec un hash BCrypt

UPDATE "volunteers" SET "password" = '$2a$10$i6nmdjJvvDnIlOGaxTU/L.9EDg1CFev6vxTOFeT7k12J.mwBif0oS' WHERE "password" = 'test1234';
-- Répéter pour chaque mot de passe en clair si besoin (ici tous les mots de passe initiaux sont identiques)

