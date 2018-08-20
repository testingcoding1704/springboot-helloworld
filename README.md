Spring Boot Hello World
=======================
The simplest version of `Hello World` application using Spring Boot.

It was generated somehow with further modifications.

The output could be changed by modifying environment variable `HELLO_WORLD_TO`. 

To run
------
* HelloWorldApplication main class
* `mvn clean package spring-boot:run`


To verify
---------
```
curl localhost:8080
```


Health check
------------
```
curl -v localhost:8080/healthcheck/healthy
curl -v localhost:8080/healthcheck/ready
#Set unhealthy for a minute
curl -v localhost:8080/healthcheck/unhealthy-for-a-minute
curl -v localhost:8080/healthcheck/healthy
curl -v localhost:8080/healthcheck/ready
#Set unready for a minute
curl -v localhost:8080/healthcheck/unready-for-a-minute
curl -v localhost:8080/healthcheck/healthy
curl -v localhost:8080/healthcheck/ready
```
