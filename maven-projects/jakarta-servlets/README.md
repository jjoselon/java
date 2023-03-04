# Servlets with jakarta EE

## Steps to set up this project

- Download [Apache Tomcat Server](https://tomcat.apache.org/whichversion.html) Version 10 or later required project.
- Go to `conf` dir, open `tomcat-users.xml` add next element `<user username="administrador" password="1234" roles="admin,manager-gui,manager-script"/>`
- Startup web server ( In Windows 11 ) go to `bin` dir and run `startup` Windows Batch File to start Tomcat
- Run program with `ServletsJakartaEE [tomcat7:redeploy]` configuration IntelliJ IDE selected.
- Happy coding !

## Util

- [Admin Tomcat](http://localhost:8080/manager)
- (Udemy) Sección 3: API Servlet - Introducción