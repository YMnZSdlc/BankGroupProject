create schema `bank_database`;

create table customer (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
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

create table department (
id INT NOT NULL auto_increment,
primary key (id),
dept_name varchar(30) not null,
dept_no int not null,
dept_phone_no varchar(10) not null
);

alter table customer add department_id int;
alter table customer add constraint fk_customer_dep FOREIGN KEY (department_id) REFERENCES department(id);


create table worker (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
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
 
 alter table worker add department_id int;
 alter table worker add constraint fk_worker_dep FOREIGN KEY (department_id) REFERENCES department(id);
 
create table address (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
street_name varchar(30) NOT NULL ,
street_no varchar(10) NOT NULL,
home_no varchar(10),
city varchar(30) NOT NULL,
zip_code varchar(6) NOT NULL
);

alter table worker add address_id int;
alter table customer add address_id int;
alter table department add address_id int;
alter table worker add constraint fk_workers_address FOREIGN KEY (address_id) REFERENCES address(id);
alter table customer add constraint fk_customers_address FOREIGN KEY (address_id) REFERENCES address(id);
alter table department add constraint fk_departments_address FOREIGN KEY (address_id) REFERENCES address(id);

 create table account (
 id int not null auto_increment,
 primary key (id),
 acc_no varchar(26) not null unique,
 create_date DATE NOT NULL,
 acc_balance decimal(13,2) not null
 );

 create table account_category (
 id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
category_name varchar(40) not null
);

alter table account add category_id int;
alter table account add constraint fk_account_category foreign key (category_id) references account_category(id);

create table customer_account (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id)
);

alter table customer_account add customer_id int;
alter table customer_account add constraint fk_customer foreign key (customer_id) references customer(id);
alter table customer_account add account_id int;
alter table customer_account add constraint fk_account foreign key (account_id) references account(id);

create table card (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
card_type ENUM('maestro', 'visa', 'mastercard'),
card_no long not null,
cvc_cvv_code int(3) not null,
activation_date date not null,
expire_date date not null
);

alter table card add account_id int;
alter table card add constraint fk_account_card foreign key (account_id) references account(id);

create table account_history (
id INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (id),
balance_bef decimal(13,2) not null,
balance_after decimal(13,2) not null,
service_type enum('deposit', 'loan', 'credit', 'investment', 'payment', 'withdrawal', 'transfer')
);

alter table account_history add account_id int;
alter table account_history add constraint fk_account_history foreign key (account_id) references account(id);


create table service (
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

alter table service add account_id int;
alter table service add constraint fk_accounts_service foreign key (account_id) references account(id);