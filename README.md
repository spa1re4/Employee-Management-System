# Employee-Management-System
Project Description: "Employee Management System"
This project is an employee management system that uses an SQLite database to store information about employees. The program allows the user to perform basic operations on employee data, such as:

Creating an Employee: The user can add a new employee by providing their name, position, salary, and hire date.
Deleting an Employee: The user can delete an employee by their unique identifier (ID).
Updating Employee Data: The program allows modifying information of an existing employee (such as name, position, salary, or hire date).
Reading Employee Data: The program displays a list of all employees from the database, showing information about each employee.
The system uses SQLite as the database, and all employee data is stored in the employees table, which includes the following fields:

id (unique employee identifier),
name (employee's name),
position (employee's position),
salary (employee's salary),
hire_date (employee's hire date).
The program provides a text-based menu for interacting with the system. The user selects an action by entering a number corresponding to the desired operation.

Technologies:
Java: The programming language used for developing the application logic.
SQLite: A lightweight database used for storing employee data.
Key Features:
A simple and intuitive menu for performing operations on employee data.
Use of SQLite for persistent data storage.
Ability to add, delete, update, and display employee information.
This project serves as an example of using databases in Java and demonstrates working with JDBC (Java Database Connectivity) for interacting with SQLite.
