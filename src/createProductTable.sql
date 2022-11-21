create database if not exists Product;

use Product;

DROP TABLE product;

create table product (
    id             Integer,
    product_name    varchar(30) not null,
    create_time     timestamp,
    primary key (id)
);
