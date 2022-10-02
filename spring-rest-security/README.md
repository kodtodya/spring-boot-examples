# OAuth2 Integration Demo with Spring Boot

This example demonstrates how you can use OAuth2.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 2.7.4
    Spring - 5.3.23
    Spring Security - 2.5.2.RELEASE

### Building

The example can be built with

    mvn clean install

### Running the example in your local

    mvn clean spring-boot:run

### Send message to JMS Queue with the help of demo REST API
Update the message in below common while posting multiple messages.

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/artemis-demo/send --data "hi, this is first jms message"