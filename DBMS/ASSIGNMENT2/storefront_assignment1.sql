CREATE DATABASE storefrontdb;

USE storefrontdb;

CREATE TABLE product(
id int not null PRIMARY KEY,
name varchar(50) not null,
price float not null,
quantity int not null,
is_active bool default true,
description varchar(200)
);

DROP TABLE product;

CREATE TABLE product(
id int not null PRIMARY KEY,
name varchar(50) not null,
price float not null,
quantity int not null,
is_active bool default true,
added_on_date DATE not null,
product_image BLOB);


CREATE TABLE category(
id int not null PRIMARY KEY,
name varchar(50) not null,
root int
);

CREATE TABLE sub_category(
productId int not null,
categoryId int not null,
primary key(productId, categoryId),
foreign key(productId) references product(id),
foreign key(categoryId) references category(id)
);

CREATE TABLE user(
id int not null,
name varchar(50) not null,
password varchar(20) not null,
email varchar(50) not null,
primary key(id, email),
is_admin bool default false
);

CREATE TABLE address(
userId int not null,
addressId int not null,
housenum varchar(20) not null,
street varchar(50) not null,
city varchar(50) not null,
state varchar(50) not null,
country varchar(50) default 'INDIA',
pincode int not null,
primary key(addressId),
foreign key(userId) references user(id)
);

CREATE TABLE orders(
orderId int not null,
userId int not null,
order_placing_date Date not null,
bill float not null,
primary key(orderId),
foreign key(userId) references user(id)
);

CREATE TABLE order_product(
orderId int not null,
productId int not null,
shipping_add_id int not null,
order_quantity int not null,
orderStatus varchar(20) not null,
primary key(orderId, productId),
foreign key(orderId) references Orders(orderId),
foreign key(productId) references Product(id),
foreign key(shipping_add_id) references address(addressId)
);

show tables;
