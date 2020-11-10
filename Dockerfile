FROM java
MAINTAINER Shark
ADD target/SpringBootExample.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]