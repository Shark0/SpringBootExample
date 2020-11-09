FROM java
MAINTAINER Shark
ADD target/SpringBootDocker.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]