FROM openjdk:17
COPY . /opt
WORKDIR /opt
EXPOSE 1452
ENTRYPOINT ["java","-jar","ldap-0.0.1-SNAPSHOT.jar"]
CMD mvn spring-boot:run