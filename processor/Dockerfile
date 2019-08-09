FROM java:8-jre-alpine

COPY build/libs/processor-0.0.1.jar /processor-0.0.1.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=${ENVIRONMENT}", "processor-0.0.1.jar"]