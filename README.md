Project Title: Tendable.com

Description:

This project automates testing of Tendable Application using the Page Object Model (POM) design pattern. It leverages TestNG for test execution.

Key Features:

POM Implementation: Separates page objects (locators and methods) from test cases for improved maintainability.
TestNG Framework: Utilizes TestNG for test execution.
Smart Waits: Employs explicit waits for page elements to enhance test reliability.
Error Handling: Includes try-catch blocks and assertions for robust error handling.
Prerequisites:

Java Development Kit (JDK) 1.7 or later
Maven (for dependency management)
Selenium WebDriver
TestNG
Setup:

Clone the repository: git clone
Configure project dependencies using Maven.
Set up your test environment (browser, drivers, etc.).
Execution:

Compile the project.
Run the TestNG suite using the testng.xml file.
Directory Structure:

src/
  test/java/
      Objects/
        ContactUsPageSearch.java
        TendableSearch.java
  test/java/
    TestSce/
      TestMethod_TendableSearch.java
How to Use:

Modify page objects in the Objects package to reflect the application's UI elements.
Create test cases in the TestSce package, utilizing methods from page objects.
Customize the testng.xml file to define test suites and groups.
