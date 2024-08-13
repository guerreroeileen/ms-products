# ms-products
This is an E-commerce API built with Spring Boot, featuring Swagger for API documentation, PostgreSQL as the database, and Redis for caching. The API provides endpoints for managing categories and products.

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Documentation](#documentation)

## Getting Started

Follow these instructions to set up and run the project on your local machine for development and testing purposes.

## Prerequisites

- Java 22
- Gradle
- PostgreSQL
- Redis

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/ms-products.git
   cd ms-products

2. Install dependencies

    ```sh
    ./gradlew build

3. Set up PostgreSQL:

   - Create a database named `products`.
   - Update the `application.properties` file with your database credentials.

4. Set up Redis:
   
   Ensure Redis is installed and running on your machine.

## Documentation
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
