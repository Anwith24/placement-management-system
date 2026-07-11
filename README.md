# Placement Management System

## Overview

The **Placement Management System** is a web-based application developed using **Spring Boot** to simplify the campus placement process. It provides separate modules for Students, Recruiters, and Administrators, enabling efficient management of job postings, applications, and placement activities.

## Features

### Student Module

* Student Registration
* Secure Login (BCrypt Password Encryption)
* View Available Jobs
* Search Jobs
* Apply for Jobs
* Prevent Duplicate Applications
* View My Applications
* Logout

### Recruiter Module

* Recruiter Registration
* Recruiter Login
* Add New Job
* Edit Job Details
* Delete Job
* View Student Applications
* Update Application Status

### Admin Module

* Admin Login
* Dashboard with Statistics
* Manage Students
* Manage Recruiters
* View Overall Placement Data

## Technologies Used

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA (Hibernate)
* Thymeleaf
* Bootstrap 5
* MySQL
* Maven
* Git & GitHub

## Database

The application uses **MySQL** to store:

* Students
* Recruiters
* Jobs
* Applications
* Admin Details

## Security

* Student passwords are encrypted using **BCrypt Password Encoder** before being stored in the database.
* Session-based authentication is used for login and logout.

## Project Structure

* Entity Layer
* Repository Layer
* Service Layer
* Controller Layer
* Thymeleaf Templates
* MySQL Database

## How to Run the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL in `application.properties`.
4. Create the required database.
5. Run the Spring Boot application.
6. Open your browser and visit:

```
http://localhost:8080/
```

## Future Enhancements

* Spring Security integration
* Email notifications
* Resume upload
* Interview scheduling
* Placement analytics dashboard

## Developer

**Anwith Suvarna**

MCA Student, MIT Manipal

## License

This project is developed for academic and learning purposes.
