/*
CREATE TABLE PLAYER (
  ID  INT PRIMARY KEY,
  NAME VARCHAR(100),
);
*/

CREATE TABLE PLAYER (
  ID   INT PRIMARY KEY,
  NAME VARCHAR(100),
  CLUB VARCHAR(100),
  BATTING_AVARAGE VARCHAR(100),
  TYPE VARCHAR(10)

);

/*

CREATE TABLE CRICKETER (
  ID   INT PRIMARY KEY,
  NAME VARCHAR(100),
  BATTING_AVARAGE VARCHAR(100)
);
*/


CREATE TABLE CHARITY_FUNCTION
(
  ID   INT PRIMARY KEY,
  NAME VARCHAR(100)
);


CREATE TABLE PLAYER_CHARITY_FUNCTION
(
  PLAYER_ID INT,
  CHARITY_FUNCTION_ID INT,
  FOREIGN KEY (player_id) REFERENCES player (id),
  FOREIGN KEY (charity_function_id) REFERENCES charity_function (id),
  PRIMARY KEY (player_id, charity_function_id)
);
