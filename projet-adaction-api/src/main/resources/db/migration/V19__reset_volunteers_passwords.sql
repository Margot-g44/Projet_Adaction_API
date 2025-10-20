-- problème de login avec double hash

UPDATE "volunteers" SET "password" = 'test1234' WHERE "password" = '$2a$10$i6nmdjJvvDnIlOGaxTU/L.9EDg1CFev6vxTOFeT7k12J.mwBif0oS';

