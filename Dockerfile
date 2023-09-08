FROM openjdk:11-slim
COPY ./target/SchedulerUber-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","SchedulerUber-0.0.1-SNAPSHOT.jar"]