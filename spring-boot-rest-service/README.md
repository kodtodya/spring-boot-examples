# REST Service Demo with Spring Boot

This example demonstrates how you can implement REST service in Spring Boot.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 3.3.3
    Spring - 6.1.12
    Lombok - 1.18.30

### Building

The example can be built with
```shell
mvn clean install
```

### Running the example in your local
```shell
mvn clean spring-boot:run
```

### Send message to application with the help of demo REST API
Update the message in below common while posting multiple messages.

Add Few entries first to have smooth experience

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 0, \"name\" : \"SQL\", \"duration\" : 8, \"prerequisite\" : \"OOPs, DBMS\"}"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 1, \"name\" : \"Java-11\", \"duration\" : 8, \"prerequisite\" : \"OOPs, Logical Thinking\"}"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 2, \"name\" : \"Java-17\", \"duration\" : 8, \"prerequisite\" : \"OOPs, Logical Thinking\"}"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 3, \"name\" : \"Maven\", \"duration\" : 4, \"prerequisite\" : \"OOPs, Logical Thinking, Java\"}"
    
    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 4, \"name\" : \"Spring\", \"duration\" : 16, \"prerequisite\" : \"OOPs, Java, Maven\"}"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 5, \"name\" : \"Spring Boot\", \"duration\" : 16, \"prerequisite\" : \"OOPs, Java, Maven, Spring\"}"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/training-management/training --data "{\"id\" : 6, \"name\" : \"Hibernate\", \"duration\" : 16, \"prerequisite\" : \"OOPs, Java, Maven, Spring, SQL\"}"


Let's Search the Training now:

    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training

    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/0

    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/1
    
    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/2
    
    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/3
    
    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/4
    
    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/5
    
    curl -X GET -H 'Content-Type: application/json' http://localhost:8080/training-management/training/6
    

Update the few entries:

    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/0 --data "{\"duration\" : 10, \"prerequisite\" : \"Java, DBMS\"}"

    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/1 --data "{\"duration\" : 8, \"prerequisite\" : \"OOPs\"}"
    
    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/2 --data "\"duration\" : 8\"}"
    
    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/3 --data "\"prerequisite\" : \"OOPs, Logical Thinking, Java-17\"}"
    
    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/4 --data "{\"duration\" : 16, \"prerequisite\" : \"Java, Maven\"}"
    
    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/5 --data "{\"duration\" : 15, \"prerequisite\" : \"Java, Maven, Spring\"}"
    
    curl -X PUT -H 'Content-Type: application/json' http://localhost:8080/training-management/training/6 --data "{\"duration\" : 14, \"prerequisite\" : \"Java, Maven, Spring, SQL\"}"

Want to test Delete?

    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/0

    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/1

    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/2
    
    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/3
    
    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/4
    
    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/5
    
    curl -X DELETE -H 'Content-Type: application/json' http://localhost:8080/training-management/training/6

## How to test docker

First build app with `mvn clean install` and then build docker image
```shell
docker build -t kodtodya/spring-boot-rest-service .
```

once, build is successful, pls run it with below command:
```shell
docker run -p 8080:8080 kodtodya/spring-boot-rest-service
```