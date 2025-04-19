#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
#COPY target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
#ENTRYPOINT ["java","-jar","/service-registry.jar"]


FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/service-registry-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
