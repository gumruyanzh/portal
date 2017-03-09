# Generic Portal for creating simple Buy/Sell platform

How to start the portal application
---

1. You need to have local MySql DB
1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/portal-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`


Try
---

To Get all products enter url  `http://localhost:8080/products`


Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
