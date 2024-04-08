-- Created by Fereshteh Rohani

INSERT INTO User_Type (userType) VALUES ('admin');
INSERT INTO User_Type (userType) VALUES ('retailor');
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
-- Retailor
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailor1', 'retailor1@example.com', '9992223350', '12345678', 101, 201);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailor2', 'retailor2@example.com', '9992223351', '12345678', 101, 202);
INSERT INTO Users (userName, email, phone, password, userTypeID, cityID) 
VALUES ('retailor3', 'retailor3@example.com', '9992223352', '12345678', 101, 203);
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
INSERT INTO Status_Type (statusTypeName) VALUES ('Sold');
INSERT INTO Status_Type (statusTypeName) VALUES ('Claimed');
INSERT INTO Status_Type (statusTypeName) VALUES ('Deleted');
INSERT INTO Status_Type (statusTypeName) VALUES ('Discounted');
INSERT INTO Status_Type (statusTypeName) VALUES ('Donated');
COMMIT;

SELECT * FROM User_Type ;
SELECT * FROM City;
SELECT * FROM Users;
SELECT * FROM Status_Type;