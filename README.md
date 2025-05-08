# 📝 Online Assessment System (Java + MySQL)

A console-based Java application that simulates an **Online Assessment System** with roles for students and teachers. This project demonstrates user authentication, dynamic quiz management, score tracking, and database integration using JDBC and MySQL.

---

## 📌 Features

### 👨‍🎓 Student:
- Sign up and login
- Attempt quizzes pulled from a database
- Receive score at the end

### 👩‍🏫 Teacher:
- Login using role credentials
- Add new quiz questions
- View scores submitted by students

---

## 🧰 Technologies Used

- Java (Core)
- JDBC (Java Database Connectivity)
- MySQL (RDBMS)
- CLI (Command-line Interface)

---

## 🗃️ Database Schema

### Database: `OnlineAssessment`

#### Table: `users`
| Field      | Type        |
|------------|-------------|
| id         | INT (PK, AI)|
| username   | VARCHAR(255)|
| password   | VARCHAR(255)|
| role       | VARCHAR(50) |

#### Table: `questions`
| Field         | Type         |
|---------------|--------------|
| id            | INT (PK, AI) |
| question      | TEXT         |
| option1       | VARCHAR(255) |
| option2       | VARCHAR(255) |
| option3       | VARCHAR(255) |
| option4       | VARCHAR(255) |
| correct_option| INT          |

#### Table: `scores`
| Field        | Type         |
|--------------|--------------|
| id           | INT (PK, AI) |
| student_name | VARCHAR(255) |
| score        | INT          |
