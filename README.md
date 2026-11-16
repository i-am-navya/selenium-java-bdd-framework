# Selenium Java BDD Framework

![CI](https://github.com/i-am-navya/selenium-java-bdd-framework/actions/workflows/ci.yml/badge.svg)

A UI test automation framework built with Selenium WebDriver, Java, Cucumber BDD and TestNG,
using the Page Object Model. It tests the login, cart and checkout flows of
[SauceDemo](https://www.saucedemo.com), a demo e-commerce site, with both positive and
negative scenarios. Tests run automatically on every push and pull request through GitHub Actions.

## Tech Stack

| Tool | Purpose |
|---|---|
| Selenium WebDriver 4.25 | Browser automation |
| Cucumber 7.18 (Gherkin) | BDD feature files in plain English |
| TestNG | Test execution and assertions |
| Java 17 | Core language |
| Maven | Build and dependency management |
| WebDriverManager | Sets up the matching ChromeDriver automatically |
| Allure | Test reporting, with screenshots on failure |
| GitHub Actions CI | Automated pipeline on every push and pull request |

## Test Coverage

### Login (3 scenarios)
- Successful login with valid credentials
- Failed login with invalid credentials - verify error message
- Failed login with a locked out user - verify error message

### Cart (3 scenarios)
- Add item to cart - verify cart badge count
- Remove item from cart - verify cart is empty
- Navigate from cart to checkout

### Checkout (3 scenarios)
- Complete a successful purchase - verify confirmation message
- Missing first name - verify validation error
- Missing postal code - verify validation error

**Total: 9 scenarios (5 positive, 4 negative)**

## Framework Design

- **Page Object Model:** one class per page holds its locators and actions, so a changed
  locator is updated in one place only
- **Stable locators:** `id` and `data-test` attributes, which do not change with UI redesigns
- **Explicit waits:** `WebDriverWait` with `visibilityOfElementLocated` before reading text,
  `elementToBeClickable` before clicking, and `urlContains` for page load checks.
  No fixed sleeps in normal runs
- **Independent scenarios:** a fresh browser is opened before each scenario and quit after it
- **Screenshot on failure:** captured in the `@After` hook and attached to the Allure report
- **Headless mode** for CI, and an optional slow mode for demos

## Framework Structure

```
src/test/java/
├── pages/                    # Page Object Model classes
│   ├── LoginPage.java
│   ├── InventoryPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
├── steps/                    # Cucumber step definitions and hooks
│   ├── LoginSteps.java
│   ├── CartSteps.java
│   ├── CheckoutSteps.java
│   └── Hooks.java            # Browser setup/teardown, screenshot on failure
├── runners/
│   └── TestRunner.java       # Cucumber + TestNG runner
└── utils/
    └── DriverManager.java    # WebDriver setup, Chrome options, headless mode
src/test/resources/
└── features/                 # Gherkin feature files
    ├── login.feature
    ├── cart.feature
    └── checkout.feature
```

## How to Run

### Prerequisites
- Java 17
- Maven
- Google Chrome

### Run all tests
```bash
git clone https://github.com/i-am-navya/selenium-java-bdd-framework.git
cd selenium-java-bdd-framework
mvn test
```

### Run in headless mode (no browser window)
```bash
mvn test -Dheadless=true
```

### Run in slow mode (pauses between steps, for demos)
```bash
mvn test -Dslow=true
```

### View the Allure report
```bash
allure serve target/allure-results
```

## CI Pipeline

GitHub Actions runs the full suite on every push and pull request to `main`:
1. Sets up Java 17 and Chrome on an Ubuntu runner
2. Runs `mvn test -Dheadless=true`
3. Uploads the Allure results as a build artifact, even when tests fail

## Planned Improvements
- Scenario Outline with Examples tables for data-driven login tests
- Tags (`@smoke`, `@regression`) to run subsets of the suite
- ThreadLocal WebDriver to support parallel execution
