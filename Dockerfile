FROM openjdk:17-alpine

EXPOSE 8080

COPY ./build/libs/deal-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]