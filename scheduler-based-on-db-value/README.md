# Spring Boot H2 Database CRUD example: Building Rest API with Spring Data JPA

In this example, we're going to see how to mask data in database using Spring Boot Rest JPA CRUD API with Maven that use Spring Data JPA to interact with H2 database.

You'll know:

- How to configure Spring Data, JPA, Hibernate to work with Database
- How to define Data Models and Repository interfaces
- Way to create Spring Rest Controller to process HTTP requests
- Way to use Spring Data JPA to interact with H2 Database
- Way to use column encryptor for in case of sensitive data

## Run Spring Boot application

- Please run the below webservice using below command:
```
curl --location --request POST 'http://localhost:8080/api/users' --header 'Content-Type: application/json' --data-raw '{ "firstName": "avadhut", "lastName": "lele", "email": "al@gmail.com"}'
curl --location --request POST 'http://localhost:8080/api/users' --header 'Content-Type: application/json' --data-raw '{ "firstName": "avi", "lastName": "lele", "email": "avil@gmail.com"}'
```

- Now check the records which you inserted
```
curl --location --request GET 'http://localhost:8080/api/users'
```

## Till this point, you won't find any difference as same data you inserted will be visible

Now, lets go to Database and check the data there, what is being inserted
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
You can expect the similar to below response from database in encrypted data.

![db-response.png](db-response.png)