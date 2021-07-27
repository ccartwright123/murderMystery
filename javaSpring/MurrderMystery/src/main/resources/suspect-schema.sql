drop table if exists suspects cascade;

create table suspects
(
	id integer PRIMARY KEY AUTO_INCREMENT,
	name varchar(255),
	wepon varchar(255),
	location varchar(255),
	job varchar(255),
	percentageSus varchar(255)
);