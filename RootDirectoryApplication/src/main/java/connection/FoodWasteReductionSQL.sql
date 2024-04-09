/**
 *
 * @author Yasaman, Brian, Fereshteh, Bennett
 */
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




INSERT INTO User_Type (userType) VALUES ('admin');
INSERT INTO User_Type (userType) VALUES ('retailer');
INSERT INTO User_Type (userType) VALUES ('consumer');
INSERT INTO User_Type (userType) VALUES ('charity');
COMMIT;

INSERT INTO City (cityName,country) VALUES ('Ottawa','Canada');
INSERT INTO City (cityName,country) VALUES ('Toronto','Canada');
INSERT INTO City (cityName,country) VALUES ('Vancouver','Canada');
INSERT INTO City (cityName,country) VALUES ('Montreal','Canada');
INSERT INTO City (cityName,country) VALUES ('Calgary','Canada');
INSERT INTO City (cityName,country) VALUES ('Edmonton','Canada');
INSERT INTO City (cityName,country) VALUES ('Quebec','Canada');
INSERT INTO City (cityName,country) VALUES ('Halifax','Canada');
INSERT INTO City (cityName,country) VALUES ('Winnipeg','Canada');
INSERT INTO City (cityName,country) VALUES ('Hamilton','Canada');
INSERT INTO City (cityName,country) VALUES ('London','Canada');
INSERT INTO City (cityName,country) VALUES ('Victoria','Canada');
COMMIT;

-- Admin
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('admin', 'admin@example.com', '9992223340', 'adminadmin', 100, 200);
-- Retailer
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailer1', 'retailer1@example.com', '9992223350', '12345678', 101, 201);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailer2', 'retailer2@example.com', '9992223351', '12345678', 101, 202);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailer3', 'retailer3@example.com', '9992223352', '12345678', 101, 203);
-- Consumer
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('consumer1', 'consumer1@example.com', '9992223360', '12345678', 102, 204);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('consumer2', 'consumer2@example.com', '9992223361', '12345678', 102, 205);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('consumer3', 'consumer3@example.com', '9992223362', '12345678', 102, 206);
-- Charity
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('charity1', 'charity1@example.com', '9992223370', '12345678', 103, 207);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('charity2', 'charity2@example.com', '9992223371', '12345678', 103, 208);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('charity3', 'charity3@example.com', '9992223372', '12345678', 103, 209);
COMMIT;

INSERT INTO Status_Type (statusTypeName) VALUES ('Available');
INSERT INTO Status_Type (statusTypeName) VALUES ('Available');
INSERT INTO Status_Type (statusTypeName) VALUES ('Claimed');
INSERT INTO Status_Type (statusTypeName) VALUES ('For Donation');
INSERT INTO Status_Type (statusTypeName) VALUES ('Discounted');
INSERT INTO Status_Type (statusTypeName) VALUES ('Donated');
COMMIT;

INSERT INTO Food_Item (foodName, expirationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID, cityID) 
VALUES ('bananas', '2024-04-11 13:23:44', 5.00, 4, 300, null, 401, 101, 206); 
INSERT INTO Food_Item (foodName, expirationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID, cityID) 
VALUES ('apples', '2024-06-11 13:23:44', 7.00, 4, 300, null, 401, 101, 206); 
INSERT INTO Food_Item (foodName, expirationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID, cityID) 
VALUES ('cheese', '2024-05-19 13:23:44', 2.00, 4, 301, null, 401, 101, 206); 
INSERT INTO Food_Item (foodName, expirationDate, price, quantity, statusTypeID, transactionID, userID, userTypeID, cityID) 
VALUES ('fish', '2024-04-29 13:23:44', 10.00, 4, 302, null, 401, 101, 206); 
COMMIT;

SELECT * FROM User_Type ;
SELECT * FROM City;
SELECT * FROM Users;
SELECT * FROM Status_Type;
SELECT * FROM Food_Item;
SELECT * FROM Transactions;