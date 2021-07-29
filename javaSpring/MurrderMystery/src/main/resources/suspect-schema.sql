drop table if exists suspect cascade;

create table suspect
(
	id integer PRIMARY KEY AUTO_INCREMENT,
	name varchar(255),
	wepon varchar(255),
	location varchar(255),
	job varchar(255),
	percentage_sus integer
);