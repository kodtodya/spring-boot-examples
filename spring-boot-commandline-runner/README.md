# REST Service Demo with Spring Boot

This example demonstrates how you can implement REST service in Spring Boot.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 3.3.3
    Spring - 6.1.12
    Lombok - 1.18.24

### Building

The example can be built with

    mvn clean install

### Running the example in your local

For Linux users
```shell
spring-boot:run -Dspring-boot.run.arguments=--priceOne.pound=5
```

Windows user
```shell
mvn spring-boot:run -D"spring-boot.run.arguments=--priceOne.pound=5"
```

### Test it using Program Arguments in Run Configurations
-DpriceOne.pound=5
