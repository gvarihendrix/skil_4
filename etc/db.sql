CREATE TABLE ru_Users
(
  id int Identity (1, 1) primary key NOT NULL,
  email varchar(255) unique,
  password varchar(255),
  fullname varchar(255),
)

CREATE TABLE ru_Users_Follow
(
  useremail varchar(255) NOT NULL,
  follows varchar(255) NOT NULL,
  primary key (useremail, follows),
  FOREIGN KEY (useremail) REFERENCES ru_Users(email),
  FOREIGN KEY (follows) REFERENCES ru_Users(email),
  CHECK (useremail <> follows),
)

CREATE TABLE ru_Boards
(
  id int Identity (1, 1) primary key NOT NULL,
  name varchar(255),
  creator varchar(255) NOT NULL,
  created DATETIME,
  category varchar(255),
  FOREIGN KEY (creator) REFERENCES ru_Users(email)
)

CREATE TABLE ru_Pins
(
  id int Identity (1, 1) primary key NOT NULL,
  board_id int NOT NULL,
  creator varchar(255) NOT NULL, 
  created DATETIME,
  description varchar(1024),
  link varchar(512),
  image varchar(512),
  repin_id int,
  FOREIGN KEY (board_id) REFERENCES ru_Boards(id),
  FOREIGN KEY (creator) REFERENCES ru_Users(email),
  FOREIGN KEY (repin_id) REFERENCES ru_Pins(id),
)

CREATE TABLE ru_Users_Pins_like
(
  useremail varchar(255) NOT NULL,
  pin_id int NOT NULL,
  primary key (useremail, pin_id),
  FOREIGN KEY (useremail) REFERENCES ru_Users(email),
  FOREIGN KEY (pin_id) REFERENCES ru_Pins(id)
)


DROP TABLE ru_users_pins_like
DROP TABLE ru_Pins
DROP TABLE ru_Boards
DROP TABLE ru_Users_Follow
DROP TABLE ru_Users