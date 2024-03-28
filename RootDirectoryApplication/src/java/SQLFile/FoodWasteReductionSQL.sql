
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
	userTypeID INT NOT NULL AUTO_INCREMENT,
    userType VARCHAR(20) NOT NULL,
    CONSTRAINT PK_userTypeID PRIMARY KEY (userTypeID)
);
ALTER TABLE User_Type AUTO_INCREMENT=100;

CREATE TABLE City(
	cityID INT NOT NULL AUTO_INCREMENT,
    cityName VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    CONSTRAINT PK_cityID PRIMARY KEY (cityID)
);
ALTER TABLE City AUTO_INCREMENT=200;

CREATE TABLE Status_Type(
	statusTypeID INT NOT NULL AUTO_INCREMENT,
    statusTypeName VARCHAR(50) NOT NULL,
    CONSTRAINT PK_statusTypeID PRIMARY KEY (statusTypeID)
);
ALTER TABLE Status_Type AUTO_INCREMENT=300;

CREATE TABLE Users(
  userID INT NOT NULL AUTO_INCREMENT,
  userName VARCHAR(100) NOT NULL, 
  email VARCHAR(50),
  phone VARCHAR(50),
  password VARCHAR(50) NOT NULL,
  userTypeID INT,
  cityID INT, 
  CONSTRAINT PK_userID PRIMARY KEY (userID),
  FOREIGN KEY (userTypeID) REFERENCES User_Type(userTypeID),
  FOREIGN KEY (cityID) REFERENCES City(cityID)
);
ALTER TABLE Users AUTO_INCREMENT=400;

CREATE TABLE Transactions(
	transactionID INT NOT NULL AUTO_INCREMENT,
    transactionDate DATETIME NOT NULL,
    userID INT,
    cityID INT,
    userTypeID INT,
    CONSTRAINT PK_transactionID PRIMARY KEY (transactionID),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (cityID) REFERENCES City(cityID),
    FOREIGN KEY (userTypeID) REFERENCES User_Type(userTypeID)
);
ALTER TABLE Transactions AUTO_INCREMENT=500;

CREATE TABLE Food_Item(
	foodID INT NOT NULL AUTO_INCREMENT,
    foodName VARCHAR(50) NOT NULL,
    expirationDate DATETIME NOT NULL,
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    statusTypeID INT, 
    transactionID INT,
    userID INT,
    userTypeID INT,
    cityID INT,
    CONSTRAINT PK_foodID PRIMARY KEY (foodID),
	FOREIGN KEY (statusTypeID) REFERENCES Status_Type(statusTypeID),
    FOREIGN KEY (transactionID) REFERENCES Transactions(transactionID),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (cityID) REFERENCES City(cityID),
    FOREIGN KEY (userTypeID) REFERENCES User_Type(userTypeID)
);
ALTER TABLE Food_Item AUTO_INCREMENT=600;
