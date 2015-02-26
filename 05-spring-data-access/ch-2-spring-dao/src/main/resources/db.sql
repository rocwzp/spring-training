
DROP TABLE IF EXISTS users;

CREATE TABLE users 
(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  dob datetime DEFAULT NULL,
  PRIMARY KEY (id)
);

insert into users(id,name,email,password,dob) values(1,'Administrator','admin@gmail.com','admin',NULL);
insert into users(id,name,email,password,dob) values(2,'Test','test@gmail.com','test',NULL);
