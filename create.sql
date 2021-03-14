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

CREATE TABLE hairstyles(
 id serial PRIMARY KEY,
 barbershopId INTEGER,
 name VARCHAR
);

CREATE TABLE reviews (
 id serial PRIMARY KEY,
 writtenby VARCHAR,
 content VARCHAR,
 rating INTEGER,
 barbershopId INTEGER
);
CREATE DATABASE barber_test WITH TEMPLATE barber;
