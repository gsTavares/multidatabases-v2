create table company(
	id serial not null,
	name varchar(255) not null,
	company_type integer not null,
	
	CONSTRAINT pk_company PRIMARY KEY (id)
)

create table database_credential(
	id serial not null,
	id_company integer not null,
	url varchar(255) not null,
	username varchar(255) not null,
	password varchar(255) not null,
	
	CONSTRAINT pk_databse_credential PRIMARY KEY (id),
	CONSTRAINT fk_company FOREIGN KEY (id_company) REFERENCES company(id)
)