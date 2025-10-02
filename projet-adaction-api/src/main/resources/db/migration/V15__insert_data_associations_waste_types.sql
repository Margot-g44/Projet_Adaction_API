-- Insert data into the waste_types table
INSERT INTO "waste_types" ("value", "label", "classname") VALUES
('cigarette', '🚬 Mégots de cigarette', 'badge-cigarette'),
('plastic', '🥤 Plastique', 'badge-plastic'),
('glass', '🍶 Verre', 'badge-glass'),
('metal', '🥫 Métal', 'badge-metal'),
('electronic', '📱 Électronique', 'badge-electronic'),
('other', '❓ Autre', 'badge-other');

-- Insert data into the associations tables
INSERT INTO "associations" ("name", "description", "points", "image") VALUES
('Ocean Cleanup', 'Association dédiée au nettoyage des océans et à la protection de la vie marine.', 100, '🌊'),
('Forest Guardians', 'Protection des forêts et reforestation à travers le monde.', 150, '🌳'),
('Wildlife Protectors', 'Protection des espèces menacées et préservation de leur habitat.', 200, '🦁'),
('Clean Air Initiative', 'Lutte contre la pollution de l''air et promotion des énergies propres.', 120, '🌬️');

