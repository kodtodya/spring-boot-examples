# spring-boot-logging demo 
Follow the below instructions to have smooth execution of this application.

### Technical Details
In this project, we are going to use below set of versions for demonstrations.

    Spring Boot - 2.7.4
    Spring - 5.3.23
    Lombok - 1.18.24

### Building

The example can be built with

    mvn clean install

## Logger
1. Copy this project to your local machine
2. Build thi project using `mvn clean install -DskipTests` command
3. Run this application as java application or execute `mvn spring-boot:run` command
4. This application is demo for logger; we can understand how logger works
5. Once application started, please check the logs.
6. Open [`http://localhost:8080`](http://localhost:8080) in browser, you will see Greeting demo page. Put your name and get greetings.
7. Now, open [`http://localhost:8080/log`](http://localhost:8080/log) in browser. Check the message and logs.
8. Please change the log level configuration in the `application.properties` for `logging.level.root` and re-run. You will find the difference of log level.

## Actuator
9. This demo application also provides the demo of actuator along with logger.
10. Please open [`http://localhost:8080/actuator`](http://localhost:8080/actuator) in browser.
11. You will be asked to provide the username and password. Username is `user` and password will be printed in logs at this time of booting application.

e.g. Using generated security password: `700e2699-f4b5-4a5a-9aee-98810d452e88`
12. Enter the credentials and check the details of actuator endpoints. Below snippet has few set of endpoints. Copy the URL of each endpoint and check the details.

[Read more details in spring documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html) 
```
{
  "_links": {
    "self": {
      "href": "http://localhost:8080/actuator",
      "templated": false
    },
    "beans": {
      "href": "http://localhost:8080/actuator/beans",
      "templated": false
    },
    "caches": {
      "href": "http://localhost:8080/actuator/caches",
      "templated": false
    },
    "caches-cache": {
      "href": "http://localhost:8080/actuator/caches/{cache}",
      "templated": true
    },
    "health": {
      "href": "http://localhost:8080/actuator/health",
      "templated": false
    },
    "health-path": {
      "href": "http://localhost:8080/actuator/health/{*path}",
      "templated": true
    },
    "info": {
      "href": "http://localhost:8080/actuator/info",
      "templated": false
    },
    "conditions": {
      "href": "http://localhost:8080/actuator/conditions",
      "templated": false
    },
    "shutdown": {
      "href": "http://localhost:8080/actuator/shutdown",
      "templated": false
    },
    "configprops": {
      "href": "http://localhost:8080/actuator/configprops",
      "templated": false
    },
    "env-toMatch": {
      "href": "http://localhost:8080/actuator/env/{toMatch}",
      "templated": true
    },
    "env": {
      "href": "http://localhost:8080/actuator/env",
      "templated": false
    },
    "loggers": {
      "href": "http://localhost:8080/actuator/loggers",
      "templated": false
    },
    "loggers-name": {
      "href": "http://localhost:8080/actuator/loggers/{name}",
      "templated": true
    },
    "heapdump": {
      "href": "http://localhost:8080/actuator/heapdump",
      "templated": false
    },
    "threaddump": {
      "href": "http://localhost:8080/actuator/threaddump",
      "templated": false
    },
    "prometheus": {
      "href": "http://localhost:8080/actuator/prometheus",
      "templated": false
    },
    "metrics": {
      "href": "http://localhost:8080/actuator/metrics",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
      "templated": true
    },
    "scheduledtasks": {
      "href": "http://localhost:8080/actuator/scheduledtasks",
      "templated": false
    },
    "mappings": {
      "href": "http://localhost:8080/actuator/mappings",
      "templated": false
    }
  }
}
```

## Security
13. This application is also demo of security. 
14. We have configured basic security to actuator endpoints.
15. We can verify the security using Step-11.
16. If you don't want security in your application, please remove `security-starter` from pom.xml
and also change below config to application.properties

```
#Enable security for management
management.security.enabled=false
#management.security.roles=ADMIN
#security.basic.enabled=true
#security.user.name=admin
#security.user.password=admin
```
17. We can also add the additional security features based on our requirement. 
***
Thank you for checking out. :)
***