-- Recreate the table volunteers
CREATE TABLE volunteers (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    total_points INTEGER NOT NULL,
    donation_points INTEGER NOT NULL
);

-- Recreate the table collects
CREATE TABLE collects (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    date DATE NOT NULL,
    city_id BIGINT REFERENCES cities(id),
    glass_nb INTEGER NOT NULL,
    butt_nb INTEGER NOT NULL,
    plastic_nb INTEGER NOT NULL,
    electronics_nb INTEGER NOT NULL,
    others_nb INTEGER NOT NULL,
    volunteer_id BIGINT REFERENCES volunteers(id)
);