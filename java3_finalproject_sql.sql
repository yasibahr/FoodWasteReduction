DROP DATABASE IF EXISTS FoodWasteReduction;
CREATE DATABASE FoodWasteReduction;

USE FoodWasteReduction;

DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS User_Type;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Food_Item;
DROP TABLE IF EXISTS Status_Type;


CREATE TABLE User_Type(
	userTypeId INT NOT NULL AUTO_INCREMENT,
    userType VARCHAR(20) NOT NULL,
    CONSTRAINT PK_userTypeId PRIMARY KEY (userTypeId)
);
ALTER TABLE User_Type AUTO_INCREMENT=100;

CREATE TABLE City(
	cityId INT NOT NULL AUTO_INCREMENT,
    cityName VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    CONSTRAINT PK_cityId PRIMARY KEY (cityId)
);
ALTER TABLE City AUTO_INCREMENT=200;

CREATE TABLE Status_Type(
	statusTypeId INT NOT NULL AUTO_INCREMENT,
    statusTypeName VARCHAR(50) NOT NULL,
    CONSTRAINT PK_statusTypeId PRIMARY KEY (statusTypeId)
);
ALTER TABLE Status_Type AUTO_INCREMENT=300;

CREATE TABLE Users(
  userId INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(100) NOT NULL, 
  email VARCHAR(50),
  phone VARCHAR(50),
  password VARCHAR(50) NOT NULL,
  userTypeId INT,
  cityId INT, 
  CONSTRAINT PK_userId PRIMARY KEY (userId),
  FOREIGN KEY (userTypeId) REFERENCES User_Type(userTypeId),
  FOREIGN KEY (cityId) REFERENCES City(cityId)
);
ALTER TABLE Users AUTO_INCREMENT=400;

CREATE TABLE Transactions(
	transactionId INT NOT NULL AUTO_INCREMENT,
    transactionDate DATETIME NOT NULL,
    userId INT,
    cityId INT,
    userTypeId INT,
    CONSTRAINT PK_transactionId PRIMARY KEY (transactionId),
    FOREIGN KEY (userId) REFERENCES Users(userId),
    FOREIGN KEY (cityId) REFERENCES City(cityId),
    FOREIGN KEY (userTypeId) REFERENCES User_Type(userTypeId)
);
ALTER TABLE Transactions AUTO_INCREMENT=500;

CREATE TABLE Food_Item(
	foodId INT NOT NULL AUTO_INCREMENT,
    foodName VARCHAR(50) NOT NULL,
    expirationDate DATETIME NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    statusTypeId INT, 
    transactionId INT,
    userId INT,
    userTypeId INT,
    cityId INT,
    CONSTRAINT PK_foodId PRIMARY KEY (foodId),
	FOREIGN KEY (statusTypeId) REFERENCES Status_Type(statusTypeId),
    FOREIGN KEY (transactionId) REFERENCES Transactions(transactionId),
    FOREIGN KEY (userId) REFERENCES Users(userId),
    FOREIGN KEY (cityId) REFERENCES City(cityId),
    FOREIGN KEY (userTypeId) REFERENCES User_Type(userTypeId)
);
ALTER TABLE Food_Item AUTO_INCREMENT=600;


