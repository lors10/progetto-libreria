CREATE TABLE books (

	id INT auto_increment primary key,
    title varchar(100) not null,
    author varchar(100) not null,
    available boolean default true
);