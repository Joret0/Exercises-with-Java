#Problem 1

CREATE DATABASE minions

#Problem 2

CREATE TABLE minions
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT NOT NULL);

CREATE TABLE towns
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL);

#Problem 3

ALTER TABLE minions
  ADD COLUMN `town_id` INT,
ADD CONSTRAINT fk_minions_towns FOREIGN KEY(town_id)
  REFERENCES towns(id);

#Problem 4

INSERT INTO towns(`id`, `name`)
VALUES (1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO minions(`id`, `name`, `age`, `town_id`)
VALUES (1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

#Problem 5

TRUNCATE TABLE minions

#Problem 6

DROP TABLE minions;
DROP TABLE towns;

#Problem 7

CREATE TABLE people
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(10,2),
`weight` DOUBLE(10,2),
`gender` ENUM('m','f') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` LONGTEXT);

 INSERT INTO people(`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`)
 VALUES
 ('Georgi', NULL, 2.22, 7.77, 'm', CURDATE(), 'Some text'),
 ('Aneta', NULL, 3.33, 8.88, 'f', CURDATE(), 'Some text'),
 ('Ivan', NULL, 4.44, 9.99, 'm', CURDATE(), 'Some text'),
 ('Angel', NULL, 5.55, 10.01, 'm', CURDATE(), 'Some text'),
 ('Nasko', NULL, 6.66, 11.02, 'm', CURDATE(), 'Some text'); 

#Problem 8

CREATE TABLE users
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATE,
`is_deleted` TINYINT(1));

 INSERT INTO users(`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`)
 VALUES
 ('Georgi', 'password', NULL, CURDATE(), 0),
 ('Aneta', 'password', NULL, CURDATE(), 1),
 ('Ivan', 'password', NULL, CURDATE(), 1),
 ('Angel', 'password', NULL, CURDATE(), 0),
 ('Nasko', 'password', NULL, CURDATE(), 1);
 
#Problem 9

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (`id`, `username`);

#Problem 10

ALTER TABLE users
MODIFY `last_login_time` DATETIME DEFAULT CURRENT_TIMESTAMP;

#Problem 11

ALTER TABLE users
DROP PRIMARY KEY,
ADD PRIMARY KEY(`id`),
ADD UNIQUE(`username`);

#Problem 12

CREATE TABLE directors
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

CREATE TABLE genres
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

CREATE TABLE categories
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT);

CREATE TABLE movies
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` DATE NOT NULL,
`length` FLOAT NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` DOUBLE,
`notes` TEXT);

ALTER TABLE movies
ADD CONSTRAINT fk_movies_directors FOREIGN KEY(director_id) REFERENCES `directors`(id),
ADD CONSTRAINT fk_movies_genres FOREIGN KEY(genre_id) REFERENCES `genres`(id),
ADD CONSTRAINT fk_movies_categories FOREIGN KEY(category_id) REFERENCES `categories`(id);

INSERT INTO directors(`director_name`, `notes`)
VALUES ('Georgi', 'Some text'),
('Ivan', 'Some text'),
('Aneta', 'Some text'),
('Daniela', 'Some text'),
('Petar', 'Some text');

INSERT INTO categories(`category_name`, `notes`)
VALUES ('Crimi', 'Some text'),
('Adventure', 'Some text'),
('Comedy', 'Some text'),
('Action', 'Some text'),
('Drama', 'Some text');

INSERT INTO genres(`genre_name`, `notes`)
VALUES ('Crimi', 'Some text'),
('Adventure', 'Some text'),
('Comedy', 'Some text'),
('Action', 'Some text'),
('Drama', 'Some text');

INSERT INTO movies(`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`, `notes`)
VALUES('Movie 1', 1, CURDATE(), 2.22, 2, 3, 10, 'Some text'),
('Movie 2', 2, CURDATE(), 3.32, 1, 2, 9, 'Some text'),
('Movie 3', 3, CURDATE(), 4.52, 5, 1, 8, 'Some text'),
('Movie 4', 4, CURDATE(), 6.72, 4, 5, 7, 'Some text'),
('Movie 1', 5, CURDATE(), 9.22, 3, 4, 6, 'Some text');

#Problem 13

CREATE TABLE categories
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(50) NOT NULL,
`daily_rate` DOUBLE(8,2) NOT NULL,
`weekly_rate` DOUBLE(8,2) NOT NULL,
`monthly_rate` DOUBLE(8,2) NOT NULL,
`weekend_rate` DOUBLE(8,2) NOT NULL);

CREATE TABLE cars
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(50) NOT NULL,
`make` VARCHAR(50) NOT NULL,
`model` VARCHAR(50) NOT NULL,
`car_year` DATE NOT NULL,
`category_id` INT NOT NULL,
`doors` INT NOT NULL,
`picture` BLOB,
`car_condition` TEXT,
`available` TINYINT(1) NOT NULL);

CREATE TABLE employees
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`title` VARCHAR(50),
`notes` TEXT);

CREATE TABLE customers
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(50) NOT NULL,
`full_name` VARCHAR(50) NOT NULL,
`address` TEXT NOT NULL,
`city` VARCHAR(50) NOT NULL,
`zip_code` INT NOT NULL,
`notes` TEXT);

CREATE TABLE rental_orders
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` TEXT NOT NULL,
`tank_level` VARCHAR(50) NOT NULL,
`kilometrage_start` INT NOT NULL,
`kilometrage_end` INT NOT NULL,
CONSTRAINT chk_kilometers CHECK (`kilometrage_start` <= `kilometrage_end`),
`total_kilometrage` INT NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
CONSTRAINT chk_date CHECK (`start_date` <= `end_date`),
`total_days` INT NOT NULL,
`rate_applied` DOUBLE(8,2) NOT NULL,
`tax_rate` DOUBLE(8,2) NOT NULL,
`order_status` VARCHAR(50) NOT NULL,
`notes` TEXT);

ALTER TABLE rental_orders
ADD CONSTRAINT fk_rental_orders_employees FOREIGN KEY(employee_id) REFERENCES `employees`(id),
ADD CONSTRAINT fk_rental_orders_customers FOREIGN KEY(customer_id) REFERENCES `customers`(id),
ADD CONSTRAINT fk_rental_orders_cars FOREIGN KEY(car_id) REFERENCES `cars`(id);
ALTER TABLE cars
ADD CONSTRAINT fk_categories_cars FOREIGN KEY(category_id) REFERENCES `categories`(id);

INSERT INTO categories (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
VALUES('Crimi', 2.44, 3.55, 5.33, 10.22),
('Adventure', 5.44, 2.55, 8.33, 11.22),
('Action', 8.44, 13.55, 25.33, 13.22);

INSERT INTO cars (`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`, `picture`, `car_condition`, `available`)
VALUES('Some Number', 'Some text', 'BMW', '2009-05-12', 1, 4, NULL, 'Some text', 1),
('Some Number', 'Some text', 'Mercedes', '2008-06-10', 2, 3, NULL, 'Some text', 1),
('Some Number', 'Some text', 'VW', '2007-01-08', 3, 5, NULL, 'Some text', 0);

INSERT INTO employees (`first_name`, `last_name`, `title`, `notes`)
VALUES('Georgi', 'Stalev', 'seller', 'Some text'),
('Ivan', 'Stalev', 'customer suport', 'Some text'),
('Aneta', 'Moleva', 'human resurces', 'Some text');

INSERT INTO customers (`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`, `notes`)
VALUES('Some Number', 'Vladislav Boichev', 'Some address', 'Some city', 123, 'Some text'),
('Some Number', 'Dimitar Vasilev', 'Some address', 'Some city', 345, 'Some text'),
('Some Number', 'Yanislav Marinov', 'Some address', 'Some city', 1000, 'Some text');

INSERT INTO rental_orders (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`, `total_kilometrage`, `start_date`, `end_date`, `total_days`, `rate_applied`, `tax_rate`, `order_status`, `notes`)
VALUES(1, 1, 1, 'Some text', 'EMPTY', 10, 200, 250, '2016-05-05', '2017-05-05', 25, 24.45, 25.44, 'Available', 'Some text'),
(2, 2, 2, 'Some text', 'EMPTY', 5, 150, 200, '2014-05-05', '2015-05-05', 45, 55.22, 33.33, 'Available', 'Some text'),
(3, 3, 3, 'Some text', 'EMPTY', 20, 100, 150, '2015-05-05', '2016-05-05', 26, 27.49, 21.42, 'Available', 'Some text');

# Problem 14
 
CREATE TABLE employees
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`title` VARCHAR(50) NOT NULL,
`notes` TEXT);

CREATE TABLE customers
(`account_number` VARCHAR(50) NOT NULL PRIMARY KEY,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`phone_number` VARCHAR(50) NOT NULL,
`emergency_name` VARCHAR(50) NOT NULL,
`emergency_number` VARCHAR(50) NOT NULL,
`notes` TEXT);

CREATE TABLE room_status
(`room_status` VARCHAR(50) NOT NULL PRIMARY KEY,
`notes` TEXT);

CREATE TABLE room_types
(`room_type` VARCHAR(50) NOT NULL PRIMARY KEY,
`notes` TEXT);

CREATE TABLE bed_types
(`bed_type` VARCHAR(50) NOT NULL PRIMARY KEY,
`notes` TEXT);

CREATE TABLE rooms
(`room_number` INT NOT NULL PRIMARY KEY,
`room_type` VARCHAR(50) NOT NULL,
`bed_type` VARCHAR(50) NOT NULL,
`rate` INT NOT NULL,
`room_status` ENUM('AVAILABLE','NOT AVAILABLE') NOT NULL,
`notes` TEXT);

CREATE TABLE payments
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`payment_date` DATE NOT NULL,
`account_number` VARCHAR(50) NOT NULL,
`first_date_occupied` DATE NOT NULL,
`last_date_occupied` DATE NOT NULL,
CONSTRAINT chk_date CHECK (`first_date_occupied` <= `last_date_occupied`),
`total_days` INT NOT NULL,
`amount_charged` FLOAT NOT NULL,
`tax_rate` FLOAT NOT NULL,
`tax_amount` FLOAT NOT NULL,
`payment_total` FLOAT NOT NULL,
`notes` TEXT);

CREATE TABLE occupancies
(`id` INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`date_occupied` DATE NOT NULL,
`account_number` VARCHAR(50) NOT NULL,
`room_number` INT NOT NULL,
`rate_applied` INT NOT NULL,
`phone_charge` FLOAT NOT NULL,
`notes` TEXT);

INSERT INTO employees (`first_name`, `last_name`, `title`, `notes`)
VALUES ('Georgi', 'Stalev', 'Customer Suport', 'Some Text'),
('Aneta', 'Moleva', 'Key Account', 'Some Text'),
('Ivan', 'Stalev', 'Desk Operational', 'Some Text');

INSERT INTO customers (`account_number`, `first_name`, `last_name`, `phone_number`, `emergency_name`, `emergency_number`, `notes`)
VALUES ('BG01UTFFF1050204020', 'Georgi', 'Stalev', '0888443322', 'Petar Ivanov', '0888229944', 'Some Text'),
('BG01UTFFF1154254629', 'Aneta', 'Moleva', '0887456222', 'Bogomil Malinov', '0887224444', 'Some Text'),
('BG01UTFFF7734346723', 'Ivan', 'Stalev', '0886835476', 'Dilian Dimov', '0888749253', 'Some Text');

INSERT INTO room_status (`room_status`, `notes`)
VALUES ('goood', 'Some Text'),
('bad', 'Some Text'),
('silver', 'Some Text');

INSERT INTO room_types (`room_type`, `notes`)
VALUES ('Double Room', 'Some Text'),
('Triple Room', 'Some Text'),
('Single Room', 'Some Text');

INSERT INTO bed_types (`bed_type`, `notes`)
VALUES ('Double Bed', 'Some Text'),
('Single Bed', 'Some Text'),
('Triple Bed', 'Some Text');

INSERT INTO rooms (`room_number`, `room_type`, `bed_type`, `rate`, `room_status`, `notes`)
VALUES (22, 'Double Room', 'Single Bed', 10, 'AVAILABLE', 'Some Text'),
(25, 'Double Room', 'Double Bed', 10, 'NOT AVAILABLE', 'Some Text'),
(28, 'Single Room', 'Single Bed', 10, 'AVAILABLE', 'Some Text');

INSERT INTO payments (`employee_id`, `payment_date`, `account_number`, `first_date_occupied`, `last_date_occupied`, `total_days`, `amount_charged`, `tax_rate`, `tax_amount`, `payment_total`, `notes`)
VALUES (1, '2017-02-27', 'BG01UTFFF1050204020', '2017-02-27', '2017-03-15', 18, 100.56, 15.05, 10.56, 119.56, 'Some Text'),
(1, '2017-02-27', 'BG01UTFFF1154254629', '2017-02-27', '2017-03-15', 15, 116.22, 13.19, 11.76, 133.16, 'Some Text'),
(1, '2017-02-27', 'BG01UTFFF7734346723', '2017-01-22', '2017-02-11', 20, 110.73, 16.05, 14.56, 122.56, 'Some Text');

INSERT INTO occupancies (`employee_id`, `date_occupied`, `account_number`, `room_number`, `rate_applied`, `phone_charge`, `notes`)
VALUES (1, '2017-03-15', 'BG01UTFFF1050204020', 23, 10, 2.25, 'Some Text'),
(2, '2017-03-15', 'BG01UTFFF1154254629', 25, 10, 2.25, 'Some Text'),
(3, '2017-02-11', 'BG01UTFFF7734346723', 28, 10, 2.25, 'Some Text');

#Problem 15

CREATE TABLE towns
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL);

CREATE TABLE addresses
(`id`INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`address_text` TEXT NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns FOREIGN KEY(`town_id`) REFERENCES `towns`(`id`));

CREATE TABLE departments
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL);

CREATE TABLE employees
(`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`job_title` VARCHAR(50) NOT NULL,
`department_id` INT NOT NULL,
CONSTRAINT fk_employees_departments FOREIGN KEY(`department_id`) REFERENCES `departments`(`id`),
`hire_date` DATE NOT NULL,
`salary` FLOAT NOT NULL,
`address_id` INT NOT NULL,
CONSTRAINT fk_employees_addresses FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`));

#Problem 19

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

#Problem 20

SELECT * FROM towns
  ORDER BY name;
SELECT * FROM departments
  ORDER BY name;
SELECT * FROM employees
  ORDER BY salary DESC;

#Problem 21

SELECT name FROM towns
  ORDER BY name;
SELECT name FROM departments
  ORDER BY name;
SELECT first_name,last_name,job_title,salary FROM employees
  ORDER BY salary DESC;
  
#Problem 22

UPDATE employees
 SET salary = salary * 1.10;

SELECT salary FROM employees;

#Problem 23

UPDATE payments
  SET tax_rate = tax_rate * 0.97;

Select tax_rate from payments;

#Problem 24

DELETE FROM occupancies;
