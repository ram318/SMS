FROM openjdk:8
ADD /target/order-0.0.1-SNAPSHOT.jar order.jar
EXPOSE 4040
ENTRYPOINT ["java", "-jar", "order.jar"]