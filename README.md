# 🚀 AutomationFullProject

---

## 📌 Overview

**AutomationFullProject** is a robust, enterprise-grade **Test Automation Framework** built using Java, Selenium WebDriver, and TestNG. Designed following the **Page Object Model (POM)** architecture, it delivers scalable, parallel, and maintainable automated web application testing.

---

## ⚡ Framework Highlights

* **🧱 Page Object Model (POM):** Clean separation between element locators, page actions, and test assertions.
* **📊 Interactive Reporting:** Automated **ExtentReports** generation complete with step logs and failure screenshots.
* **🧪 Data-Driven Architecture:** Externalized configuration and test parameters via `testng.xml` and property files.
* **⚡ Parallel Test Execution:** Multi-threaded test runner support for minimized suite execution times.
* **📸 Automatic Failure Diagnostics:** Captures and embeds screenshots directly into reports upon test failure.

---

## 🏗️ Architecture Design

```
AutomationFullProject/
├── src/
│   ├── main/java/
│   │   ├── pages/          # Web page elements and user action methods
│   │   └── utils/          # Driver setup, Wait utilities, Screenshot handlers
│   │
│   └── test/java/
│       ├── tests/          # Executable TestNG test cases
│       └── base/           # Base setup, driver instantiation, and teardown
│
├── target/                 # Generated test reports and execution artifacts
├── testng.xml              # Test suite suite & execution management
└── pom.xml                 # Maven dependencies and build plugins

```

---

## 🚀 Quick Start Guide

### Prerequisites

* **JDK 11+**
* **Apache Maven**
* **Eclipse**

### Setup & Run

1. **Clone the repository:**
```bash
git clone https://github.com/AmeersuhailTK/AutomationFullProject.git

```


2. **Navigate to project directory:**
```bash
cd AutomationFullProject

```


3. **Execute the test suite:**
```bash
mvn clean test

```



---

## 📈 Execution Reports

Upon test execution, view the generated HTML report at:
`target/ExtentReports/index.html`

---

## 👤 Author

* **Ameer Suhail** — *Quality Assurance & Test Automation Engineer*
* GitHub: [@AmeersuhailTK](https://github.com/AmeersuhailTK)
