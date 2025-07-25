# JournalApp

> A Spring Boot-based Java application for managing personal journal entries with a secure and scalable architecture.

![Java](https://img.shields.io/badge/Java-17+-red.svg)

---

## ✨ Features

- Create, read, update, and delete journal entries.
- User authentication & authorization.
- RESTful APIs with structured responses.
- Input validation with meaningful error messages.
- OpenAPI/Swagger documentation for API exploration.
- Configurable database connectivity.
- Containerization support with Docker (optional).

---

## 🧱 Tech Stack

- **Language:** Java 17+
- **Frameworks & Libraries:**
  - Spring Boot (Web, Data JPA, Security)
  - Hibernate / JPA
  - Lombok
  - springdoc-openapi (Swagger)
- **Database:** MySQL or MongoDB (configurable)
- **Build Tool:** Maven (wrapper included)
- **Testing:** JUnit 5, Mockito
- **Version Control:** Git & GitHub

---

## 📂 Project Structure

```
journalApp
├── .github/workflows/          # CI pipelines (build/test)
├── .mvn/wrapper/               # Maven wrapper
├── src/
│   ├── main/
│   │   ├── java/com/dipakinfotech/journalApp/
│   │   │   ├── config/          # Security & config classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── repository/      # Spring Data repositories
│   │   │   └── service/         # Business logic services
│   │   └── resources/
│   │       ├── application.yml  # Application configuration
│   │       └── static/          # Static resources (if any)
│   └── test/
│       └── java/...             # Unit & integration tests
├── pom.xml
└── mvnw / mvnw.cmd
```

---

## 🚀 Getting Started

### Prerequisites

- **Java 17+**
- **Maven** (or use `./mvnw`)
- **MySQL/MongoDB** (as configured in `application.yml`)

---

### Configuration

Update `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/journaldb
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
server:
  port: 8080
```

---

### Running the Application

**Using Maven Wrapper:**

```bash
./mvnw spring-boot:run
```

**Building and Running JAR:**

```bash
./mvnw clean package
java -jar target/journalApp-0.0.1-SNAPSHOT.jar
```

---

## 📚 API Endpoints

| Method | Path                     | Description                |
|--------|--------------------------|----------------------------|
| GET    | `/api/v1/journals`       | List all journal entries   |
| POST   | `/api/v1/journals`       | Create a journal entry     |
| GET    | `/api/v1/journals/{id}`  | Fetch a journal entry      |
| PUT    | `/api/v1/journals/{id}`  | Update a journal entry     |
| DELETE | `/api/v1/journals/{id}`  | Delete a journal entry     |
| POST   | `/api/v1/auth/login`     | User login & token issue   |
| POST   | `/api/v1/auth/register`  | User registration          |

Swagger UI: `http://localhost:8080/swagger-ui/index.html`

---

## 🧪 Testing

```bash
./mvnw test
```

- Unit tests for services and utilities.
- Integration tests for controller and repository layers.

---

## 🏗 CI/CD

- GitHub Actions workflows under `.github/workflows` for build and testing.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Acknowledgements

- Spring Boot Community
- OpenAPI/Swagger contributors
