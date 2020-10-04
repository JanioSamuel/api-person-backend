CREATE TABLE IF NOT EXISTS admins (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  user_password VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS persons (
  id INT AUTO_INCREMENT PRIMARY KEY,
  person_name VARCHAR(250) NOT NULL,
  gender VARCHAR(1),
  email VARCHAR(250),
  birth_date DATE NOT NULL,
  place_birth VARCHAR(20),
  citizienship VARCHAR(20),
  taxpayer_id VARCHAR(20) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL
);

INSERT INTO admins (username, user_password) VALUES ('janio', '123');