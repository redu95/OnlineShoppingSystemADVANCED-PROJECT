# Online Shopping System - Advanced Project

The Online Shopping System is a web application that allows customers to browse and purchase products online. It provides CRUD (Create, Read, Update, Delete) functionality for the admin to manage products, and allows customers to register, login, add products to the cart, and make purchases. The backend of the system is implemented using Java Servlets, while the frontend is built with Bootstrap, CSS, and HTML. The system also utilizes session tracking and a MySQL database for data storage.

## Features

The project includes the following features:

- Admin Functionality:
  - Add new products to the system.
  - Edit existing product details.
  - View the list of available products.
  - Delete products from the system.

- Customer Functionality:
  - Register an account.
  - Login to the system.
  - Browse through the available products.
  - Add products to the cart.
  - Complete the purchase by providing shipping and payment details.

- Session Tracking:
  - The system uses session tracking to maintain the state of the user during their visit to the website.
  - Sessions are used to store user information, such as login status and shopping cart contents.

- Database:
  - The system uses a MySQL database to store data.
  - The database contains tables for storing product information, user details, and order information.

## Prerequisites

Before running the project, ensure that you have the following installed:

- Java Development Kit (JDK)
- Apache Tomcat server
- MySQL database server
- MySQL Connector/J (JDBC driver for MySQL)

## Getting Started

To get started with the Online Shopping System, follow these steps:

1. Clone the repository or download the source code files.
2. Set up the MySQL database by importing the provided SQL script (`database.sql`).
3. Configure the database connection settings in the `db.properties` file.
4. Build the project and deploy the WAR file to the Apache Tomcat server.
5. Start the Tomcat server.

## Usage

1. Open a web browser and navigate to the URL of the Online Shopping System.
2. As an admin, you can log in using the provided admin credentials. From the admin dashboard, you can add, edit, view, and delete products.
3. As a customer, you can register a new account or log in using your existing credentials. Browse through the products, add them to your cart, and proceed to checkout to complete your purchase.

## Contributing

Contributions to the project are welcome. If you find any issues or have suggestions for improvement, please create an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
