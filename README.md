# 📚 Library Management System

A console-based **Library Management System** developed using **Java** to demonstrate practical implementation of Object-Oriented Programming, Collections, Interfaces, Custom Exception Handling, and File I/O.

The system manages books, library members, borrowing and returning operations, book searching, borrowing records, and persistent storage of library data.

---

## 📌 Project Overview

The Library Management System is designed to simulate the core operations of a real-world library through a simple menu-driven console application.

The application allows users to:

* Add books
* Register student members
* Register faculty members
* Display books
* Display members
* Borrow books
* Return books
* Search books by title or author
* View borrowing records
* Save library data
* Automatically load previously saved data

The project focuses on writing clean, modular, and object-oriented Java code.

---

## 🎯 Project Objectives

The main objectives of this project are:

* To apply Java OOP concepts in a real-world application.
* To understand class relationships and inheritance.
* To use interfaces for defining common behavior.
* To manage dynamic data using Java Collections.
* To implement custom exception handling.
* To understand file-based data persistence.
* To develop a menu-driven console application.
* To organize Java code using packages and modular design.

---

## ✨ Features

### 📖 Book Management

* Add new books.
* Store book ID, title, and author.
* Track book availability.
* Display all books.
* Search books by title or author.

### 👥 Member Management

The system supports different types of members:

* Student Member
* Faculty Member

Each member has:

* Member ID
* Name
* Member Type

### 🔄 Borrowing Management

Users can:

* Borrow available books.
* Associate a book with a library member.
* Prevent borrowing of already borrowed books.
* Create borrowing records.

### ↩️ Returning Management

Users can:

* Return borrowed books.
* Update book availability.
* Record the return date.

### 🔍 Book Search

Books can be searched using:

* Book title
* Author name

The search is case-insensitive.

### 💾 Data Persistence

The application uses Java File I/O and serialization to save library data.

Library data is stored in:

```text
data/library.dat
```

When the application starts again, previously saved data can be loaded automatically.

### ⚠️ Exception Handling

The project uses custom exceptions for specific errors:

* `BookNotFoundException`
* `MemberNotFoundException`
* `BookNotAvailableException`

This makes error handling more meaningful and readable.

---

## 🧠 OOP Concepts Demonstrated

### 1. Encapsulation

Classes use private fields with controlled access through methods.

Example:

```java
private int bookId;
private String title;
private String author;
```

---

### 2. Abstraction

The `Member` class is declared as an abstract class.

```java
public abstract class Member {
    ...
}
```

It contains common properties and behavior for different types of members.

---

### 3. Inheritance

Different member types inherit from the `Member` class.

```text
              Member
             /      \
            /        \
 StudentMember    FacultyMember
```

---

### 4. Polymorphism

The `getMemberType()` method is overridden by subclasses.

```java
@Override
public String getMemberType() {
    return "Student";
}
```

and:

```java
@Override
public String getMemberType() {
    return "Faculty";
}
```

---

### 5. Interface

The `Borrowable` interface defines common borrowing behavior.

```java
public interface Borrowable {

    void borrowBook();

    void returnBook();

    boolean isAvailable();
}
```

The `Book` class implements this interface.

---

## 🛠️ Technologies Used

| Technology        | Purpose                   |
| ----------------- | ------------------------- |
| Java              | Core programming language |
| OOP               | Application design        |
| ArrayList         | Collection management     |
| Interfaces        | Define common behavior    |
| Custom Exceptions | Error handling            |
| File I/O          | Data persistence          |
| Serialization     | Save and restore objects  |
| Java Time API     | Borrow and return dates   |
| Console           | User interaction          |

---

## 📂 Project Structure

```text
LibraryManagementSystem/
│
├── src/
│   │
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Book.java
│   │   ├── Member.java
│   │   ├── StudentMember.java
│   │   ├── FacultyMember.java
│   │   └── BorrowRecord.java
│   │
│   ├── service/
│   │   └── Library.java
│   │
│   ├── interfaces/
│   │   └── Borrowable.java
│   │
│   └── exception/
│       ├── BookNotAvailableException.java
│       ├── BookNotFoundException.java
│       └── MemberNotFoundException.java
│
├── data/
│
├── README.md
└── .gitignore
```

---

## 🔄 Application Flow

```text
                User
                 │
                 ▼
          Main.java
        Menu-driven UI
                 │
                 ▼
             Library
          Business Logic
                 │
       ┌─────────┼─────────┐
       ▼         ▼         ▼
     Books    Members   Borrow Records
       │         │         │
       └─────────┼─────────┘
                 ▼
              File I/O
                 │
                 ▼
          library.dat
```

---

## ⚙️ Requirements

Before running the project, make sure you have:

* Java Development Kit (JDK) 17 or later
* Command Prompt / Terminal
* VS Code, IntelliJ IDEA, Eclipse, or another Java IDE

Check your Java installation:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

---

## ▶️ How to Run

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/library-management-system-java.git
```

Replace `YOUR-USERNAME` with your GitHub username.

---

### Step 2: Open the Project

Navigate to the project:

```bash
cd library-management-system-java
```

---

### Step 3: Compile the Project

On Windows:

```bash
javac -d out src/interfaces/*.java src/model/*.java src/exception/*.java src/service/*.java src/Main.java
```

---

### Step 4: Run the Application

```bash
java -cp out Main
```

---

## 🖥️ Application Menu

```text
==================================
     LIBRARY MANAGEMENT SYSTEM
==================================
1. Add Book
2. Add Student Member
3. Add Faculty Member
4. Display Books
5. Display Members
6. Borrow Book
7. Return Book
8. Search Book
9. Display Borrow Records
10. Save Data
0. Exit
```

---

## 🧪 Example

### Adding a Book

```text
Enter your choice: 1

Enter Book ID: 101
Enter Book Title: Clean Code
Enter Author: Robert Martin

Book added successfully.
```

### Adding a Student Member

```text
Enter your choice: 2

Enter Member ID: 1
Enter Student Name: Ajay

Member added successfully.
```

### Borrowing a Book

```text
Enter your choice: 6

Enter Book ID: 101
Enter Member ID: 1

Book borrowed successfully by Ajay
```

### Trying to Borrow an Unavailable Book

```text
Enter your choice: 6

Enter Book ID: 101
Enter Member ID: 2

Error: Book 'Clean Code' is already borrowed.
```

### Returning a Book

```text
Enter your choice: 7

Enter Book ID: 101

Book returned successfully.
```

---

## ⚠️ Exception Handling

The application uses custom exceptions to handle specific situations.

### BookNotFoundException

Triggered when a requested book does not exist.

```text
Error: Book with ID 999 not found.
```

### MemberNotFoundException

Triggered when a requested member does not exist.

```text
Error: Member with ID 999 not found.
```

### BookNotAvailableException

Triggered when a user attempts to borrow a book that is already borrowed.

```text
Error: Book 'Clean Code' is already borrowed.
```

---

## 💾 Data Persistence

The project uses Java serialization to store the complete `Library` object.

Data is stored in:

```text
data/library.dat
```

The application loads the saved data when it starts and saves the current data when requested or when the application exits.

Generated `.dat` files are excluded from Git using `.gitignore`.

---

## 🔐 Data Flow

```text
User Input
    ↓
Main.java
    ↓
Library Service
    ↓
Validation
    ↓
Book / Member / BorrowRecord
    ↓
ArrayList
    ↓
Serialization
    ↓
library.dat
```

---

## 📈 Future Enhancements

The current project can be extended with:

* Book categories and genres
* ISBN management
* Maximum borrowing limits
* Due dates
* Automatic fine calculation
* Member borrowing history
* Admin authentication
* Role-based access
* MySQL database integration
* JDBC
* Maven project structure
* JUnit testing
* Logging
* Spring Boot REST API
* Web-based frontend
* User authentication
* REST API documentation with Swagger

---

## 🚀 Planned Technology Evolution

```text
Current
   │
   ▼
Java + OOP
   │
   ▼
Collections + File I/O
   │
   ▼
JDBC + MySQL
   │
   ▼
Maven + JUnit
   │
   ▼
Spring Boot
   │
   ▼
REST API
   │
   ▼
Web Application
```

---

## 🎓 Learning Outcomes

Through this project, the following concepts are practically implemented:

* Java class and object design
* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Interfaces
* Collections Framework
* Exception Handling
* Custom Exceptions
* File I/O
* Object Serialization
* Package organization
* Menu-driven application development
* Basic software architecture

---

## 👨‍💻 Author

**Ajay Gavandare**

Java OOP Project — Library Management System

---

## 📄 License

This project is created for educational and learning purposes.
