Basis: Spring MVC

Model view: Thymeleaf

DB connection: Postgres

Database name: postgres

Table: CREATE TABLE units (id SERIAL PRIMARY KEY, age INT NOT NULL, 
	name VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL, email VARCHAR(50));
****
Connection to DB via postgres driver, web interface based on tomcat server with thymeleaf based pages. 

Validation of input data via annotations.

Interaction with database by SQL commands.

