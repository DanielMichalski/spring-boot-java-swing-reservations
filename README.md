Spring Boot Swing Reservations
---------------------------------------------
[![Build Status](https://github.com/DanielMichalski/spring-boot-swing-reservations/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/DanielMichalski/spring-boot-swing-reservations/actions?query=workflow%3A%22Java+CI+with+Maven%22)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This project aims to present how to create a Spring Boot + JPA/Hibernate Swing application.

Libraries
---------------------------------------------
- Spring Boot 2
- Spring Data Repositories
- JPA (Hibernate)
- Swing
- Liquibase
- Lombok
- Docker Compose
- Checkstyle

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
```
jdbc-url: jdbc:postgresql://localhost:5555/reservations
username: reservations_user
password: reservations_psw
```

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
