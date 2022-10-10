# Spring Boot with Filter

In this example, we're going to see how to write filter along with interceptor in Spring Boot REST API implementation.

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

Now, lets insert the data into the Training Service. For this functionality demonstration, we have front end HTML page in place.
Please verify the logs before invoking.

### Insert Data
http://localhost:8080/index.html

Please verify the logs after invoking.

Enter data and submit, verify logs.

### Retrieve all the inserted values

    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training

### Retrieve Specific inserted values

    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training/0

### Delete Specific inserted values

    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training/0

Above-mentioned are just operations. This program is just a demonstration of the interceptor. Please verify logs everytime you trigger any operation.