FROM openjdk:8
ADD /target/user1-0.0.1-SNAPSHOT.jar users.jar
EXPOSE 3031
ENTRYPOINT ["java", "-jar", "users.jar"]