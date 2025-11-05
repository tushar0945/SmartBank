# 🏦 SmartBank — Java Console Banking Management System

A simple yet functional **Bank Management System** built in **Java** with **MySQL database integration**.
This project simulates common banking operations such as account creation, deposits, withdrawals, balance checking, and manager-controlled account management.

---

## 🚀 Features

### 👤 User Features

* **Create Account** — Register a new customer with personal details.
* **Deposit Money** — Add funds to an existing account.
* **Withdraw Money** — Withdraw funds (with balance validation).
* **Check Balance** — View current balance.

### 🧑‍💼 Manager Features

* **Secure Manager Login**
* **View All Accounts**
* **Search Account by Account Number**
* **Delete Account**

---

## 🏗️ Project Structure

```
SmartBank/
│
|
├── bin/
│   └── main/
|       └─── #All Class files 
|
├── lib/
│   └── mysql-connector-j-9.5.0.jar
├── src/
│   └─── main/
│       ├── Main.java              # Entry point (menu system)
│       ├── BankService.java       # User account operations
│       ├── ManagerService.java    # Manager-level actions
│       ├── Account.java           # Account model (POJO)
│       ├── DatabaseConnection.java# JDBC connection logic
│       └── Validator.java         # Input validation + colored messages
│
└── README.md                      # Documentation (this file)
```

---

## ⚙️ Technologies Used

| Category   | Technology                   |
| ---------- | ---------------------------- |
| Language   | Java (JDK 17+)               |
| Database   | MySQL                        |
| Connection | JDBC (MySQL Connector/J)     |
| UI         | Console-based text menus     |
| Tools      | IntelliJ / Eclipse / VS Code |

---

## 🗃️ Database Setup

### 1️⃣ Create the Database

```sql
CREATE DATABASE bank_db;
USE bank_db;
```

### 2️⃣ Create Accounts Table

```sql
CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(15) UNIQUE NOT NULL,
    address VARCHAR(255),
    account_number BIGINT UNIQUE NOT NULL,
    balance DECIMAL(15,2) DEFAULT 0.00
);
```

### 3️⃣ Create Manager Table (Optional)

```sql
CREATE TABLE managers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO managers (username, password) VALUES ('admin', '12345');
```

---

## 🔌 Configure Database Connection

Edit **`DatabaseConnection.java`**:

```java
private static final String URL = "jdbc:mysql://localhost:3306/bank_db?serverTimezone=UTC";
private static final String USER = "root";              // your MySQL username
private static final String PASSWORD = "your_password"; // your MySQL password
```

---

## ▶️ Running the Project

### ✅ Option 1: Using an IDE (Recommended)

1. Open project in IntelliJ / Eclipse / VS Code.
2. Make sure MySQL is running.
3. Update credentials in `DatabaseConnection.java`.
4. Run `Main.java`.

### 💻 Option 2: Using Command Line

```bash
dir lib
javac -encoding UTF-8 -cp "lib/mysql-connector-j-9.5.0.jar" -d bin src/main/*.java
java -cp "bin;lib/mysql-connector-j-9.5.0.jar" main.Main
```

---

## 🧠 Program Flow

```
Start → Main Menu → Choose Operation
```

---

## 🧰 Validation Rules

| Field   | Rule                             |
| ------- | -------------------------------- |
| Name    | Alphabets only, min 3 characters |
| Contact | Exactly 10 digits                |
| Address | Min 5 characters                 |
| Amount  | Must be positive                 |

---

## 🎨 Console Colors

| Type    | Method                     | Color |
| ------- | -------------------------- | ----- |
| Success | `Validator.printSuccess()` | Green |
| Error   | `Validator.printError()`   | Red   |
| Info    | `Validator.printInfo()`    | Blue  |

---

## 👨‍💻 Author

**Tushar Patil**
Java Developer
GitHub: [https://github.com/tushar0945](https://github.com/tushar0945)

---
  
