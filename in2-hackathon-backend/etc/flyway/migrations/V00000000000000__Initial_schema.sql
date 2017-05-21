CREATE TABLE user_category (
  categoryName VARCHAR(80) PRIMARY KEY
);

CREATE TABLE users (
  id            SERIAL PRIMARY KEY,
  first_name     VARCHAR(80) NOT NULL,
  last_name      VARCHAR(80) NOT NULL,
  email         VARCHAR(255),
  contact       VARCHAR(80) NOT NULL,
  home_locationX FLOAT,
  home_locationY FLOAT,
  work_locationX FLOAT,
  work_locationY FLOAT,
  available_from TIMESTAMP,
  available_to   TIMESTAMP,
  category      VARCHAR(80),
  CONSTRAINT fk_user_category FOREIGN KEY (category) REFERENCES user_category(categoryName)
);

CREATE TABLE speciality (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE user_speciality (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  speciality_id INTEGER NOT NULL,
  level INTEGER NOT NULL CHECK (level > 0 AND level < 6),
  CONSTRAINT fk_user_speciality FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_speciality_speciality FOREIGN KEY (speciality_id) REFERENCES speciality(id)
);

CREATE TABLE status(
  name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE urgency (
  name VARCHAR(80) PRIMARY KEY
);

CREATE TABLE action_type (
  name VARCHAR(80) PRIMARY KEY
);

CREATE TABLE action (
  id SERIAL PRIMARY KEY,
  heading VARCHAR(255) NOT NULL,
  description TEXT,
  action_locationX FLOAT,
  action_locationY FLOAT,
  base_locationX FLOAT,
  base_locationY FLOAT,
  status VARCHAR(255),
  meeting_time TIMESTAMP,
  action_type VARCHAR(80),
  urgency VARCHAR(80),
  CONSTRAINT fk_status FOREIGN KEY (status) REFERENCES status(name)
);

CREATE TABLE user_action (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  action_id INTEGER NOT NULL,
  response BOOLEAN NOT NULL,
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  CONSTRAINT fk_action_id FOREIGN KEY (action_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE message_type (
  name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE message (
  id SERIAL PRIMARY KEY,
  action_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  message_text TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT current_timestamp,
  message_type VARCHAR(255),
  CONSTRAINT fk_message_message_type FOREIGN KEY (message_type) REFERENCES message_type(name)
);