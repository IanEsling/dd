CREATE DATABASE dd;

\c dd;

CREATE TABLE mps (
id varchar(100) not null,
fullname varchar(250) not null,
party varchar(50) not null,
gender varchar(20) not null,
given_name varchar(100) not null,
family_name varchar(100) not null,
additional_name varchar(100),
constituency varchar(250) not null,
twitter varchar(250),
homepage varchar(250));

CREATE TABLE mpsj(mp_id varchar(10), mp json);

CREATE TABLE ayesj(mp_id varchar(10), aye json);

CREATE TABLE noesj(mp_id varchar(10), no json);
