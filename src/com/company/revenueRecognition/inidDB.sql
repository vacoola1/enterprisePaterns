CREATE TABLE PRODUCT (
  ID  INT PRIMARY KEY,
  NAME VARCHAR(100),
  TYPE VARCHAR(20)
);

CREATE TABLE CONTRACTS (
  ID   INT PRIMARY KEY,
  PROCUCT INT,
  REVENUE DECIMAL,
  DATE_SIGNED DATE
);


CREATE TABLE revenue_recognitions
(
  contract INTEGER NOT NULL,
  amount NUMERIC,
  recognized_on DATE NOT NULL,
  CONSTRAINT revenue_recognitions_recognized_on_contract_pk PRIMARY KEY (recognized_on, contract)
);