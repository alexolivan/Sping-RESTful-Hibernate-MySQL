# DATABASE AND USER INITIALIZATION
# RUN THIS AS SUPERUSER/ROOT USER

DROP DATABASE example_db;
CREATE DATABASE example_db;

CREATE USER 'exampleuser'@'localhost' IDENTIFIED BY 'examplepass';
GRANT USAGE ON *.* TO 'exampleuser'@'localhost';
GRANT ALL PRIVILEGES ON example_db.* TO 'exampleuser'@'localhost';
FLUSH PRIVILEGES;


# SWITCH TO DB 
# OR LOGIN INTO DB AS USER CREATED USER

USE example_db;

# CREATE SCHEMA STRUCTURE

DROP TABLE IF EXISTS roles;
CREATE TABLE roles(
roleID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
roleDesc VARCHAR(25) NOT NULL,
roleStr VARCHAR(25) NOT NULL UNIQUE
);

INSERT INTO roles (roleStr, roleDesc) VALUES ('ROLE_SUPER', 'Superadmin');
INSERT INTO roles (roleStr, roleDesc) VALUES ('ROLE_ADMIN', 'Administrator');
INSERT INTO roles (roleStr, roleDesc) VALUES ('ROLE_USER', 'Normal user');
INSERT INTO roles (roleStr, roleDesc) VALUES ('ROLE_GUEST', 'Guest user');


DROP TABLE IF EXISTS users;
CREATE TABLE users(
userID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
username VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(50) NOT NULL,
fullname VARCHAR(100) NOT NULL,
roleID INT NOT NULL,
CONSTRAINT FK_UserRole FOREIGN KEY (roleID) REFERENCES roles(roleID) 
);


INSERT INTO users (username, password, fullname, roleID) VALUES ('root', 'root', 'Super User', 1);
INSERT INTO users (username, password, fullname, roleID) VALUES ('admin', 'admin', 'Administrative User', 2);
INSERT INTO users (username, password, fullname, roleID) VALUES ('armando', 'armando', 'Armando Bronca', 3);
INSERT INTO users (username, password, fullname, roleID) VALUES ('dolores', 'dolores', 'Dolores Fuertes', 3);
INSERT INTO users (username, password, fullname, roleID) VALUES ('juanca', 'juanca', 'Juanca Bronazo', 4);

