
# Fawry APi

A Spring Boot REST API, that handles payment to various Service Providers, documented with Swagger2.
* Swagger JSON URL: http://localhost:8080/v2/api-docs

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/eg/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3.x](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org/download/) (if you want to run offline databse)



## How to Run 

* Clone this repository 
* download maven dependencies in ``pom.xml`` file
* Postegress database is deployed online.
* execute the `main` method in the `com.m_code.Fawry` class from your IDE.

Once the application runs you should see something like this

```
2023-01-01 19:07:33.598  INFO 14948 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-01-01 19:07:33.899  INFO 14948 --- [           main] com.m_code.Fawry.FawryApplication        : Started FawryApplication in 4.963 seconds (JVM running for 5.296)
```

## Running the application on local PostgreSQL database

- Create a Database in postgresql

- Comment this code

```
# online config
spring.datasource.url=jdbc:postgresql://suleiman.db.elephantsql.com:5432/kfftlrmx
spring.datasource.username=kfftlrmx
spring.datasource.password=dKDYrxMvI9IIFfhz6_VP53L1GQPhc5ZU
```

- Uncomment this code and add your database info

```
# # local config
# spring.datasource.url=jdbc:postgresql://localhost:5432/'your database name'
# spring.datasource.username='username'
# spring.datasource.password='password'
```

- Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
- All done

