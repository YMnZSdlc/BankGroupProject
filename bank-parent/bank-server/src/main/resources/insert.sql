insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Corben', 29, 61, 'Sonquil', '92-210');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Farmco', 81, 57, 'Shazi', '65-925');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Larry', 23, 50, 'Mataloko', '20-001');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Veith', 86, 8, 'Voskehask', '41-863');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Arizona', 53, 58, 'Manzanares', '61-022');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Longview', 4, null, 'Baixi', '25-105');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Petterle', 25, null, 'Mao', '11-111');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Pond', 84, null, 'Kure', '78-301');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Shoshone', 94, null, 'Tuanjie', '25-252');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Ridgeview', 4, 25, 'Randegan', '12-212');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Gerald', 73, 1, 'Viengxay', '66-666');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Mcbride', 3128, 990, 'Michałowice', '05-816');
insert into addresses (street_name, street_no, home_no, city, zip_code) values ('Weeping Birch', 60, 49470, 'Bañga', '01-000');

insert into departments (dept_name, dept_no, dept_phone_no, address_id) values ('Pierwszy Oddział', 97, 281609613, 9);
insert into departments (dept_name, dept_no, dept_phone_no, address_id) values ('Oddział Zamknięty', 65, 767263718, 10);
insert into departments (dept_name, dept_no, dept_phone_no, address_id) values ('Oddział Wokjskowy', 50, 483434387, 11);
insert into departments (dept_name, dept_no, dept_phone_no, address_id) values ('Drugi Oddział', 97, 128465153, 12);
insert into departments (dept_name, dept_no, dept_phone_no, address_id) values ('Oddział Psychiatryczny', 26, 862181927, 13);

insert into customers (first_name, last_name, pesel, create_date, email, sex, phone_no, date_of_birth, department_id, address_id)
values('Kamil','Marciniak', 93010105519, sysdate(),'rusek@wp.pl', 'M', 111222333, '1991-03-03', 1, 1);
insert into customers (first_name, last_name, pesel, create_date, email, sex, phone_no, date_of_birth, department_id, address_id)
values('Anastazja','Braterska', 91030303313, sysdate(), 'anaxd@gmail.com', 'F', 578965412, '1992-11-13', 2, 2);
insert into customers (first_name, last_name, pesel, create_date, email, sex, phone_no, date_of_birth, department_id, address_id)
values('Łukasz','Szczybrych', 90050555971, sysdate(), 'lukaszek@wp.pl', 'M', 235698741, '1997-03-03', 3, 2);
insert into customers (first_name, last_name, pesel, create_date, email, sex, phone_no, date_of_birth, department_id, address_id)
values('Karolina','Kamiński', 20355698745, sysdate(), 'kaminski@onet.pl', 'F', 852147963, '1997-11-13', 4, 3);
insert into customers (first_name, last_name, pesel, create_date, email, sex, phone_no, date_of_birth, department_id, address_id)
values('Robert','Lewandowski', 91300110551, sysdate(), 'robert@wp.pl', 'M', 512348963, '1995-01-01', 5, 4);

insert into workers (first_name, last_name, salary, pesel, email, sex, employment_date, phone_no, date_of_birth, department_id, address_id) 
values ('Alidia', 'Mallall', 3000, 93010487519,'amallall0@nsw.gov.au', 'F', '2017-12-09', 111333666, '1997-11-04', 1, 4);
insert into workers (first_name, last_name, salary, pesel, email, sex, employment_date, phone_no, date_of_birth, department_id, address_id) 
values ('Bail', 'Leyborne', 10000, 93010987519,'bleyborne1@usatoday.com', 'M', '2016-09-29', 666333999, '1965-07-15', 2, 5);
insert into workers (first_name, last_name, salary, pesel, email, sex, employment_date, phone_no, date_of_birth, department_id, address_id) 
values ('Jedediah', 'Bridgen', 6000, 93011585519,'jbridgen2@miibeian.gov.cn', 'M', '2017-11-19', 777666555, '1952-01-05', 3, 6);
insert into workers (first_name, last_name, salary, pesel, email, sex, employment_date, phone_no, date_of_birth, department_id, address_id) 
values ('Stephi', 'Hastwell', 5000, 93071105519,'shastwell3@ask.com', 'F', '2015-06-21', 444555666, '1978-01-04', 4, 7);
insert into workers (first_name, last_name, salary, pesel, email, sex, employment_date, phone_no, date_of_birth, department_id, address_id) 
values ('Ava', 'Littrell', 4000, 99120105519,'alittrell4@cafepress.com', 'F', '2014-12-07', 111444777, '1965-11-13', 5, 8);

insert into accounts_category (category_name) values ('Individual');
insert into accounts_category (category_name) values ('Buisness');
insert into accounts_category (category_name) values ('Premium');

insert into accounts (acc_no, create_date, acc_balance, category_id) values ('82111122223333444455556666', sysdate(), 34764.17, 1);
insert into accounts (acc_no, create_date, acc_balance, category_id) values ('47328467777772269322468095', sysdate(), 74475.14, 1);
insert into accounts (acc_no, create_date, acc_balance, category_id) values ('22712300744442727293434511', sysdate(), 41692.88, 2);
insert into accounts (acc_no, create_date, acc_balance, category_id) values ('65770684446666209324087017', sysdate(), 40422.74, 3);
insert into accounts (acc_no, create_date, acc_balance, category_id) values ('11970172666662116862492316', sysdate(), 52996.66, 3);
insert into accounts (acc_no, create_date, acc_balance, category_id) values ('08439675156448725212846682', sysdate(), 12546.66, 1);

insert into customer_accounts (customer_id, account_id) values ( 1, 1);
insert into customer_accounts (customer_id, account_id) values ( 2, 2);
insert into customer_accounts (customer_id, account_id) values ( 1, 3);
insert into customer_accounts (customer_id, account_id) values ( 3, 4);
insert into customer_accounts (customer_id, account_id) values ( 4, 5);
insert into customer_accounts (customer_id, account_id) values ( 5, 6);

insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('mastercard', '5100141104320403', 222, CURDATE(), '2020-01-19', 1);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('maestro', '5893001922497681301', 435, CURDATE(), '2020-04-13', 2);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('visa', '4917943114427722', 138, CURDATE(), '2020-09-08', 1);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('visa', '4041370300592', 955, CURDATE(), '2019-11-29', 2);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('maestro', '67614156101756044', 624, CURDATE(), '2020-09-25', 3);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('visa', '4041370300592', 955, CURDATE(), '2019-11-29', 3);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('maestro', '6762637612534044', 846, CURDATE(), '2020-09-23', 5);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('visa', '4017958898727419', 739, CURDATE(), '2020-08-24', 4);
insert into cards (card_type, card_no, cvc_cvv_code, activation_date, expire_date, account_id) values ('poker', '666666666666666', 739, CURDATE(), '2020-06-26', 5);

insert into services (service, service_no, service_title, service_date, service_amount, service_currency, service_start_time, service_end_time, service_sender_account, service_recipient_account, account_id)
values ('loan', 1, 'Na pizze', sysdate(), 10000, 'PLN', curdate(), '2050-01-01', null, null, 1);
insert into services (service, service_no, service_title, service_date, service_amount, service_currency, service_start_time, service_end_time, service_sender_account, service_recipient_account, account_id)
values ('payment', 4, 'Za zabawe w doktora', sysdate(), 666, 'PLN', null, null, '47328467777772269322468095', '08439675156448725212846682', 2);
insert into services (service, service_no, service_title, service_date, service_amount, service_currency, service_start_time, service_end_time, service_sender_account, service_recipient_account, account_id)
values ('withdrawal', 5, null, sysdate(), 100, 'PLN', null, null, null, null, 3);