Spring Boot Swing Reservations
---------------------------------------------
[![Build Status](https://github.com/DanielMichalski/spring-boot-swing-reservations/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/DanielMichalski/spring-boot-swing-reservations/actions?query=workflow%3A%22Java+CI+with+Maven%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/LICENSE)

This project aims to present how to create a Spring Boot + JPA/Hibernate Java Swing application.

Libraries
---------------------------------------------
- [Spring Boot 2](https://spring.io/projects/spring-boot)
- [Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories)
- [JPA (Hibernate)](https://hibernate.org/)
- [Swing](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)
- [Liquibase](https://www.liquibase.org/)
- [Lombok](https://projectlombok.org/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Checkstyle](https://checkstyle.sourceforge.io/)
- [FindBugs](http://findbugs.sourceforge.net/)

| Library name                                            | Description                                                                                                          |
|-------------------------------------------------------- |--------------------------------------------------------------------------------------------------------------------- |
| [Spring Boot 2](https://spring.io/projects/spring-boot) | Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". |
The JPA module of Spring Data contains a custom namespace that allows defining repository beans. It also contains certain features and element attributes that are special to JPA.

| Library name                                                                                                     | Description                                                                                                          |
|------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| [Spring Boot 2](https://spring.io/projects/spring-boot)                                                          | Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". |
| [Spring Data Repositories](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories) |                                                                                                                      |
| [JPA (Hibernate)](https://hibernate.org/)                                                                        |                                                                                                                      |
| [Swing](https://docs.oracle.com/javase/8/docs/api/javax/swing/package-summary.html)                              |                                                                                                                      |
| [Liquibase](https://www.liquibase.org/)                                                                          |                                                                                                                      |
| [Lombok](https://projectlombok.org/)                                                                             |                                                                                                                      |
| [Docker Compose](https://docs.docker.com/compose/)                                                               |                                                                                                                      |
| [Checkstyle](https://checkstyle.sourceforge.io/)                                                                 |                                                                                                                      |
| [FindBugs](http://findbugs.sourceforge.net/)                                                                     |                                                                                                                      |                                                             |                                                  |

Requirements
---------------------------------------------
- [Java JDK](https://www.oracle.com/pl/java/technologies/javase-downloads.html) version 8+
- [Docker Desktop](https://www.docker.com/products/docker-desktop) 

How to run application
---------------------------------------------
On Windows
```bash
## Run PostgreSQL database on Docker
cd .docker/dependencies
start.sh

## Build application from base directory using Maven Wrapper
cd ../..
mvnw.cmd clean install

## Run Spring boot application using Maven Wrapper or simly run Application class
mvnw.cmd spring-boot:run
```

On MacOS/ Linux
```bash
## Run PostgreSQL database on Docker
cd .docker/dependencies
./start.sh

## Build application from base directory using Maven Wrapper
cd ../..
./mvnw clean install

## Run Spring boot application using Maven Wrapper or simly run Application class
./mvnw spring-boot:run
```

Database access
---------------

| JDBC URL                                      | Username         	| Password         |
|----------------------------------------------	|------------------	|----------------- |
| jdbc:postgresql://localhost:5555/reservations | reservations_user | reservations_psw |

Video
-----

[![Spring Boot Swing Reservations](http://img.youtube.com/vi/E7ho0qdWhus/0.jpg)](https://youtu.be/E7ho0qdWhus "Spring Boot Swing Reservations")

Screens
---------------------------------------------

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/db_schema.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/spring_boot.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/forms.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/form1.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/form2.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/reports.png "Screen 6")
