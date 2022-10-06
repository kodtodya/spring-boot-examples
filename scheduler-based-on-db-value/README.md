# Spring Boot scheduler based on db value example: Building scheduler with Spring Data JPA

In this example, we're going to see how to write scheduler base on cron preset in database using Spring Boot Rest JPA CRUD API with Maven that use Spring Data JPA to interact with H2 database.

You'll know:

- How to configure Spring Data, JPA, Hibernate to work with Database
- How to define Data Models and Repository interfaces
- Way to create Spring Rest Controller to process HTTP requests
- Way to use Spring Data JPA to interact with H2 Database
- Way to use scheduler works

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 2.7.4
    Spring - 5.3.23
    Lombok - 1.18.24

### Building

The example can be built with

    mvn clean install

## Run Spring Boot application

Run application as spring boot app or using command line -> `mvn spring-boot:run`

## Till this point, you won't find any difference as same data you inserted will be visible

Now, lets go to Database and check the data there, what is already inserted
```
http://localhost:8080/h2-console/
```
And put below config on h2-console page if missing any of it.
```
Saved Settings: Generic H2 (Embedded)
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: 
```

You must see scheduler is running after every 1 min.