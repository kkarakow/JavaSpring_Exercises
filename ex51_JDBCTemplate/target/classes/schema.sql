CREATE TABLE student(
	id LONG PRIMARY KEY AUTO_INCREMENT, 
	name VARCHAR(255),
	houseNumber INT(5),
	streetName VARCHAR(255),
	city VARCHAR(255),
	province VARCHAR(255));
	
	CREATE TABLE provinces(
	province VARCHAR(255));