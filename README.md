# Spring Boot Swing Reservations

Spring Boot Swing Reservations is a desktop application built on Java 17, Spring Boot 3, JPA/Hibernate, Docker, and Java Swing. \
It shows how to integrate the Java Swing library with Spring Boot.

[![Spring Boot Swing Reservations](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/gifs/application.gif)](https://youtu.be/E7ho0qdWhus "Spring Boot Swing Reservations")

[![Build Status](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/actions?query=workflow%3A%22Java+CI+with+Maven%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/LICENSE)

## Documentation

The documentation is divided into several sections:

* [Prerequisites](#prerequisites)
* [Libraries](#libraries)
* [Running the application](#running-the-application)
    * [On Windows](#on-windows)
    * [On MacOS/ Linux](#on-macos-linux)
* [Database connection parameters](#database-connection-parameters)
* [Video presentation](#video-presentation)
* [Screenshots](#screenshots)

## Prerequisites

- [Java JDK](https://www.oracle.com/pl/java/technologies/javase-downloads.html) version 17+
- [Docker Desktop](https://www.docker.com/products/docker-desktop)

## Libraries

| Library name                                                                                                     | Description                                                                                                                                            |
|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Spring Boot 3](https://spring.io/projects/spring-boot)                                                          | Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".                                   |
| [Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories) | The JPA module of Spring Data contains a custom namespace that allows defining repository beans.                                                       |
| [JPA (Hibernate)](https://hibernate.org/)                                                                        | Hibernate ORM enables developers to more easily write applications whose data outlives the application process.                                        |
| [Swing](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)                              | Provides a set of "lightweight" (all-Java language) components that, to the maximum degree possible, work the same on all platforms.                   |
| [Liquibase](https://www.liquibase.org/)                                                                          | Liquibase Community is an open source project that helps millions of developers rapidly manage database schema changes.                                |
| [Lombok](https://projectlombok.org/)                                                                             | Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.                                      |
| [Docker Compose](https://docs.docker.com/compose/)                                                               | Compose is a tool for defining and running multi-container Docker applications.                                                                        |
| [Checkstyle](https://checkstyle.sourceforge.io/)                                                                 | Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard.                                                |
| [PMD](https://pmd.github.io/)                                                                                    | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. |

## Running the application

#### On Windows

```bash
## Run PostgreSQL database on Docker
docker-compose up -d

## Build application using Maven Wrapper
mvnw.cmd clean install

## Run Spring boot application using Maven Wrapper or simply run Application class
mvnw.cmd spring-boot:run
```

#### On MacOS/ Linux

```bash
## Run PostgreSQL database on Docker
docker-compose up -d

## Build application using Maven Wrapper
./mvnw clean install

## Run Spring boot application using Maven Wrapper or simply run Application class
./mvnw spring-boot:run
```

## Database connection parameters

| JDBC URL                                      | Username         	 | Password         |
|-----------------------------------------------|--------------------|------------------|
| jdbc:postgresql://localhost:5555/reservations | reservations_user  | reservations_psw |

## Video presentation

[![Spring Boot Swing Reservations](http://img.youtube.com/vi/E7ho0qdWhus/0.jpg)](https://youtu.be/E7ho0qdWhus "Spring Boot Swing Reservations")

## Screenshots

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/db_schema.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/spring_boot.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/forms.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/form1.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/form2.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/.github/images/reports.png "Screen 6")
