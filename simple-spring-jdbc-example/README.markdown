# Java Database Access with Spring-JDBC

This Maven project builds upon the [tutorial-jdbc-example](https://github.com/spankr/tutorial-jdbc-example) tutorial. 
Here we perform the same actions as in the simple example except we now utilize Spring's [JDBC](http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html) functionality.

Instead of manually creating the database connection from scratch, we let Spring configure it in the application context.
We'll also let Spring scan our data access package for any data access objects we may have.

The start of this example is the _TestSampleDAO_ test case. This time it loads the application context and pulls the DAO
from the beans.

After going through the basic jdbc tutorial, you should have a deeper perspective of what Spring and Spring JDBC gives you.

It uses:

* [Spring 5.3.23](https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/data-access.html#spring-data-tier)
* [HyperSQL](http://hsqldb.org/), for the in-memory database we are connecting to
* [SLF4J](http://www.slf4j.org/), for logging purposes


