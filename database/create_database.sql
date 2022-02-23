/******************************************************
*	This script creates the database named toy_database
*******************************************************/

/******************************************************
* To run this script:
*
*	Use "SQL Shell (psql)" or any psql terminal
*
* Use psql command:
*
* \i 'file-location'
*
* example:
* \i 'C:/Users/lukas61695/Desktop/Saved/project-case-study/Database Script/create_database.sql'
*******************************************************/

--terminate any connections to the database which could interfere with deletion
  SELECT pg_terminate_backend(pg_stat_activity.pid)
    FROM pg_stat_activity
    WHERE pg_stat_activity.datname = 'toy_database'
      AND pid <> pg_backend_pid();

--delete database
DROP DATABASE IF EXISTS toy_database;

--create database
CREATE DATABASE toy_database;

--connect to database
\c toy_database

--tables
--Table:role_table
CREATE TABLE role_table (
id SERIAL NOT NULL,
name VARCHAR(32),
PRIMARY KEY (id)
);

--Table:user_table
CREATE TABLE user_table (
id SERIAL NOT NULL,
title VARCHAR(5),
first_name VARCHAR(32),
last_name VARCHAR(32),
password VARCHAR(255), -- 255 char lenght to accomodate space for the hashed password
email VARCHAR(32),
date_of_birth DATE,
address text,
telephone VARCHAR(25),
enabled BOOLEAN,
PRIMARY KEY (id)
);

--Table:user_role_table
CREATE TABLE user_role_table (
user_id INT NOT NULL,
role_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user_table(id),
FOREIGN KEY (role_id) REFERENCES role_table(id)
);


--Table:tag_table
CREATE TABLE tag_table (
id SERIAL NOT NULL,
name VARCHAR(25),
PRIMARY KEY (id)
);


--Table:product_table
CREATE TABLE product_table (
id SERIAL NOT NULL,
name VARCHAR(25),
supplier_name VARCHAR(25),
units_in_stock INT,
total_price FLOAT,
discontinued BOOLEAN,
image_url VARCHAR(255), -- adjusted lenght for long addresses
PRIMARY KEY (id)
);

--Table:discount_table
CREATE TABLE discount_table (
  id SERIAL NOT NULL,
  product_id INT NOT NULL,
  percent FLOAT,
  FOREIGN KEY (product_id) REFERENCES product_table(id)
);

--Table:product_tag_table
CREATE TABLE product_tag_table (
product_id INT NOT NULL,
tag_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES product_table(id),
FOREIGN KEY (tag_id) REFERENCES tag_table(id)
);

--Table:order_table
CREATE TABLE order_table (
id SERIAL NOT NULL,
user_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT,
order_date DATE,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user_table(id),
FOREIGN KEY (product_id) REFERENCES product_table(id)
);

--inserts
--mandatory data
--Insert: Roles(User & Admin)
INSERT INTO role_table(name)
VALUES ('ROLE_USER'),('ROLE_ADMIN');

--Insert: Admin User
INSERT INTO user_table(title, first_name, last_name, password, email, date_of_birth, address, telephone, enabled)
VALUES ('Mr','Admin_FName', 'Admin_LName', 'admin0000', 'admin@toy.com', '2022-02-23', 'Nowhere', '+44000000000', true);

--Insert: Tags
INSERT INTO tag_table(name)
VALUES ('action_hero'),('soft_toy'),('puzzle'),('video_game'),('science'),('age0-6'),('age6-12'),('age12+');

--optional data
--Insert: Sample User
INSERT INTO user_table(title, first_name, last_name, password, email, date_of_birth, address, telephone, enabled)
VALUES ('Mr','Bill', 'Gates', 'gatesloves2dance', 'theRealBillGates@gmail.com', '1955-10-28', '1835 73rd Ave NE, Medina', '(206) 709-3400', true);

--Insert: Sample Products
INSERT INTO product_table(name, supplier_name, units_in_stock, total_price, discontinued, image_url)
VALUES ('Teddy Bear', 'BearCo', 400, 9.99, false, 'https://media.istockphoto.com/photos/small-teddy-bear-isolated-on-white-picture-id182834193'),
       ('Superman', 'Smyths Toys', 250, 5.98, false, 'https://image.smythstoys.com/zoom/185372.jpg'),
       ('Xbox Wireless Controller', 'Smyths Toys', 220, 54.99, false, 'https://image.smythstoys.com/original/desktop/192245.webp');

--Insert: Assign tags to sample products
INSERT INTO product_tag_table(product_id, tag_id)
VALUES (1,2),(1,6),
       (2,1),(2,7),
       (3,4),(3,8);

--Insert: Sample Orders
INSERT INTO order_table(user_id, product_id, quantity, order_date)
VALUES (2, 1, 100, '2022-02-23');


--\c test_database