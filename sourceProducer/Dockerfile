FROM java:8-jre-alpine

COPY build/libs/sourceProducer-0.0.1.jar /sourceProducer-0.0.1.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${ENVIRONMENT}", "sourceProducer-0.0.1.jar"]