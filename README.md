# JobFinder API

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

**Web API and database** with **Spring**.

## Table of Contents

- [Background](#background)
- [Usage](#local-running)
- [Suggestions](#suggestions-for-improvement)
- [Maintainers](#maintainers)

## Background

This application implements a job search platform that allows clients to register and post job listings, and users to search for jobs.
Application uses the Spring framework and uses H2, an in-memory database, for development and testing purposes, and PostgreSQL for production data storage.

## API endpoints

#### Client

- **POST** /api/client - Add new client

#### Position

- **GET** /api/position - Get all positions
- **GET** /api/position/:positionId - Get position by ID
- **POST** /api/position - Add new position
- **POST** /api/position/search - Get specific position(s)


## Local running

1. Install: IntelliJ/Eclipse , JavaSDK , PostgreSQL
2. Clone the project repository: https://github.com/olah-adam93/JobFinder.git
3. Create a postgres database named **jobFinder** and set password **postgres**
4. Install dependencies
5. Run the application by the main method from **src/main/java/com/example/jobFinder/JobFinderApplication.java**
6. Local pages:
- H2: http://localhost:8080/h2-console/
- Swagger: http://localhost:8080/swagger-ui/

## Suggestions for improvement

- **Testing:** Implement both unit and integration tests to ensure the application functions correctly and to catch bugs early in the development process.
- **Key-storage** The API key should be stored in an encoded way.
- **Maintenance** Both clients and positions should be deletable if they are inactive or if, for example, the position has been filled and is no longer relevant.
- **Security** Spring Security would also be a good way to secure the app.
- **Continuous Integration and Deployment:** Set up a CI/CD pipeline to automate the build, test, and deployment process, making it easier to release updates and fixes.

## Maintainer
- [Adam Olah](https://github.com/olah-adam93)