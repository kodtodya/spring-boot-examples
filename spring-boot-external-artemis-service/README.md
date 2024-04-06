# Artemis(JMS) Integration Demo with Spring Boot

This example demonstrates how you can use produce and consume data to Apache ActiveMQ Atremis(JMS).

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 2.7.4
    Spring - 5.3.23
    Apache Arteis - 2.19.1(Embedded)

### Building

The example can be built with
```shell
mvn clean install
```
### Running the example in your local
```shell
mvn clean spring-boot:run
```

### Infra setup for Artemis JMS Broker 
- Download [Apache ActiveMQ Artemis from official website](https://activemq.apache.org/components/artemis/download/)
- Extract zip/tar.gz file to location, where you want to install your JMS broker
- open CMD/terminal and navigate to <artemis installation> directory through command line
- `cd bin` - use this command to go inside bin folder
- create broker now using command - `./artemis create my-broker`
- Set the credentials as `admin/admin` and allow anonymous access as we are just demonstrating JMS broker.

### Congrats, your broker is created, lets start now.
- Go to my-broker folder inside the bin folder
- `cd my-broker/bin` - use this command to navigate
- start your jms broker using this command `./artemis run`

### Send message to JMS Queue with the help of demo REST API
Update the message in below common while posting multiple messages.
```
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/artemis-demo/send --data "hi, this is first jms message"
```