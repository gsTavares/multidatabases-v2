create table company(
	id serial not null,
	company_type integer not null,
	
	CONSTRAINT pk_company PRIMARY KEY (id)
)

create table employee (
	id serial not null,
	fullname varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	
	CONSTRAINT pk_employee PRIMARY KEY (id),
)