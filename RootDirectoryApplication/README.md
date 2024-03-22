Object Oriented Programming with Design Patterns: Final Project

CST8288 Lab 013

Prepared By:

Yasaman Bahramifarid (040976717)

Fereshteh Rohani (041096855)

Brian Labelle (041098304)

Bennett Ireland (040934690)

Due:

March 22<sup>nd</sup> 2024

Lab Professor: Jeremy

Table of Contents

[List of Figures 3](#_Toc161994397)

[Acronyms/Abbreviations 4](#_Toc161994398)

[Version History 5](#_Toc161994399)

[Introduction 5](#_Toc161994400)

[Targeted Audience 6](#_Toc161994401)

[Scope 6](#_Toc161994402)

[Application Architecture 6](#_Toc161994403)

[Business Architecture 8](#_Toc161994404)

[Detailed Design 9](#_Toc161994405)

[Data Architecture 13](#_Toc161994406)

[Testing Model 14](#_Toc161994407)

[References 15](#_Toc161994408)

### List of Figures

[Figure 1: Use Case Diagram for Food Waste Reduction Platform 8](#_Toc161994386)

[Figure 2: Singleton Pattern UML Diagram for Database Connection 9](#_Toc161994387)

[Figure 3: Simple Factory UML diagram for creating users 10](#_Toc161994388)

[Figure 4: Builder with Director UML diagram for creating Food items 10](#_Toc161994389)

[Figure 5: DAO Pattern UML diagram for User, UserType and City 11](#_Toc161994390)

[Figure 6: DAO Pattern UML diagram for Transaction and Food Item 11](#_Toc161994391)

[Figure 7: DAO Pattern UML diagram for Status Type 12](#_Toc161994392)

[Figure 8: Servlet UML diagram 12](#_Toc161994393)

[Figure 9: Conceptual ERD depicting entity relationships 13](#_Toc161994394)

[Figure 10: Logical ERD depicting entity relationships and fields 13](#_Toc161994395)

[Figure 11: Physical ERD showing the tables, relationships, fields, and constraints between each entity 14](#_Toc161994396)

### Acronyms/Abbreviations

**DAO**: Data Access Object

**DTO**: Data Transfer Object

**ERD**: Entity Relationship Diagram  

### Version History

| **Version Number** | **Description** | **Author** | **Date** |
| --- | --- | --- | --- |
| 1.0 | Began writing the document | Yasaman | 18-03-2024 |
| 1.1 | Worked on the document more, discussed roles | Everyone | 19-03-2024 |
| 1.2 | Added ERDs | Yasaman | 20-03-2024 |
| 1.3 | Added notes about testing | Brian | 20-03-2024 |
| 1.4 | Added ERDs<br><br>Added Use Case Diagrams<br><br>Finished JUnit section<br><br>Added UML diagrams<br><br>Added notes about testing<br><br>Formatted the document<br><br>Finished introduction and application architecture<br><br>Added acronyms/abbreviations section<br><br>Added table of figures and references | Yasaman, Fereshteh, Bennett | 21-03-2024 |
| 1.5 | Added finishing touches | Everyone | 22-03-2024 |

### Introduction

In this project, our goal is to create a Food Waste Reduction Platform, a Java-based application created using NetBeans, Eclipse, and MySQL, that will connect the user, retailers, charitable organizations, and consumers, to reduce food waste and promote sustainability. This platform aims to reduce food waste and create more sustainable and ethical consumption and production of food. Our platform will help optimize how we use our resources and what we do with food that has expired or is in excess. Our platform aims to minimize the impact of expired food and food waste on the environment, in an attempt to create a more ethical and less wasteful world.

In this document, we will detail all the general aspects of how we will create our application and what the application entails. We will create a document that can be easily adapted and used by other software developers who intend to create a similar application.

With this application, we hope to redirect surplus food to those in need, in an attempt to help fight starvation and provide help to those who need it.

### Targeted Audience

This document is intended for use by the project’s team members and other software developers who intend to use this application. This document will also be used by stakeholders to give them insight into the impacts, benefits, and specifications of the application.

### Scope

This document will include the project details, its design, and all functional and non-functional requirements. We will also have UML and Use case diagrams to help visualize and describe the system. The document will also have information about the data at hand and how we will test and model our work.

The source code and how we will implement our design will not be included in this document. The relevant training materials, security, and deployment will also not be included.

### Application Architecture

As per the project instructions, we are tasked with implementing a three-tier architecture.

Firstly, we have a Presentation layer, which encompasses the user’s point of view and how they will interact with the application. This layer captures and responds to user inputs and requests and presents the data and result from the Business Layer in a user-friendly manner. We will use Servlets to display data to the user.

We also have the Business layer, which involves the Business Logic and all functionalities of the application. This is the core of all the logic and functionality of our application. It processes user requests, performs operations, implements business rules, and makes decisions. Data is sent and received between the Presentation and Business layers and the data is retrieved and stored in relation to the Database layer. We will use the Simple Factory design pattern when creating Users and the Builder pattern with Directory when creating Food Items. We will create our classes using NetBeans and Eclipse.

Lastly, we have the Database layer, which is responsible for storing data related to users, food items, transactions and all other entities in our application. All user registration information, as well as details about each food item and all transaction records are stored in the database. The Business layer will retrieve data from the Database as needed and display the results to the user. The Database layer is also responsible for ensuring the security, organization and consistency of all our data. We will use the DAO design pattern and MySQL to create the Database layer.

### Business Architecture

#### ![Figure1_UseCase](/docs/images/Figure1_UseCase.png)

Figure 1: Use Case Diagram for Food Waste Reduction Platform

#### User Stories

**User Story: Add New Item to Inventory**

As a retailer, I want to be able to add new food items to my inventory, so I can keep track of the products I have available for sale.

**User Story: Update Item Quantity**

As a retailer, I want to have the ability to update the quantity of existing food items in my inventory, so I can adjust my stock levels accurately based on demand.

**User Story: Set Expiration Date for Items**

As a retailer, I want to set or update expiration dates for food items in my inventory, so I can ensure that I am selling products before they expire and minimize waste.

**User Story: View Inventory List**

As a retailer, I want to view a comprehensive list of all the food items in my inventory, so I can easily monitor stock levels and make informed decisions about purchasing and sales strategies.

**User Story: Search Functionality**

As a retailer, I want to have a search functionality in my inventory system, so I can quickly find specific items based on their names or other attributes, saving time and effort.

**User Story: List Items for Donation**

As a retailer, I want to be able to list certain food items for donation, so I can contribute to reducing food waste and help those in need within the community.

**User Story: List Items for Sale at Discounted Price**

As a retailer, I want the option to list specific food items for sale at a discounted price, so I can clear excess inventory and attract more customers with special offers.

**User Story: Decision Support for Donation or Sale**

As a retailer, I want the system to provide decision support based on quantity and expiration dates, so I can make informed choices about whether to donate surplus items or put them up for sale at reduced prices.

**User Story: View Available Food Items**

As a consumer, I want to view the list of available food items listed by retailers, so I can see what products are offered for sale at discounted prices.

**User Story: Purchase Food Items**

As a consumer, I want the ability to purchase food items listed by retailers, so I can buy quality products at reduced prices while also contributing to reducing food waste.

**User Story: Subscription for Surplus Food Alerts**

As a consumer, I want to subscribe to receive alerts about surplus food items based on my location and food preferences, so I can stay informed about opportunities to purchase or acquire discounted products.

**User Story: Receive Automatic Notifications**

As a consumer, I want to receive automatic notifications via email or phone whenever retailers list surplus food items on the platform, so I can quickly take advantage of the available deals and help reduce food waste.

**User Story: Claim Surplus Food Items**

As a charitable organization, I want to claim surplus food items listed by retailers for donation, so I can distribute them to those in need and help alleviate hunger in the community.

### Detailed Design

#### UML Class Diagrams

#### ![Figure2_SingletonUML](images/Figure2_SingletonUML.png)

Figure 2: Singleton Pattern UML Diagram for Database Connection

##### Simple Factory

#### ![Figure3_SimpleFactoryUML](images/Figure3_SimpleFactoryUML.png)

Figure 3: Simple Factory UML diagram for creating users

##### Builder

#### ![Figure4_BuilderUML](images/Figure4_BuilderUML.png)

Figure 4: Builder with Director UML diagram for creating Food items

#### ![Figure5_DAOUML1](images/Figure5_DAOUML1.png)

Figure 5: DAO Pattern UML diagram for User, UserType and City

#### ![Figure6_DAOUML2](images/Figure6_DAOUML2.png)

Figure 6: DAO Pattern UML diagram for Transaction and Food Item

#### ![Figure7_DAOUML3](images/Figure7_DAOUML3.png)

Figure 7: DAO Pattern UML diagram for Status Type

#### Servlet

#### ![Figure8_ServletsUML](images/Figure8_ServletsUML.png)

Figure 8: Servlet UML diagram

### Data Architecture

#### Conceptual Diagram

#### ![Figure9_ConceptualERD.png](images/Figure9_ConceptualERD.png.png)

Figure 9: Conceptual ERD depicting entity relationships

#### Logical Diagram

#### ![Figure10_LogicalERD](images/Figure10_LogicalERD.png)

Figure 10: Logical ERD depicting entity relationships and fields

#### Physical Diagram

#### ![Figure11_PhysicalERD](images/Figure11_PhysicalERD.png)

Figure 11: Physical ERD showing the tables, relationships, fields, and constraints between each entity

### Testing Model

#### Junit Testing

The application will be tested with Junits to test some of the following variables:

- UserId
- FoodItemId
- Array Lists that hold a representation of tables from the database (assert that they are not null)
- StatusTypeId (assert that they are equal to the presumed type before/after a transaction to verify it successfully executed)

We will also have JUnit test cases for each form validation, to test the DAO databse accessibility, and to test DTO and DAO connectivity.

We will also create test cases to test that our use cases work as expected and as planned.


#### Plan for Test Cases

1. **Preparation**

- Review project documentation related to project requirements and design
- Understand the objectives and functionalities of each part of the system
- Develop a list of test cases based on requirements and system functionalities

2. **Test Design**

- Create a test coverage map to ensure comprehensive coverage of all system functions and components
- Identify and select test cases for each part of the system, including user registration, inventory management, food claiming, etc.
- Determine testing methods for various scenarios

3. **Test Environment Setup**

- Set up a development environment for running tests, including temporary database and web environment
- Installing and configuring testing tools such as JUnit for executing unit tests

4. **Test Execution**

- Execute various test cases based on the test coverage map and identified test cases
- Record test results, including successful executions and encountered errors

5. **Test Result Analysis**

- Analyze test results and investigate causes of any errors or issues
- Evaluate test coverage and ensure complete coverage based on the test coverage map

6. **Reporting**

- Generate comprehensive reports of test results, including successful cases, failed cases, and test coverage
- Provide suggestions for improving the testing process and enhancing software quality

7. **Completion and Optimization**

- Performe tests in different environments and evaluate overall performance
- Optimize test cases and procedures for efficient and effective testing

### References

| \[1\] | S. Rivera, "Conceptual vs logical vs physical data models," thoughtspot, 01 June 2023. \[Online\]. Available: <https://www.thoughtspot.com/data-trends/data-modeling/conceptual-vs-logical-vs-physical-data-models>. |
| --- | --- |


