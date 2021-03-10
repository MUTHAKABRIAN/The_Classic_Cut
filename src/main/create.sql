SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS barbershops (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS hairstyles (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATE TABLE IF NOT EXISTS reviews (
 id int PRIMARY KEY auto_increment,
 writtenby VARCHAR,
 content VARCHAR,
 rating VARCHAR,
 barbershopid INTEGER
);