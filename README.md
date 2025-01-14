# Expense Tracker

## Overview

The Expense Tracker is a web application designed to help users track their income and expenses. 
Users can log in, add, edit, and delete their income and expense records, as well as view their 
financial activity in a visually appealing dashboard with interactive charts that illustrate spending and earning trends.

## Features

- **User Login**: Authentication is implemented using **Spring Security** with **JWT** for secure and stateless login sessions.
- **CRUD Operations**: Users can perform **Create**, **Read**, **Update**, and **Delete** operations on their income and expense records.
- **Dashboard**: The dashboard displays financial activities in the form of interactive charts, allowing users to track their income and expenses over time.
- **REST API**: The backend is built using **Spring Boot** with RESTful endpoints for managing user interactions with the application.
- **Database Connectivity**: **MySQL** is used to store user data and financial records.
- **Frontend**: The user interface is built with **Angular** for a responsive and dynamic dashboard displaying charts for income and expense trends.

## Technologies Used

- **Backend**:
  - **Spring Boot** for building REST APIs
  - **Spring Security** with **JWT** for user authentication and authorization
  - **MySQL** for database management
  - **JPA (Java Persistence API)** for database operations

- **Frontend**:
  - **Angular** for building the user interface
  - **Chart.js** for rendering interactive charts

## Setup and Installation

### Prerequisites

- **Java 11 or above**
- **MySQL** installed and running
- **Node.js** and **npm** (for Angular)

### Backend Setup

1. Clone the repository:

->git clone <repository_url>
->cd backend

2. Set up the MySQL database:

    Create a new database for the project.
    Update application.properties with your database credentials.

3. Build and run the backend:

mvn clean install
mvn spring-boot:run

The backend server will start on http://localhost:8080.

**2. Frontend Setup**

1. Navigate to the frontend directory:
    cd frontend
2. Install the necessary dependencies:

   npm install

3. Run the Angular application:

  ng serve

**The frontend will be available at http://localhost:4200.**

3. Accessing the Application

    Open the frontend URL (http://localhost:4200) in your browser.
    Register or log in with your credentials to start tracking your expenses and income.

Endpoints
Authentication

    POST /api/auth/login - Authenticate user and return JWT token.
    POST /api/auth/register - Register a new user.

Expense & Income Management

  GET /api/transactions - Get all expenses and income for the logged-in user.
  POST /api/transactions - Add a new expense or income.
  PUT /api/transactions/{id} - Update an existing transaction.
  DELETE /api/transactions/{id} - Delete a transaction.

Dashboard

  GET /api/dashboard/stats - Get spending and earning trends data for displaying on charts.


Contributing

   Fork the repository.
   Create a new branch (git checkout -b feature-branch).
   Make your changes and commit them (git commit -am 'Add new feature').
   Push to the branch (git push origin feature-branch).
   Create a new Pull Request.

