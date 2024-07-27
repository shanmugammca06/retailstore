# The Retail Store Discounts
This project aims to streamline the billing process in retail stores, providing accurate discount calculations and enhancing the customer shopping experience.

# Overview
The Retail Store Billing System is designed to manage and automate the billing process within a retail store, ensuring that customers receive the appropriate discounts based on specific criteria. The system applies various discounts to the total bill amount, depending on the customer's relationship with the store and the type of products purchased.

# Key Features
**Employee Discount:** If the user is an employee of the store, they receive a 30% discount on non-grocery items.

**Affiliate Discount:** If the user is an affiliate of the store, they receive a 10% discount on non-grocery items.

**Loyalty Discount:** If the user has been a customer for over 2 years, they receive a 5% discount on non-grocery items.

**Flat Discount:** For every $100 spent on the bill, the user receives a $5 discount.

**Grocery Exclusion:** Percentage-based discounts do not apply to grocery items.

**Single Percentage Discount:** A user can only receive one of the percentage-based discounts on a bill.

# Components

**User Management**
Users can be classified as employees, affiliates, or regular customers.
The system tracks user details including their type and subscription date.

**Product Management**
Products are categorized into different types such as grocery and non-grocery items.
Each product has an identifier, name, price, and category.

**Billing and Discounts**
The billing system calculates the total bill amount and applies the appropriate discounts.
The system ensures that only one percentage-based discount is applied per bill, alongside the flat discount.

**Technologies Used**

**Java:** The core programming language used for developing the application.

**Spring Boot:** Framework used for building the application and managing dependencies.

**JUnit:** Testing framework used to write and run unit tests.

**JSON:** Used for data representation and exchange.

**Maven:** Build automation tool used for project management and dependency management.

**Commons IO:** Library used for file operations.

# Class Overview

**UserDto**

Data Transfer Object representing user details including ID, name, type, and subscription date.

**ProductDto**

Data Transfer Object representing product details including ID, name, category, and price.

**BillingDao**

Interface defining the method for generating bills.

**BillingDaoImpl**

Implementation of the BillingDao interface, containing the logic for calculating discounts and generating the final bill.

**Products**

Singleton class managing the list of products available in the store.

**Users**

Singleton class managing the list of users registered with the store.

**RetailStoreApplication**

Main application class that runs the Spring Boot application.

**RetailStoreApplicationTests**

Class containing unit tests to verify the correctness of the billing and discount calculations.

# Usage

**Initialization:** The system initializes by reading product and user details from predefined files.

**Bill Generation:** When a bill is generated, the system applies the relevant discounts based on the user’s relationship with the store and the type of products in the cart.

**Discount Calculation:** The system ensures the correct application of discounts, prioritizing employee and affiliate discounts over loyalty discounts, and applies a flat discount for every $100 spent.

# Prerequisites

To set up and run the Retail Store Billing System project, ensure you have the following prerequisites:

1. Java Development Kit (JDK) Version: JDK 17.
2. Apache Maven Version: Maven 3.6 or higher.
3. Resource Files
   
    **Product Data:** templates/productdetails.db containing product details.
    
    **User Data:** templates/userinfo.db containing user details.
    
    **Format:** Ensure these files are placed in the src/main/resources directory of your project.

# Build, Test, and Run the Application
1. Open a terminal or command prompt.
2. Navigate to the root directory of the project where `pom.xml` is located.

    **Build:** Use Maven to build the project.
   ~~~
   mvn clean install
   ~~~   
   
    **Run:** Use your IDE or Maven to run the Spring Boot application.
    ~~~
    mvn spring-boot:run
    ~~~
3. Testing or to generate Jacoco code coverage report 

   **JUnit:** Ensure your project includes JUnit for running tests.

   **Run Tests:** Execute the test cases using your IDE or Maven.
   ~~~
   mvn test
   ~~~
   Jacoco HTML report will be generated in `target\site\jacoco\index.html`
   
  ![image](https://github.com/user-attachments/assets/4e9aae67-8feb-4147-a011-bd22931a06fe)


5. To generate SonarQube report

   **Prerequisites**
   
   SonarQube/Ensure you have SonarQube configured and accessible.
   
   **Running Sonar Analysis**
   
   Open Terminal or Command Prompt: Navigate to the root directory of your project where pom.xml is located run the following command.
   ~~~
   mvn sonar:sonar
   ~~~
   **Result**

   Report can be viwed in the URL http://localhost:9000
6. Access the API
   You can access the API endpoints using tools like Postman or cURL. Here are examples of how to access the generateBill endpoint:

   **Using Postman**
   1. Open Postman and create a new POST request.
   2. Set the request URL to http://localhost:8080/api/generateBill.
   3. Set the request body to JSON format and include the cart details:
   ~~~
   {
    "products": [
        {
            "productId": 123,
            "quantity": 2
        },
        {
            "productId": 124,
            "quantity": 12
        }
    ]
   }
   ~~~
   4. Add a query parameter userId with the value of the user's ID.
   5. Send the request and check the response.
  

# UML Diagram

**Class Diagram**

![UMLDiagram](https://github.com/user-attachments/assets/dd2ffffd-0c4b-4223-9b27-77781409d603)
