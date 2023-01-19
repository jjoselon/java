https://spring.io/guides/gs/accessing-data-mysql/


```
create database db_springmysql; -- Creates the new database
create user 'springuser'@'%' identified by '12345'; -- Creates the user
grant all on db_springmysql.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

### Steps for run project

1. `./mvnw clean package` Build Project 
2. `java -jar target/demo-0.0.1-SNAPSHOT.jar` Run JAR file
--- or ---
1. `./mvnw spring-boot:run` To build and run (it will not create a JAR file)