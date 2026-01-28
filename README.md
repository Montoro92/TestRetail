# TestRetail

Simple Spring Boot project that exposes a REST API to retrieve applicable prices for a product, following a **hexagonal (ports & adapters) architecture**.

## 🧩 Tech stack

* Java 21
* Spring Boot 3
* Spring Data JPA
* H2 (in‑memory DB for tests)
* Spring Security (basic setup, disabled in tests)
* Maven
* JUnit 5
* Checkstyle
* GitHub Actions (CI)

## 🏗️ Architecture

The project is structured using **Hexagonal Architecture**:

* **domain**: core business logic (entities, ports, use cases)
* **application**: use cases orchestration
* **adapters**:

  * `in`: REST controllers
  * `out`: JPA persistence adapters
* **infrastructure**: Spring/JPA configuration

This keeps business logic independent from frameworks.

## 🚀 API

### Get applicable price

`GET /api/prices`

Query params:

* `brand`
* `product`
* `date` (ISO‑8601)

Returns the applicable price or `404` if none is found.

## 🧪 Testing

The project includes several test layers:

* **Unit tests** (domain & application)
* **JPA tests** (`@DataJpaTest` with H2)
* **E2E tests** (`@SpringBootTest` + MockMvc, H2, no security filters)

Run tests locally:

```bash
mvn test
```

Run full verification (tests + checkstyle + e2e):

```bash
mvn verify
```

## 🔐 Security

* Basic Spring Security configuration
* Disabled in tests using `addFilters = false`
* No real authentication logic (kept simple on purpose)

## ✅ Code quality

* **Checkstyle** enabled with a simple ruleset
* Enforced during `mvn verify`

## 🤖 CI/CD

GitHub Actions pipeline runs on every push and PR to:

* `main`
* `develop`
* `retail-development`

Pipeline steps:

* Checkout code
* Setup JDK 21
* Run `mvn clean verify`

## 🐳 Running with Docker

The application can also be built and executed using Docker.

Build the image:

```bash
docker build -t test-retail .
```

Run the container:

```bash
docker run -p 8080:8080 test-retail
```

The API will be available at:

`http://localhost:8080/api/prices`

## 📝 Notes

This is a small, focused project intended to demonstrate:

* Clean architecture
* Proper testing strategy
* Basic CI/CD and code quality setup

It is intentionally kept simple and pragmatic.

The Docker image runs the application using the default Spring profile.

E2E tests are not executed in CI, as they are designed to be run against a Dockerized environment.

Local and CI builds only execute unit and integration (JPA) tests.
