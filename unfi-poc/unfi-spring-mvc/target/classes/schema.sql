-- schema.sql
DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
  id NUMERIC IDENTITY PRIMARY KEY,
  name VARCHAR(512) NOT NULL,
  email VARCHAR(512) NOT NULL,
  address VARCHAR(512) NOT NULL
);
