# 💰 Expense Tracker

A full-stack web application that helps users **track income and expenses**, analyze financial habits, and visualize spending patterns through an interactive dashboard.

The application provides secure authentication, transaction management, and financial analytics using a modern **Spring Boot + Angular** architecture.

---

# 🚀 Features

### 🔐 User Authentication
- Secure login and registration
- Stateless authentication using **JWT (JSON Web Tokens)**
- Implemented with **Spring Security**

### 💳 Transaction Management
Users can manage their financial records through full CRUD operations:

- Add income or expense entries
- View all transactions
- Edit existing transactions
- Delete transactions

### 📊 Interactive Dashboard
A dynamic dashboard allows users to visualize financial activity using charts.

Users can:
- Track income vs expenses
- Monitor financial trends
- Understand spending patterns

### 🔌 REST API
The backend exposes RESTful APIs for all application features, enabling communication between the Angular frontend and Spring Boot backend.

---

# 🛠 Tech Stack

## Backend
- **Java**
- **Spring Boot**
- **Spring Security**
- **JWT Authentication**
- **JPA / Hibernate**
- **MySQL**
- **Maven**

## Frontend
- **Angular**
- **Chart.js**
- **HTML / CSS / TypeScript**

---

# 📂 Project Structure

```
expense-tracker
│
├── backend
│ ├── controllers
│ ├── services
│ ├── repositories
│ ├── models
│ └── security
│
├── frontend
│ ├── components
│ ├── services
│ └── dashboard
│
└── README.md
```

---

# ⚙️ Setup and Installation

## Prerequisites

Make sure the following are installed:

- **Java 11 or higher**
- **MySQL**
- **Node.js**
- **npm**
- **Angular CLI**

---

# 🖥 Backend Setup

### 1️⃣ Clone the Repository

```
git clone <repository_url>
cd backend
```

---

### 2️⃣ Configure MySQL Database

Create a new database in MySQL.

Example:

```
CREATE DATABASE expense_tracker;
```

Update the database configuration in:

```
application.properties
```

Example configuration:

```
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3️⃣ Build and Run the Backend

```
mvn clean install
mvn spring-boot:run
```

The backend server will start at:

```
http://localhost:8080
```

---

# 🌐 Frontend Setup

### 1️⃣ Navigate to Frontend Directory

```
cd frontend
```

---

### 2️⃣ Install Dependencies

```
npm install
```

---

### 3️⃣ Run the Angular Application

```
ng serve
```

The frontend will be available at:

```
http://localhost:4200
```

---

# 🧑‍💻 Using the Application

1. Open the frontend URL in your browser:

```
http://localhost:4200
```

2. Register a new account or log in.

3. Start managing your financial data:
- Add income
- Add expenses
- Track spending trends
- View dashboard analytics

---

# 🔌 API Endpoints

## Authentication

### Register User

```
POST /api/auth/register
```

Registers a new user.

---

### Login

```
POST /api/auth/login
```

Authenticates a user and returns a **JWT token**.

---

# 💳 Expense & Income Management

### Get All Transactions

```
GET /api/transactions
```

Returns all transactions for the logged-in user.

---

### Add Transaction

```
POST /api/transactions
```

Creates a new income or expense entry.

---

### Update Transaction

```
PUT /api/transactions/{id}
```

Updates an existing transaction.

---

### Delete Transaction

```
DELETE /api/transactions/{id}
```

Removes a transaction.

---

# 📊 Dashboard

### Get Financial Statistics

```
GET /api/dashboard/stats
```

Returns summarized financial data used to generate dashboard charts.

---

# 🌱 Possible Future Enhancements

- Budget planning features
- Monthly financial reports
- Export data as CSV or PDF
- Mobile-responsive UI improvements
- Multi-currency support
- Docker containerization
- Deployment to cloud platforms

---

# 👩‍💻 Author

**Neha Alex**

Software Engineer | Full Stack Developer

Technologies: Java, Spring Boot, Angular, REST APIs, Microservices

---

# ⭐ Motivation

This project was built to explore **full-stack development using Spring Boot and Angular**, focusing on secure authentication, REST API design, and interactive data visualization.

If you found this project useful, feel free to ⭐ the repository!
