CREATE TABLE users (
  id       INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  email    VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE user_group (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(255)
);

CREATE TABLE exercise (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description TEXT
);

CREATE TABLE solution (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  created DATETIME,
  updated DATETIME,
  description TEXT,
  exercise_id INT,
  user_id INT,
  FOREIGN KEY (exercise_id) REFERENCES exercise (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);



