# REST Assured API Testing Framework

![CI](https://github.com/i-am-navya/rest-assured-api-framework/actions/workflows/ci.yml/badge.svg)

A REST API test automation framework built with REST Assured, Java, TestNG and Maven.
Covers GET, POST, and nested resource endpoints with response validation,
schema checks, response time assertions, and negative test cases.

## Tech Stack

| Tool | Purpose |
|---|---|
| REST Assured 5.4 | API test automation |
| Java 17 | Core language |
| TestNG | Test execution and assertions |
| Maven | Build and dependency management |
| Allure | Test reporting |
| GitHub Actions CI | Automated pipeline on every push |

## Test Coverage

### GET Posts (7 tests)
- Get all posts and verify count and structure
- Get single post by ID
- Get post with invalid ID - verify 404
- Verify response time under 2 seconds
- Filter posts by userId query parameter
- Verify Content-Type response header
- Validate response structure against a JSON schema

### POST - Create Posts (4 tests)
- Create new post and verify 201 response
- Create post with missing fields
- Verify response time under 3 seconds
- Extract and validate new post ID from response

### Users (6 tests)
- Get all users and verify count and structure
- Get single user by ID and verify fields
- Verify email format across all users
- Get user with invalid ID - verify 404
- Verify nested address object fields
- Get posts for a specific user

**Total: 17 tests, 0 failures**

## Framework Structure

```
src/test/java/
├── tests/
│   ├── GetPostsTest.java       - GET endpoint tests
│   ├── CreatePostTest.java     - POST endpoint tests
│   └── UsersTest.java          - Users endpoint tests
└── utils/
    └── ApiConfig.java          - Base configuration and reusable specs

src/test/resources/
└── schemas/
    └── post-schema.json        - JSON schema for a single post
```

## How to Run

### Prerequisites
- Java 17
- Maven 3.9+

### Clone and Run

```bash
git clone https://github.com/i-am-navya/rest-assured-api-framework.git
cd rest-assured-api-framework
mvn test
```

## API Under Test

This framework tests [JSONPlaceholder](https://jsonplaceholder.typicode.com) -
a free public REST API used for testing and prototyping. It simulates a real
REST API with posts, users, comments, and nested resources.

## Design Patterns Used

- **Reusable Request/Response Specifications** - shared base config across all tests
- **Given/When/Then BDD style** - readable, self-documenting test structure
- **Negative testing** - invalid IDs, missing fields, boundary conditions
- **Response time assertions** - performance validation on every endpoint
- **Request/Response logging** - automatic logging on test failure

## Author

Navya Zacharia
[LinkedIn](https://linkedin.com/in/navya-zacharia-0853621ba) |
[GitHub](https://github.com/i-am-navya)