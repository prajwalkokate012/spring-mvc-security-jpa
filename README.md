Spring MVC Security JPA
Description
A simple Spring Boot application with MVC, Security, and JPA. It includes JWT-based authentication with roles for students and admins, using an H2 in-memory database.

Requirements
JDK 21+
Maven
Setup Instructions
Clone the repository
git clone  https://github.com/prajwalkokate012/spring-mvc-security-jpa.git
Import the project into Eclipse:

Open Eclipse.
Go to File -> Import.
Select Existing Maven Projects and click Next.
Browse to the location where you cloned the repository and click Finish.
Build the project using Maven:

Right-click on the project in the Project Explorer.
Select Run As -> Maven install.
Run the application:

Right-click on the project in the Project Explorer.
Select Run As -> Spring Boot App.
Usage
H2 Database Console
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password
APIs
Login:

URL: /auth/login
Method: POST
Request Body:
json
Copy code
{
    "username": "your-username",
    "password": "your-password"
}
Response: JWT token
Create Student:

URL: /students
Method: POST
Request Body:
json
Copy code
{
    "name": "John Doe",
    "address": "123 Main St",
    "subjects": [
        {"name": "Math"},
        {"name": "Science"}
    ]
}
Get All Students:

URL: /students
Method: GET
Response: List of students
Get All Subjects:

URL: /subjects
Method: GET
Response: List of subjects
