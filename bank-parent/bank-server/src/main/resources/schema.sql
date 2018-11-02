create schema `bank_database`;

create table bank_database.customer (
id INT PRIMARY KEY AUTO_INCREMENT,
password varchar(20) not null,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
pesel varchar(11) NOT NULL unique,
create_date DATETIME NOT NULL,
email VARCHAR(30) NOT NULL unique,
phone_no varchar(10) NOT NULL,
sex ENUM('M','F'),
date_of_birth date
);

create table bank_database.department (
id INT PRIMARY KEY AUTO_INCREMENT,
dept_name varchar(30) not null,
dept_no int not null,
dept_phone_no varchar(10) not null
);

alter table bank_database.customer add department_id int;
alter table bank_database.customer add constraint fk_customer_dep FOREIGN KEY (department_id) REFERENCES bank_database.department(id);

create table bank_database.worker (
id INT PRIMARY KEY AUTO_INCREMENT,
password varchar(20) not null,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
salary decimal(13,2) not null,
pesel varchar(11) NOT NULL unique,
employment_date date NOT NULL,
email VARCHAR(30) NOT NULL unique,
phone_no varchar(10) NOT NULL,
sex ENUM('M','F'),
date_of_birth date
);

alter table bank_database.worker add department_id int;
alter table bank_database.worker add constraint fk_worker_dep FOREIGN KEY (department_id) REFERENCES bank_database.department(id);

create table bank_database.address (
id INT PRIMARY KEY AUTO_INCREMENT,
street_name varchar(30) NOT NULL ,
zip_code varchar(6) NOT NULL
);

alter table bank_database.worker add address_id int;
alter table bank_database.customer add address_id int;
alter table bank_database.department add address_id int;
alter table bank_database.worker add constraint fk_workers_address FOREIGN KEY (address_id) REFERENCES bank_database.address(id);
alter table bank_database.customer add constraint fk_customers_address FOREIGN KEY (address_id) REFERENCES bank_database.address(id);
alter table bank_database.department add constraint fk_departments_address FOREIGN KEY (address_id) REFERENCES bank_database.address(id);

create table bank_database.account (
id INT PRIMARY KEY AUTO_INCREMENT,
acc_no varchar(26) not null unique,
create_date DATE NOT NULL,
acc_balance decimal(13,2) not null
);

create table bank_database.account_category (
id INT PRIMARY KEY AUTO_INCREMENT,
category_name varchar(40) not null
);

alter table bank_database.account add category_id int;
alter table bank_database.account add constraint fk_account_category foreign key (category_id) references bank_database.account_category(id);

create table bank_database.customer_account (
id INT PRIMARY KEY AUTO_INCREMENT,
);

alter table bank_database.customer_account add customer_id int;
alter table bank_database.customer_account add constraint fk_customer foreign key (customer_id) references bank_database.customer(id);
alter table bank_database.customer_account add account_id int;
alter table bank_database.customer_account add constraint fk_account foreign key (account_id) references bank_database.account(id);

create table bank_database.card (
id INT PRIMARY KEY AUTO_INCREMENT,
card_type ENUM('maestro', 'visa', 'mastercard'),
card_no long not null,
cvc_cvv_code int(3) not null,
activation_date date not null,
expire_date date not null
);

alter table bank_database.card add account_id int;
alter table bank_database.card add constraint fk_account_card foreign key (account_id) references bank_database.account(id);

create table bank_database.account_history (
id INT PRIMARY KEY AUTO_INCREMENT,
balance_bef decimal(13,2) not null,
balance_after decimal(13,2) not null,
);

alter table bank_database.account_history add account_id int;
alter table bank_database.account_history add constraint fk_account_history foreign key (account_id) references bank_database.account(id);

create table bank_database.service (
id INT PRIMARY KEY AUTO_INCREMENT,
service ENUM('deposit', 'loan', 'credit', 'investment', 'payment', 'withdrawal', 'transfer'),
service_recipient_account varchar(26)
);

alter table bank_database.service add account_id int;
alter table bank_database.service add constraint fk_accounts_service foreign key (account_id) references bank_database.account(id);