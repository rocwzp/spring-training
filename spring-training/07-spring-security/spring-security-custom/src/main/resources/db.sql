create table users
(
username varchar(50) not null primary key,
password varchar(50) not null,
enabled boolean not null
);

create table authorities 
(
username varchar(50) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);

insert into users (username,password,enabled) values ('admin','admin123',1);
insert into users (username,password,enabled) values ('test','test123',1);

insert into authorities(username,authority) values ('admin','ROLE_USER');
insert into authorities(username,authority) values ('admin','ROLE_ADMIN');
insert into authorities(username,authority) values ('test','ROLE_USER');



CREATE TABLE sec_users (
  id int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  disabled tinyint(1) DEFAULT NULL
);

INSERT INTO sec_users (id,email,password,disabled) VALUES (1,'admin@gmail.com','admin',0);
INSERT INTO sec_users (id,email,password,disabled) VALUES (2,'test@gmail.com','test',0);


CREATE TABLE sec_roles (
  id int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id int(10) unsigned NOT NULL,
  role varchar(45) NOT NULL,
  KEY FK_sec_roles_1 (user_id),
  CONSTRAINT FK_sec_roles_1 FOREIGN KEY (user_id) REFERENCES sec_users (id)
);


INSERT INTO sec_roles (id,user_id,role) VALUES 
 (1,1,'ROLE_USER'),
 (2,1,'ROLE_ADMIN'),
 (2,2,'ROLE_USER')
 ;

