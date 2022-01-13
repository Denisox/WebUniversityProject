# Read Me First

The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Spring Boot DevTools, Spring Session, Spring Web
  Services, Spring Configuration Processor, Spring Integration, Spring Batch, Rest Repositories, Spring REST Docs'. As a
  result, your application may not work as expected.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.0/maven-plugin/reference/html/#build-image)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/security.html)
* [Spring Integration HTTP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/http.html)
* [Spring Integration STOMP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/stomp.html)
* [Spring Integration WebSocket Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/websocket.html)
* [Spring Integration Web Services Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/ws.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-webservices)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-security)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-integration)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#howto-batch-applications)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [WebSocket](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/#boot-features-websockets)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)

### Additional Links

These additional references should also help you:

* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#spring-aot-maven)

## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started with Spring
Native. Docker should be installed and configured on your machine prior to creating the image,
see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-buildpacks)
.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 Web1:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image. The GraalVM
native-image compiler should be installed and configured on your machine,
see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.0-RC1/reference/htmlsingle/#getting-started-native-build-tools)
.

To create the executable, run the following goal:

```
$ ./mvnw package -Pnative
```

Then, you can run the app as follows:

```
$ target/Web1
```
