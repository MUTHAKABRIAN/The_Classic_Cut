--SET MODE PostgreSQL;
--
---- CREATE DATABASE barber
---- \c barber;
--CREATE TABLE IF NOT EXISTS barbershops (
-- id int PRIMARY KEY auto_increment,
-- hairstyleId INTEGER,
-- name VARCHAR,
-- address VARCHAR,
-- phone VARCHAR,
-- website VARCHAR,
-- email VARCHAR
--);
--
--CREATE TABLE IF NOT EXISTS hairstyles (
-- id int PRIMARY KEY auto_increment,
-- barbershopId INTEGER,
-- name VARCHAR
--);
--
--CREATE TABLE IF NOT EXISTS reviews (
-- id int PRIMARY KEY auto_increment,
-- writtenby VARCHAR,
-- content VARCHAR,
-- rating VARCHAR,
-- barbershopId INTEGER
--);
 CREATE DATABASE barber;
 \c barber;
CREATE TABLE barbershops (
 id serial PRIMARY KEY,
 hairstylename VARCHAR,
 name VARCHAR,
 address VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);

CREATE TABLE hairstyles (
 id serial PRIMARY KEY,
 barbershopId INTEGER,
 name VARCHAR
);

CREATE TABLE reviews (
 id serial PRIMARY KEY,
 writtenby VARCHAR,
 content VARCHAR,
 rating VARCHAR,
 barbershopId INTEGER
);
CREATE DATABASE barber_test WITH TEMPLATE barber;
