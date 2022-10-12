# spring-boot-profile demo 
Follow the below instructions to have smooth execution of this application.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 2.7.4
    Spring - 5.3.23
    Lombok - 1.18.24

### Building

The example can be built with

    mvn clean install

## Profiles
1. Copy this project to your local machine
2. Build thi project using `mvn clean install -DskipTests` command
3. Run this application as java application or execute `mvn spring-boot:run -Dspring-boot.run.profiles=dev`
4. This application is demonstration of profiles, if you are running the dev profile, application-dev.properties will be picked up at the time of starting the application.
5. Once application started, please check the logs.
6. Open [`http://localhost:8080`](http://localhost:8080) in browser, you will see Greeting demo page. Put your name and get greetings.
7. Now, open [`http://localhost:8080/log`](http://localhost:8080/log) in browser. Check the message and logs.
8. Please change the log level configuration in the `application.properties` for `logging.level.root` and re-run. You will find the difference of log level.

***
Thank you for checking out. :)
***
