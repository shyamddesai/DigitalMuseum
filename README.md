
# DigitalMuseum: Museum Management Software System

**A comprehensive platform for managing museums, artefacts, and enhancing visitor and employee interactions.**

## Table of Contents
1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Key Features](#key-features)
4. [System Architecture](#system-architecture)
5. [How to Use](#how-to-use)
6. [Testing and Key Design Decisions](#testing-and-key-design-decisions)
7. [API Documentation](#api-documentation)
8. [Setup and Installation](#setup-and-installation)
9. [Database Setup](#database-setup)

---

## Project Overview
DigitalMuseum is a software solution tailored to the needs of small and medium-sized museums. It provides an efficient and streamlined way to manage museum artefacts, facilitate visitor interactions, and organize internal operations. The system allows museums to offer their services online, providing visitors with easy access to browse, loan, or donate artefacts, and book tours and tickets. On the administrative side, museum employees can manage artefacts, and managers can oversee staff shifts and operations.

For a complete overview of the domain model and its key design decisions, please refer to the [Domain Model](https://github.com/shyamddesai/DigitalMuseum/wiki/Domain-Model).

---

## Technologies Used
- **Frontend**: React, HTML, CSS, JavaScript
- **Backend**: Java, Spring Boot, RESTful APIs
- **Database**: PostgreSQL, Hibernate
- **Deployment**: Docker, GitHub Actions

---

## Key Features
### 1. **Visitor Management**:
- **Account Creation and Login**: Visitors can create accounts, log in, and manage their personal details.
- **Browse Artefacts**: Visitors can view the museum's collection, read descriptions, and request artefacts for loan or donation.
- **Book Tickets and Tours**: Visitors can easily book tickets for museum events or schedule tours.
- **Track Loan and Donation Status**: Visitors can check the status of their artefact loan or donation requests directly from their profile.

### 2. **Artefact Management**:
- **Create and Update Artefacts**: Employees can create, edit, or remove artefacts, including details such as artefact history, origin, and exhibit location.
- **Move Artefacts**: Employees have the ability to manage artefact transfers within the museum's different sections.

### 3. **Employee and Shift Management**:
- **Employee Directory**: Managers can add or update employee records, including personal details, roles, and assigned shifts.
- **Shift Scheduling**: Managers can manage employee shifts, ensuring the museum is properly staffed for each day.

---

## System Architecture
DigitalMuseum is structured using a multi-layer architecture to separate concerns and ensure scalability:

### 1. **Frontend**:
   - Built using **React.js**, the frontend delivers a responsive and interactive user experience for visitors, employees, and managers.
   - The user interface provides dynamic forms, interactive artefact browsing, and booking systems for a smooth user experience.

### 2. **Backend**:
   - The backend is developed with **Spring Boot** in Java, which handles business logic and data processing.
   - It includes RESTful APIs communicating with the frontend for artefact management, user authentication, and loan/donation request handling.

### 3. **Database**:
   - **PostgreSQL** is used as the relational database to manage museum data, including artefacts, users, employees, and requests.
   - **Hibernate ORM** is integrated to map Java objects to database tables, streamlining database operations.

### 4. **Deployment**:
   - The system is containerized using **Docker** for easy deployment and scaling.
   - Continuous Integration (CI) pipelines are set up using **GitHub Actions**, enabling automated testing and deployment.

For further details on the architecture, please visit the [Architecture Model](https://github.com/shyamddesai/DigitalMuseum/wiki/Architecture-Model) page.

---

## How to Use
### 1. **Visitor Workflow**:
   - Create an account or log in.
   - Browse the artefact collection, book tickets for museum events, or schedule a tour.
   - Request to loan or donate artefacts, and track your request status from your profile page.

### 2. **Employee Workflow**:
   - Log in with employee credentials.
   - Access artefact management features: create, update, or move artefacts.
   - Manage visitor requests for artefact loans and donations.

### 3. **Manager Workflow**:
   - Log in with manager credentials.
   - Access employee management features: view and update employee records, assign shifts, and review museum operations.
   - Monitor artefact requests and manage notifications.

---

## Testing and Key Design Decisions

DigitalMuseum employs both static and dynamic testing methodologies to ensure the integrity of the system. For more details on the testing approach, please refer to the [Test Plan](https://github.com/shyamddesai/DigitalMuseum/wiki/Test-Plan).

Some of the key design decisions made during the project can be found in the [Project Report Deliverable 1](https://github.com/shyamddesai/DigitalMuseum/wiki/Project-Report-Deliverable-1) and [Project Report Deliverable 3](https://github.com/shyamddesai/DigitalMuseum/wiki/Project-Report-Deliverable-3#key-design-decisions) sections.

---

## API Documentation
The API provides endpoints for the core functionalities of the system.

Key Endpoints:
- **GET** `/artefacts`: Retrieve a list of all artefacts in the museum.
- **POST** `/artefacts`: Create a new artefact.
- **PUT** `/artefacts/{id}`: Update an existing artefact.
- **DELETE** `/artefacts/{id}`: Remove an artefact from the museum's collection.

For more detailed endpoint usage, refer to the [API Documentation](https://github.com/shyamddesai/DigitalMuseum/wiki/API-Documentation).

---

## Setup and Installation

To set up and run the DigitalMuseum system on your local machine, follow the steps below:

### 1. Backend Setup

- Ensure you have **Java 11+** and **Gradle** installed on your system.
- Navigate to the backend directory and run the following commands:
```bash
./gradlew clean build
./gradlew bootRun
```
- The backend will be available at `http://127.0.0.1:8080`.

### 2. Frontend Setup

- Ensure **node.js** (version 10.21.0 or higher) and **npm** (version 6.14.4 or higher) are installed on your system.
- Navigate to the frontend directory and run the following command to start the frontend:
```bash
npm run dev
```
- The frontend will be available at `http://127.0.0.1:8087`.

Once both backend and frontend systems are running, you can start using the application.

To log in as the Manager, use the following preset credentials:
- **Username**: marwan.kanaan@mcgill.ca
- **Password**: 1VerySecurePassword

---

## Database Setup

The system uses a PostgreSQL database. The default configuration is as follows:
- **Username**: `postgres`
- **Password**: `password`
- **Database Name**: `mmss`

To set up the PostgreSQL database:
```bash
psql -U postgres -c "CREATE DATABASE mmss;"
```

For further details on database setup and configuration, refer to the [Build System and CI Specifications](https://github.com/shyamddesai/DigitalMuseum/wiki/Build-System-and-CI-Specifications).
