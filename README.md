# Student Management API

A simple **Spring Boot REST API** for managing student records.  
This project demonstrates **Spring Validation**, **RESTful API design**, and basic **CRUD operations** in a professional, easy-to-understand structure.

---

## Features

- **Add a student** (POST)
- **List all students** (GET)
- **Retrieve a single student** (GET by index)
- **Update a student** (PUT)
- **Delete a student** (DELETE)
- **Validation** of student input using Spring Boot Validator

---

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Validation
- Maven
- PowerShell / curl for API testing

---

The application will start on http://localhost:8080.

API Endpoints
Method	Endpoint	Description
POST	/api/students	Register a new student
GET	/api/students	Get all students
GET	/api/students/{index}	Get a single student by index
PUT	/api/students/{index}	Update a student by index
DELETE	/api/students/{index}	Delete a student by index
Example Requests
Add a new student (POST)
$student = @{name="John Doe"; age=21; email="john@example.com"} | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/students" -Method POST -Body $student -ContentType "application/json"

Get all students (GET)
Invoke-RestMethod -Uri "http://localhost:8080/api/students" -Method GET

Get a student by index (GET)
$index = 0
Invoke-RestMethod -Uri "http://localhost:8080/api/students/$index" -Method GET

Validation Rules

name: must not be empty

age: must be positive

email: must be a valid email format

Invalid requests will return a 400 Bad Request with descriptive error messages.

