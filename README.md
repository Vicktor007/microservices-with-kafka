<div align="center">

  <h3 align="center"> Spring boot microservices application with Spring Cloud, Keycloak, Kafka and Zipkin</h3>

</div>

## 📋 <a name="table">Table of Contents</a>

1. 🤖 [Introduction](#introduction)
2. ⚙️ [Tech Stack](#tech-stack)
3. 🔋 [Features](#features)
4. 🤸 [Quick Start](#quick-start)







## <a name="introduction">🤖 Introduction</a>

A **springboot microservices API** that handles **users, products, order logic and notifications using kafka**.

Authenticates users using keycloak, connects different databases both sql and noSql, creates models and schemas, integrating  them with the necessary ORMs and Structuring the architecture  of the APIs to ensure scalability and seamless communication with each other.


## <a name="tech-stack">⚙️ Tech Stack</a>

- Java
- Springboot
- Keycloak
- MongoDB
- mySql
- PostgreSql
- flyway
- Docker
- Apache kafka
- Zipkin

## <a name="features">🔋 Features</a>

👉 **Rate Limiting**: with resilience4j that helps you secure the whole app.

👉 **Database Modeling**: Models and relationships using MongoDB mySql and PosgreSql.

👉 **Keycloak Authentication**: For application security.

👉 **Global Error Handling**: To catch any issue that may arise.

👉 **Distributed Tracing**: For better debugging and monitoring using Zipkin.

👉 **Email Notifications**: Sending email notifications and seamless communication with other microservices with apache kafka.

and many more, including code architecture and reusability

## <a name="quick-start">🤸 Quick Start</a>

Follow these steps to set up the project locally on your machine.

**Prerequisites**

Make sure you have the following installed on your machine:

- [Git](https://git-scm.com/)
- Java 11 or higher
- Spring Boot 3.x
- Maven or Gradle
- JDK and IDE setup (e.g., IntelliJ IDEA, Eclipse)

```bash
git clone https://github.com/Vicktor007/microservices-with-kafka.git
cd microservices-with-kafka
```

**Installation**

Install the project dependencies using maven:

```bash
mvn install 
```

or open in intelliJ IDEA ide


**Set Up Environment Variables**

Configure application properties: In the config-server/src/main/resources/configurations folder and docker-compose.yml file, configure your database and other environment variables for each microservice.

you have to change keycloak,  mongodb, postgres and mysql database credentials.




**Running the Project**

run
```bash
 Docker compose up -d
```
to pull the docker images of the databases, kafka and zipkin specified in the docker-compose.yml file in detached mode

then

Run each microservice, starting with the config server, next is the discovery server and the other applications follow. Gateway server should be the last you run because it has to sense all the other servers if they are on.
```bash
cd to each microservice
```

```bash
mvn spring-boot:run each microservice

```

or run each microservice with intelliJ IDEA ide

Open [http://localhost:8222](http://localhost:8222) in your browser or any HTTP client to test the project.

