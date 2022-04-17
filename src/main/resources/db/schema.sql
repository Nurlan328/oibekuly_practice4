-- CREATE TABLE IF NOT EXISTS Attachment (
--     id VARCHAR(60),
--     fileName VARCHAR(60),
--     fileType VARCHAR(60),
--     data bytea
--
-- );

CREATE TABLE IF NOT EXISTS bank (
   bank_id int  not null ,
   bankname VARCHAR(60),
    customer_account_number bigserial,
    primary key (bank_id)
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id integer not null,
    firstname VARCHAR(60),
    lastname VARCHAR(60),
    age integer,
    address VARCHAR(60),
    iin varchar(60),
    isRegistered bool,
    dateOfBirth DATE,
    primary key (customer_id)
);

CREATE TABLE IF NOT EXISTS account (
   account_id integer,
   accountnumber bigserial,
   balance double precision,
   interest double precision,
   PRIMARY KEY (account_id)
);

-- select * from account;
-- select * from bank;
-- select * from customers;
-- select * from Attachment;
--
-- drop table customers;
-- drop table account;
-- drop table bank;
-- drop table Attachment;

