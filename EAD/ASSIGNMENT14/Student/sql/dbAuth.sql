drop database db;

create database db;
use db;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(200) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
  CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));
  
  INSERT INTO users(username,password,enabled)
VALUES ('yatika','$2a$10$cfTQSrV4kfaMWKPsRcjg/.F1YA4pGLZG95/TVDWO92b3j5vDR1x82', true);
INSERT INTO users(username,password,enabled)
VALUES ('y','$2a$10$0dJiRlVtno7abKXhq0z1oOIFUjzLkXCMf8j12vYhxD3FuEoc.ty9K', true);

INSERT INTO user_roles (username, role)
VALUES ('yatika', 'ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('y', 'USER');
INSERT INTO user_roles (username, role)
VALUES ('yatika', 'USER');

select * from users;

select * from user_roles;
