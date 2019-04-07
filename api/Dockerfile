FROM java:8-jre-alpine

COPY build/libs/api-0.0.1.jar /api-0.0.1.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${ENVIRONMENT}", "api-0.0.1.jar"]