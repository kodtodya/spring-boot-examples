# spring-boot-batch-example 
Follow the below instructions to have smooth execution of this application.

## Technical Details
In this project, we are going to use below set of versions for demonstrations.
```
    Spring Boot - 3.2.2
    Spring Batch - 5.1.1
    H2 - 2.2.224
    Lombok - 1.18.32
    Java - 17
```

## Mandatory Setup
Pls make sure that `src/main/resources/csv/inputData.csv` file is present inside the `target/classes/csv/inputData.csv` everytime you this application.

## Build
The example can be built with
```shell
mvn clean install
```

## Run the program
```shell
mvn spring-boot:run
```

## Check the database
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

***
Thank you for checking out. :)
***