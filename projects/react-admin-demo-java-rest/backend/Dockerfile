FROM adoptopenjdk/openjdk11:alpine-jre
LABEL maintainer="remzisahbaz@outlook.com"
ADD target/react-admin-demo-java-rest-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]