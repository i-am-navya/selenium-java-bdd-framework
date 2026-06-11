# Selenium Java BDD Framework

A Page Object Model test automation framework built with Selenium WebDriver, 
Java, Cucumber BDD, and TestNG. Tests run automatically on every push via GitHub Actions CI.

## Tech Stack
- Selenium WebDriver 4.25
- Cucumber BDD 7.18 (Gherkin)
- TestNG
- Maven
- Allure Reports
- GitHub Actions CI
- Java 17

## Test Coverage
- Login: valid login, invalid credentials, locked out user
- Cart: add item, remove item, navigate to checkout
- Checkout: complete purchase, missing field validations

## How to Run Locally
```bash
git clone https://github.com/i-am-navya/selenium-java-bdd-framework.git
cd selenium-java-bdd-framework
mvn test
```

## Framework Structure

```
src/test/java/
├── pages/          # Page Object Model classes
├── steps/          # Cucumber step definitions
├── runners/        # TestNG Cucumber runner
└── utils/          # WebDriver manager
src/test/resources/
└── features/       # Gherkin feature files
```

## CI Pipeline
Tests run automatically on every push to main via GitHub Actions.

## Save → push:
```bash
git add .
git commit -m "Add README"
git push origin main
```
