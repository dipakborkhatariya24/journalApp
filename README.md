# 📝 Journal App

A full-stack **Spring Boot** REST API application for managing personal journal entries, integrated with **MongoDB**, **Redis caching**, and **JWT-based authentication**. It also features **weather API integration**, user management, **OAuth2 Google login**, and admin operations.

---

## 🚀 Features

### 🗃️ Journal Management
- Add new journal entries
- View all entries or by ID
- Update or delete entries
- Stores data in **MongoDB**

### 👥 User Management
- Signup & Login (including Google OAuth login)
- JWT-based authentication
- Role-based access (User/Admin)
- Delete user functionality

### 🛠️ Admin Tools
- View all registered users
- Clear application cache
- Add new admins

### 🌦️ Weather API Integration
- Fetches and stores current weather during journal creation
- Caches API keys and config via Redis and local in-memory cache

### 🔐 OAuth2 with Google
- Users can login using their **Google accounts**
- Google profile info is securely extracted and stored
- OAuth2 flow integrated using **Spring Security** and `spring-security-oauth2-client`
- Requires `client-id` and `client-secret` from Google Developer Console

### ⚙️ Tech Stack
| Layer        | Technology          |
|--------------|---------------------|
| Backend      | Spring Boot         |
| Database     | MongoDB             |
| Cache        | Redis, AppCache     |
| Auth         | Spring Security, JWT, OAuth2 |
| Scheduler    | Spring Scheduler    |
| API Client   | RestTemplate        |
| Dev Tools    | Postman, Maven      |

---

## 📁 API Endpoints (as seen in Postman)

### 📓 `/journal`
- `GET /journal` – Get all journal entries
- `GET /journal/{id}` – Get journal entry by ID
- `POST /journal` – Add new journal entry
- `PUT /journal/{id}` – Update existing entry
- `DELETE /journal/{id}` – Delete entry

### 👤 `/user`
- `GET /user/greeting` – Greeting message (auth protected)
- `DELETE /user/{id}` – Delete user

### 🌐 `/public`
- `GET /health-check` – Check API status
- `POST /signup` – Register new user
- `POST /login` – Login with email/password
- `GET /google-login` – Login with Google

### 🔐 `/admin`
- `GET /admin/users` – View all users
- `GET /admin/clear-cache` – Clear Redis/app cache
- `GET /admin/add-admin` – Promote user to admin

---

## 🧠 Concepts Used

- ✅ REST API architecture
- ✅ DTO vs Entity separation
- ✅ MongoDB transactions via `MongoTransactionManager`
- ✅ RedisTemplate configuration
- ✅ JWT Authentication & Authorization
- ✅ Google OAuth2 Authentication
- ✅ Custom Exception Handling
- ✅ Application-level caching with `AppCache`
- ✅ Weather API consumption using `RestTemplate`
- ✅ Scheduled Tasks via `@Scheduled`
- ✅ Environment-based configuration

---

## 🛠️ Installation & Run

```bash
# Clone the repo
git clone https://github.com/dipakborkhatariya24/journalApp.git
cd journalApp

# Build the project
./mvnw clean install

# Run the project
./mvnw spring-boot:run
```

> 🔐 **Make sure to configure `application.properties` or `application.yml` with:**
> - MongoDB URI
> - Redis host/port
> - JWT secret
> - Weather API Key
> - Google OAuth2 `client-id` and `client-secret`

---

## ✅ Prerequisites

- Java 17+
- Maven 3.6+
- MongoDB running locally or on cloud
- Redis Server (optional for cache)
- Google Cloud OAuth2 credentials

---

## 🧪 Testing

```bash
# Run all unit tests
./mvnw test
```

---

## 📌 Folder Structure

```
journalApp/
├── controller/        # REST controllers
├── service/           # Business logic
├── entity/            # MongoDB entities
├── dto/               # Data Transfer Objects
├── Repository/        # MongoDB repositories
├── config/            # Security, Redis, Scheduling config
├── Scheduler/         # Cron jobs
├── filter/            # JWT and request filters
├── utils/             # Common utilities
├── cache/             # Application-level caching
└── JournalApplication.java  # Main class
```

---

## 📫 Contact

**Dipak Borkhatariya**  
🔗 [LinkedIn](https://www.linkedin.com/in/dipak-borkhatariya)  
💻 [GitHub](https://github.com/dipakborkhatariya24)  

---

## 📃 License

This project is licensed under the MIT License - see the `LICENSE` file for details.
