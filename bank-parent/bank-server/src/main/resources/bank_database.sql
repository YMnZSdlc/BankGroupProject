create database `bank_database` default charset utf8 collate utf8_polish_ci;
use bank_database;

create table customers (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(30) NOT NULL,
 pesel bigint(11) NOT NULL unique,
 create_date DATETIME NOT NULL,
 email VARCHAR(30) NOT NULL unique,
 phone_no INT(10) NOT NULL,
 sex ENUM('M','F'),
 date_of_birth date
);

create table departments (
id INT NOT NULL auto_increment,
primary key (id),
dept_name varchar(30) not null,
dept_no int not null,
dept_phone_no INT(10) not null
);

alter table customers add department_id int;
alter table customers add constraint fk_customers_dep FOREIGN KEY (department_id) REFERENCES departments(id);


create table workers (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
 first_name VARCHAR(30) NOT NULL,
 last_name VARCHAR(30) NOT NULL,
 salary decimal(13,2) not null,
 pesel bigint(11) NOT NULL unique,
 employment_date date NOT NULL,
 email VARCHAR(30) NOT NULL unique,
 phone_no INT(10) NOT NULL,
 sex ENUM('M','F'),
 date_of_birth date
 );
 
 alter table workers add department_id int;
 alter table workers add constraint fk_worker_dep FOREIGN KEY (department_id) REFERENCES departments(id);
 
create table addresses (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
street_name varchar(30) NOT NULL ,
street_no varchar(10) NOT NULL,
home_no varchar(10),
city varchar(30) NOT NULL,
zip_code varchar(6) NOT NULL
);

alter table workers add address_id int;
alter table customers add address_id int;
alter table departments add address_id int;
alter table workers add constraint fk_workers_addresses FOREIGN KEY (address_id) REFERENCES addresses(id);
alter table customers add constraint fk_customers_addresses FOREIGN KEY (address_id) REFERENCES addresses(id);
alter table departments add constraint fk_departments_addresses FOREIGN KEY (address_id) REFERENCES addresses(id);

 create table accounts (
 id int not null auto_increment,
 primary key (id),
 acc_no varchar(26) not null unique,
 create_date DATETIME NOT NULL,
 acc_balance decimal(13,2) not null
 );

 create table accounts_category (
 id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
category_name varchar(40) not null
);

alter table accounts add category_id int;
alter table accounts add constraint fk_accounts_category foreign key (category_id) references accounts_category(id);

create table customer_accounts (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id)
);

alter table customer_accounts add customer_id int;
alter table customer_accounts add constraint fk_customer foreign key (customer_id) references customers(id);
alter table customer_accounts add account_id int;
alter table customer_accounts add constraint fk_account foreign key (account_id) references accounts(id);

create table cards (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
card_type ENUM('maestro', 'visa', 'mastercard', 'poker'),
card_no bigint not null,
cvc_cvv_code int(3) not null,
activation_date date not null,
expire_date date not null
);

alter table cards add account_id int;
alter table cards add constraint fk_accounts_card foreign key (account_id) references accounts(id);

create table account_history (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
balance_bef decimal(13,2) not null,
balance_after decimal(13,2) not null,
service_type enum('deposit', 'loan', 'credit', 'investment', 'payment', 'withdrawal', 'transfer')
);

alter table account_history add account_id int;
alter table account_history add constraint fk_account_history foreign key (account_id) references accounts(id);


create table services (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
service ENUM('deposit', 'loan', 'credit', 'investment', 'payment', 'withdrawal', 'transfer'),
service_no int not null,
service_title varchar(30),
service_date datetime not null,
service_amount decimal(13,2) not null,
service_currency varchar(3) not null,
service_start_time date,
service_end_time date,
service_sender_account varchar(26),
service_recipient_account varchar(26)
);

alter table services add account_id int;
alter table services add constraint fk_accounts_services foreign key (account_id) references accounts(id);