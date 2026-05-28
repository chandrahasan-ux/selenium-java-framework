# 🧪 Selenium Java Automation Framework

A professional, production-ready QA automation framework built with **Selenium WebDriver**, **TestNG**, and **Maven** using the **Page Object Model (POM)** design pattern.

---

## 🛠️ Tech Stack

| Tool | Purpose |
|------|---------|
| Java 11 | Programming language |
| Selenium WebDriver 4.x | Browser automation |
| TestNG | Test management & assertions |
| Maven | Build tool & dependency management |
| WebDriverManager | Auto ChromeDriver management |
| ExtentReports | HTML test reports |
| Log4j2 | Logging |
| Apache POI | Data-driven testing (Excel) |
| Page Object Model | Design pattern |

---

## 📁 Project Structure

```
selenium-java-framework/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseClass.java          # WebDriver setup & teardown
│   │   ├── pages/
│   │   │   ├── HomePage.java           # Wikipedia Home Page POM
│   │   │   ├── SearchResultsPage.java  # Search Results Page POM
│   │   │   └── ArticlePage.java        # Article Page POM
│   │   └── utils/
│   │       ├── ConfigReader.java        # Reads config.properties
│   │       ├── LoggerUtil.java          # Log4j2 logger wrapper
│   │       ├── ScreenshotUtil.java      # Captures screenshots on failure
│   │       └── ExtentReportListener.java# Auto HTML report generator
│   └── test/
│       ├── java/tests/
│       │   ├── HomePageTest.java        # Home page test cases
│       │   └── SearchTest.java          # Search functionality tests
│       └── resources/
│           ├── testng.xml              # TestNG suite configuration
│           ├── config.properties       # App URL, browser, timeout config
│           └── log4j2.xml             # Logging configuration
└── pom.xml                            # Maven dependencies & plugins
```

---

## ✅ Test Cases Covered

### Home Page Tests
- Verify home page loads successfully
- Verify Wikipedia logo is displayed
- Verify search box is functional
- Verify search results page title

### Search Functionality Tests
- Verify valid search returns results
- Verify first result title is not empty
- Data-driven search with multiple keywords
- Verify clicking first result opens article
- Verify article heading after navigation

---

## 🚀 How to Run

### Prerequisites
- Java 11+
- Maven 3.6+
- Google Chrome (latest)

### Run all tests
```bash
mvn clean test
```

### Run specific test class
```bash
mvn clean test -Dtest=HomePageTest
```

### Run in headless mode
Set `headless=true` in `src/test/resources/config.properties`

---

## 📊 Reports

After test execution, HTML reports are auto-generated at:
```
test-output/reports/ExtentReport_<timestamp>.html
```

Screenshots on failure are saved at:
```
test-output/screenshots/
```

Logs are saved at:
```
logs/automation.log
```

---

## 👨‍💻 Author

**Chandrahasan Jayakumar**  
QA Automation Engineer | Accenture  
📧 chandrahasan0609@gmail.com  
🐙 [github.com/chandrahasan-ux](https://github.com/chandrahasan-ux)
