# Spring Boot Swing Reservations
[![Build Status](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/actions?query=workflow%3A%22Java+CI+with+Maven%22)
[![CodeQL](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/workflows/CodeQL/badge.svg)](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/actions?query=workflow%3ACodeQL)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/LICENSE)

This project aims to present how to create and configure a Spring Boot + JPA/Hibernate Java Swing application.
The project is built using Java, Spring Boot and Swing libraries.

## Table of Contents
* [Prerequisites](#prerequisites)
* [Libraries](#libraries)
* [Running the application](#running-the-application)
    * [On Windows](#on-windows)
    * [On MacOS/ Linux](#on-macos-linux)
* [Database user](#database-user)
* [Video](#video)
* [Screens](#screens)

## Prerequisites
- [Java JDK](https://www.oracle.com/pl/java/technologies/javase-downloads.html) version 8+
- [Docker Desktop](https://www.docker.com/products/docker-desktop) 

## Libraries
| Library name                                                                                                     | Description                                                                                                                          |
|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| [Spring Boot 2](https://spring.io/projects/spring-boot)                                                          | Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".                 |
| [Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories) | The JPA module of Spring Data contains a custom namespace that allows defining repository beans.                                     |
| [JPA (Hibernate)](https://hibernate.org/)                                                                        | Hibernate ORM enables developers to more easily write applications whose data outlives the application process.                      |
| [Swing](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)                              | Provides a set of "lightweight" (all-Java language) components that, to the maximum degree possible, work the same on all platforms. |
| [Liquibase](https://www.liquibase.org/)                                                                          | Liquibase Community is an open source project that helps millions of developers rapidly manage database schema changes.              | 
| [Lombok](https://projectlombok.org/)                                                                             | Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.                    |
| [Docker Compose](https://docs.docker.com/compose/)                                                               | Compose is a tool for defining and running multi-container Docker applications.                                                      |
| [Checkstyle](https://checkstyle.sourceforge.io/)                                                                 | Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard.                              |
| [FindBugs](http://findbugs.sourceforge.net/)                                                                     | FindBugs is a development tool which uses static analysis to look for bugs in Java code.                                             |

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

## Database user
| JDBC URL                                      | Username         	| Password         |
|----------------------------------------------	|------------------	|----------------- |
| jdbc:postgresql://localhost:5555/reservations | reservations_user | reservations_psw |

## Video
[![Spring Boot Swing Reservations](http://img.youtube.com/vi/E7ho0qdWhus/0.jpg)](https://youtu.be/E7ho0qdWhus "Spring Boot Swing Reservations")

## Screens
![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/db_schema.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/spring_boot.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/forms.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/form1.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/form2.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-boot-java-swing-reservations/blob/master/src/main/resources/images/reports.png "Screen 6")
