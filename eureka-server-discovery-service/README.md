## Spring Discovery Server Demonstration

### Relevant information:

This module demonstrates Discovery Server using Eureka Server.

We have broken this example into 3 micro-services to demonstrate the discovery functionality.

# Application Build

Please run below command in parent project

    mvn clean install

# Execution of the services with sequence

### spring-eureka-server execution

Windows User:

    cd spring-eureka-server
    mvn spring-boot:run

Linux Users:

    cd spring-eureka-server && mvn spring-boot:run

### spring-eureka-client-school-service execution
Windows User:

    cd spring-eureka-client-school-service
    mvn spring-boot:run

Linux User:

    cd spring-eureka-client-school-service && mvn spring-boot:run

### spring-eureka-client-student-service execution
Windows User:

    cd spring-eureka-client-student-service
    mvn spring-boot:run

Linux User:

    cd spring-eureka-client-student-service && mvn spring-boot:run

# Test the application
- Please check the logs for `spring-eureka-server` application

# View the discovery

- Please click on [Eureka Discovery Server Portal](http://localhost:8761/) to get the details about service discovery.

# Check the metrics configuration

- Pls check the configuration inside application.yml in `spring-eureka-client-school-service` and `spring-eureka-client-student-service` in management node.

# Test the metrics configuration

- Pls invoke http://localhost:9098/actuator url to test `spring-eureka-client-school-service` service metrics.
- Pls invoke http://localhost:8098/actuator url to test `spring-eureka-client-student-service` service metrics.

# Test rest of the metrics

Once you invoke any of the actuator metrics url, you will see many other URLs specific to respective metrics. Pls invoke those to see the metrics.