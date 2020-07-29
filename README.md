Spring Boot Swing Reservations
---------------------------------------------

This project is a Spring Boot + JPA/Hibernate Swing application.

It contains some useful configuration things:

- Spring Boot
- Spring Data Repositories
- JPA + Hibernate
- Internationalization
- Swing application
- Liquibase
- Lombok
- Docker Compose

Requirements
---------------------------------------------
- OpenJDK 11 (https://openjdk.java.net/projects/jdk/11/)
- Docker (https://www.docker.com/products/docker-desktop)

How to run application
---------------------------------------------
On Windows
```bash
## Run PostgreSQL database by docker compose
cd docker/dependencies
start.sh

## Build application from base directory using Maven Wrapper
cd ../..
mvnw.cmd clean install

## Run Spring boot application with PostgreSQL database
mvnw.cmd spring-boot:run
```

On MacOS/ Linux
```bash
## Run PostgreSQL database by docker compose
cd docker/dependencies
./start.sh

## Build application from base directory using Maven Wrapper
cd ../..
./mvnw clean install

## Run Spring boot application with PostgreSQL database
./mvnw spring-boot:run
```

Database access
---------------
```
jdbc-url: jdbc:postgresql://localhost:5432/reservations
username: reservations_user
password: reservations_psw
```

Video
-----

[![Spring Boot Swing Reservations](http://img.youtube.com/vi/Z8iBbVGTSx8/0.jpg)](http://www.youtube.com/watch?v=Z8iBbVGTSx8 "Spring Boot Swing Reservations")

Screens
---------------------------------------------

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/db_schema.png "Screen 1")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/spring_boot.png "Screen 2")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/forms.png "Screen 3")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/form1.png "Screen 4")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/form2.png "Screen 5")

![alt text](https://github.com/DanielMichalski/spring-boot-swing-reservations/blob/master/src/main/resources/images/reports.png "Screen 6")
