-- Create BDD
CREATE DATABASE Prueba;

USE Prueba;

-- create person TABLE
CREATE TABLE person (
	id int IDENTITY(1,1) NOT NULL PRIMARY KEY,		
	age int NOT NULL,
	address varchar(255) NOT NULL,
	gender varchar(255) NOT NULL,
	identification varchar(255) NOT NULL,
	name varchar(255) NOT NULL,
	phone varchar(255) NOT NULL
);

-- create customer TABLE
CREATE TABLE customer (
	id int NOT NULL PRIMARY KEY,
	status bit NOT NULL,
	password varchar(20) NOT NULL,
	FOREIGN KEY (id) REFERENCES person(id) ON DELETE CASCADE
);


-- Tabla de cuentas
CREATE TABLE account (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    number VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    initialBalance DECIMAL(19, 4) NOT NULL,
    status BIT NOT NULL,
    customerId INT NOT NULL,
	FOREIGN KEY (customerId) REFERENCES customer(id) ON DELETE CASCADE
);

-- Tabla de movimientos
CREATE TABLE movement (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    date DATE NOT NULL,
    type VARCHAR(100) NOT NULL,
    amount DECIMAL(19, 4) NOT NULL,
    balance DECIMAL(19, 4) NOT NULL,
    accountId INT NOT NULL,
	FOREIGN KEY (accountId) REFERENCES account(id) ON DELETE CASCADE
);


-- insert persons
-- insert accostumers
-- insert movements