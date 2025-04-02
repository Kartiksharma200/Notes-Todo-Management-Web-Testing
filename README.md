# Notes-Todo Management Web Testing

**Overview**

Notes-Todo Management Web Testing is a manual and automation testing project designed to validate the functionality, security, and performance of the Notes & Todo Management web application. The project leverages Selenium WebDriver, TestNG, and the Page Object Model (POM) for automated testing, while also incorporating manual testing methodologies based on a structured test plan and test summary.

## Features

- Automated UI Testing using Selenium WebDriver & TestNG

- Manual Testing with well-defined test scenarios & test cases

- Functional, Regression, and UI Testing

- Bug Tracking & Reporting

- Test Execution Reports with Extent Reports & TestNG Reports

## Technologies Used

- Programming Language: Java

- Automation Framework: Selenium WebDriver, TestNG

- Build Tool: Maven

- Version Control: GitHub

- Reporting: Extent Reports, TestNG Reports

- API Testing: Postman, Rest Assured

# Project Structure
~~~
kartiksharma200-notes-todo-management-web-testing/
├── README.md
├── pom.xml
├── testng.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           ├── pageObjects/
│   │           │   ├── dashboardPage.java
│   │           │   ├── loginPage.java
│   │           │   └── signupPage.java
│   │           └── utils/
│   │               └── driverManager.java
│   └── test/
│       └── java/
│           └── com/
│               └── tests/
│                   ├── e2eTesting.java
│                   ├── LoginTest.java
│                   └── SignupTest.java
└── test-output/
    ├── emailable-report.html
    ├── index.html
    ├── testng-failed.xml
    ├── testng-results.xml
    ├── Default suite/
    └── junitreports/
~~~
## Installation & Setup

**Prerequisites**

Ensure you have the following installed:

- Java JDK 8+

- Maven

- TestNG Plugin (for IDE support)

- Selenium WebDriver

# Git

**Clone the Repository**
~~~
git clone https://github.com/Kartiksharma200/Notes-Todo-Management-Web-Testing.git
cd Notes-Todo-Management-Web-Testing
~~~
# Running Tests

**Running Automated Tests**

To execute all test cases using TestNG, run:
~~~
mvn clean test
~~~
This will trigger the tests as per the testng.xml file.

**Running Specific Tests**

To run a particular test class, use:
~~~
mvn test -Dtest=LoginTest
~~~

# Viewing Test Reports

- Test Reports are available in the test-output/ directory:

 - emailable-report.html → Summary report

 - testng-results.xml → XML test results

 - index.html → Detailed execution report

# Manual Testing

- Test Plan & Execution

- Functional Testing: Validates core features like login, signup, and dashboard functionalities.

- UI Testing: Ensures the web interface is user-friendly and accessible.

- Regression Testing: Ensures system stability after updates.

- Defect Reporting: Issues are logged and tracked for resolution.

# Contribution Guidelines

- Fork the repository and create a new branch for your changes.

- Submit a pull request with a detailed description.

- Follow best testing practices for manual and automation testing.

# License

This project is licensed under the MIT License - see the LICENSE file for details.
