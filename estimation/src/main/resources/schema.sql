DROP TABLE IF EXISTS estimation;
CREATE TABLE IF NOT EXISTS  estimation(
task VARCHAR PRIMARY KEY,
tiny INT,
small INT,
medium INT,
large INT,
xlarge INT
);