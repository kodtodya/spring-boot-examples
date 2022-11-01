# Kafka Integration Demo with Spring Boot

This example demonstrates how you can use produce data to Apache Kafka.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 3.0.0-RC1
    Spring - 6.0.0-RC2
    Apache Kafka - 2.19.1

### Building

The example can be built with

    ./gradlew clean build

### Running the example in your local

    ./gradlew bootRun

### Infra setup for kafka [One-time activity]
- Steps are provided from Linux perspective(Fedora Fan)
- Download Kafka from [Official Kafka Website](https://kafka.apache.org/downloads)
- Extract respective zip/tar/tgz to certain location and rename that folder as `_apache-kafka`
- Make sure you have java environment setup to JDK-17
- Create `data` directory inside `_apache-kafka` directory
- Create `zookeeper` and `kafka-logs` inside the `data` directory
- Go to `_apache-kafka/config/zookeeper.properties` and change config from `dataDir=/tmp/zookeeper` to `dataDir=../data/zookeeper`
- Go to `_apache-kafka/config/server.properties` and change config from `log.dirs=/tmp/kafka-logs` to `log.dirs=../data/kafka-logs`
- Open cmd/terminal and go to `_apache-kafka/bin` directory

* always make sure to start zookeeper first
```
$ ./zookeeper-server-start.sh -daemon ../config/zookeeper.properties
```
--> this will not print anything; you can verify that kafka server is started using below command:
```
$ netstat -anp | grep 2181
```
--> you can also go to `_apache-kafka/data/zookeeper` directory; you will observe new log directory created as 'version-*' (* represent any number)

* Now, start the kafka server:
```
$ ./kafka-server-start.sh -daemon ../config/server.properties
```
--> Even, this command will not print anything; please verify if kafka server has started with below command.
```
$ netstat -anp | grep 9092
```
--> this command will provide you pid (e.g.5368/java)

* Use above received pid to find the process as below:
```
$ ps -aux | grep <pid>
```

You can also verify the kafka logs in `_apache-kafka/data/kafka-logs` folder

** congrats, your kafka server is up and running.
-----------------------------------------------------------------------------------------------------------------------------

** create topic to test with below command
```
$ ./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic kodtodya-demo
```
--> above command will create new topic named 'kodtodya-demo'

** validate the topic is created
```
$ ./kafka-topics.sh --list --bootstrap-server localhost:9092
```

** after validation of topic creation, start console consumer to check if messages are reaching to kafka using below command
```
$ ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kodtodya-demo --from-beginning
```
** Now, it's time to test our app. Download the camel-spring-boot-kafka-producer application and build it using mvn clean install command
** Run application as spring-boot app or java-app

** After running the example, check your console consumer; it should print the messages
** stop the console-consumer and start spring-boot-kafka-consumer-example by building it; it will consume all the messages.

### Send message to Kafka-topic with the help of demo REST API
Update the message in below common while posting multiple messages.

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/kafka-demo/send --data "hi, this is first kafka message"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/kafka-demo/send --data "hi, this is second kafka message"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/kafka-demo/send --data "hi, this is third kafka message"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/kafka-demo/send --data "hi, this is fourth kafka message"

    curl -X POST -H 'Content-Type: application/json' http://localhost:8080/kafka-demo/send --data "hi, this is fifth kafka message"