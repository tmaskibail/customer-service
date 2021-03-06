DROP TABLE IF EXISTS CUSTOMERS;

CREATE TABLE CUSTOMERS (
    id INT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    middle_name VARCHAR(250)  NULL,
    last_name VARCHAR(250) NOT NULL,
    dob DATE DEFAULT NULL,
    create_time DATE NOT NULL
);