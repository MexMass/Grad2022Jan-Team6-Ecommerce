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
* \i 'C:/Users/lukas61695/Desktop/Saved/Projects/database-ecommerce-project-graduate-jan-22/create_database.sql'
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
--Table:roles
CREATE TABLE roles (
id SERIAL NOT NULL,
name VARCHAR(32),
PRIMARY KEY (id)
);

--Table:users
CREATE TABLE users (
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

--Table:user_roles
CREATE TABLE user_roles (
user_id INT NOT NULL,
role_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (role_id) REFERENCES roles(id)
);


--Table:tags
CREATE TABLE tags (
id SERIAL NOT NULL,
name VARCHAR(25),
PRIMARY KEY (id)
);


--Table:products
CREATE TABLE products (
id SERIAL NOT NULL,
name VARCHAR(25),
supplier_name VARCHAR(25),
units_in_stock INT,
total_price FLOAT,
discontinued BOOLEAN,
image_url VARCHAR(255), -- adjusted lenght for long addresses
PRIMARY KEY (id)
);

--Table:discounts
CREATE TABLE discounts (
  id SERIAL NOT NULL,
  product_id INT NOT NULL,
  percent FLOAT,
  FOREIGN KEY (product_id) REFERENCES products(id)
);

--Table:product_tags
CREATE TABLE product_tags (
product_id INT NOT NULL,
tag_id INT NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (tag_id) REFERENCES tags(id)
);

--Table:orders
CREATE TABLE orders (
id SERIAL NOT NULL,
user_id INT NOT NULL,
order_date DATE,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

--Table:order_details
CREATE TABLE order_details (
order_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT,
FOREIGN KEY (order_id) REFERENCES orders(id),
FOREIGN KEY (product_id) REFERENCES products(id)
);

--Table:review_table
CREATE TABLE order_table (
id SERIAL NOT NULL,
user_id INT NOT NULL,
product_id INT NOT NULL,
score INT,
description text,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (product_id) REFERENCES products(id)
);

--inserts
--mandatory data
--Insert: Roles(User & Admin)
INSERT INTO roles(name)
VALUES ('ROLE_USER'),('ROLE_ADMIN');

--Insert: Admin User
INSERT INTO users(title, first_name, last_name, password, email, date_of_birth, address, telephone, enabled)
VALUES ('Mr','Admin_FName', 'Admin_LName', 'admin0000', 'admin@toy.com', '2022-02-23', 'Nowhere', '+44000000000', true);--Default values of admin user

--Insert: Tags
INSERT INTO tags(name)
VALUES ('action_hero'),('soft_toy'),('puzzle'),('video_game'),('science'),('age0-6'),('age6-12'),('age12+'); --Add tags to the database

--optional data
--Insert: Sample User
INSERT INTO users(title, first_name, last_name, password, email, date_of_birth, address, telephone, enabled)
VALUES ('Mr','Bill', 'Gates', 'gatesloves2dance', 'theRealBillGates@gmail.com', '1955-10-28', '1835 73rd Ave NE, Medina', '(206) 709-3400', true);

--Insert: Sample Products
INSERT INTO products(name, supplier_name, units_in_stock, total_price, discontinued, image_url)
VALUES ('Teddy Bear', 'BearCo', 400, 9.99, false, 'https://media.istockphoto.com/photos/small-teddy-bear-isolated-on-white-picture-id182834193'),
       ('Superman', 'Smyths Toys', 250, 5.98, false, 'https://image.smythstoys.com/zoom/185372.jpg'),
       ('Xbox Wireless Controller', 'Smyths Toys', 220, 54.99, false, 'https://image.smythstoys.com/original/desktop/192245.webp');

--Insert: Assign tags to sample products
INSERT INTO product_tags(product_id, tag_id)
VALUES (1,2),(1,6), --Add "soft_toy", "age0-6" tags to "Teddy Bear"
       (2,1),(2,7), --Add "action_hero", "age6-12" tags to "Superman"
       (3,4),(3,8); --Add "video_game", "age12+" tags to "Xbox Wireless Controller"

--Insert: Sample Order
INSERT INTO orders(user_id, order_date)
VALUES (2, '2022-02-23'); --Bill Gates makes order on 2022-02-23

--Insert: Sample Order details
INSERT INTO order_details(order_id, product_id, quantity)
VALUES (1, 1, 100),(1, 3, 2); --Add Teddy Bear of 100 quantity & Xbox Wireless Controller of 2 quantity to Bill Gate's order