-- TODO: Fix the below statement
INSERT INTO CUSTOMERS (id, title, first_name, middle_name, last_name, dob, create_time)
VALUES (1, 'Mrs', 'Margaret', 'Elaine', 'Heafield', PARSEDATETIME('17/08/1936','dd/MM/yyyy','en'),  PARSEDATETIME('06/04/2020','dd/MM/yyyy','en'));