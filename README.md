Finance Dashboard Backend

A simple backend system built using Spring Boot to manage financial records such as income and expenses.
This project provides REST APIs for CRUD operations, filtering, and basic analytics.


Tech Stack
Java 21
Spring Boot
Spring Data JPA
MySQL
Maven
Postman (for API testing)



   controller # API endpoints 
   service # Business logic 
   repository # Database layer
   entity # Database models 
   dto # Request/Response objects 


   Setup & Run Project

1. Clone the Repository
git clone https://github.com/your-username/finance-dashboard.git
cd finance-dashboard



2. Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



3. Create Database
CREATE DATABASE finance_db;

4. Run Application
Using Maven:
mvn spring-boot:run

5. Server URL
http://localhost:8080

 ->API Endpoints
 -> Auth APIs
 
POST /api/auth/register
POST /api/auth/login

-> Financial APIs

POST /api/records -> Create record
GET /api/records -> Get all records
PUT /api/records/{id} -> Update record
DELETE /api/records/{id} -> Delete record
   
