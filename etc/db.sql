CREATE TABLE ru_Users
(
  id int Identity (1, 1) primary key NOT NULL,
  email varchar(255) unique,
  password varchar(255),
  fullname varchar(255),
)

CREATE TABLE ru_Users_Follow
(
  user_id int NOT NULL,
  follows_id int NOT NULL,
  FOREIGN KEY (user_id) REFERENCES ru_Users(id),
  FOREIGN KEY (follows_id) REFERENCES ru_Users(id),
  CHECK (user_id <> follows_id),
)

CREATE TABLE ru_Boards
(
  id int Identity (1, 1) primary key NOT NULL,
  boardname varchar(255),
  creator_id int NOT NULL,
  created DATETIME,
  category varchar(255),
  FOREIGN KEY (creator_id) REFERENCES ru_Users(id)
--primary key (boardname, username)
)

CREATE TABLE ru_Pins
(
  id int Identity (1, 1) primary key NOT NULL,
  board_id int NOT NULL,
  creator_id int NOT NULL, -- á ekki að þurfa þar sem borðið bendir á user, tvítaka gögn
  created DATETIME,
  description varchar(1024),
  link varchar(512),
  image varchar(512),
  repin_id int,
  FOREIGN KEY (board_id) REFERENCES ru_Boards(id),
  FOREIGN KEY (creator_id) REFERENCES ru_Users(id),
  FOREIGN KEY (repin_id) REFERENCES ru_Pins(id),
)

CREATE TABLE ru_Users_Pins_like
(
  user_id int NOT NULL,
  pin_id int NOT NULL,
  primary key (user_id, pin_id),
  FOREIGN KEY (user_id) REFERENCES ru_Users(id),
  FOREIGN KEY (pin_id) REFERENCES ru_Pins(id),
)


DROP TABLE ru_users_pins_like
DROP TABLE ru_Pins
DROP TABLE ru_Boards
DROP TABLE ru_Users_Follow
DROP TABLE ru_Users


select * from ru_Users