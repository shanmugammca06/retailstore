# The Retail Store Discounts
This project aims to streamline the billing process in retail stores, providing accurate discount calculations and enhancing the customer shopping experience.

# Overview
The Retail Store Billing System is designed to manage and automate the billing process within a retail store, ensuring that customers receive the appropriate discounts based on specific criteria. The system applies various discounts to the total bill amount, depending on the customer's relationship with the store and the type of products purchased.

# Key Features
Employee Discount: If the user is an employee of the store, they receive a 30% discount on non-grocery items.

Affiliate Discount: If the user is an affiliate of the store, they receive a 10% discount on non-grocery items.

Loyalty Discount: If the user has been a customer for over 2 years, they receive a 5% discount on non-grocery items.

Flat Discount: For every $100 spent on the bill, the user receives a $5 discount.

Grocery Exclusion: Percentage-based discounts do not apply to grocery items.

Single Percentage Discount: A user can only receive one of the percentage-based discounts on a bill.

# Components

# User Management
Users can be classified as employees, affiliates, or regular customers.
The system tracks user details including their type and subscription date.

# Product Management
Products are categorized into different types such as grocery and non-grocery items.
Each product has an identifier, name, price, and category.
Billing and Discounts

The billing system calculates the total bill amount and applies the appropriate discounts.
The system ensures that only one percentage-based discount is applied per bill, alongside the flat discount.

# Technologies Used

Java: The core programming language used for developing the application.

Spring Boot: Framework used for building the application and managing dependencies.

JUnit: Testing framework used to write and run unit tests.

JSON: Used for data representation and exchange.

Maven: Build automation tool used for project management and dependency management.

Commons IO: Library used for file operations.

ResourceUtils: Utility class used for accessing resources.

# Class Overview

UserDto

Data Transfer Object representing user details including ID, name, type, and subscription date.

ProductDto

Data Transfer Object representing product details including ID, name, category, and price.

BillingDao

Interface defining the method for generating bills.

BillingDaoImpl

Implementation of the BillingDao interface, containing the logic for calculating discounts and generating the final bill.

Products

Singleton class managing the list of products available in the store.

Users

Singleton class managing the list of users registered with the store.

RetailStoreApplication

Main application class that runs the Spring Boot application.

RetailStoreApplicationTests

Class containing unit tests to verify the correctness of the billing and discount calculations.

# Usage

Initialization: The system initializes by reading product and user details from predefined files.

Bill Generation: When a bill is generated, the system applies the relevant discounts based on the user’s relationship with the store and the type of products in the cart.

Discount Calculation: The system ensures the correct application of discounts, prioritizing employee and affiliate discounts over loyalty discounts, and applies a flat discount for every $100 spent.

