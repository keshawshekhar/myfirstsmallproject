FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
#RUN  mvn -f /home/app/pom.xml clean package

EXPOSE 8080


COPY target/spring-boot-mysql-myfirstproject.jar spring-boot-mysql-myfirstproject1.jar
ENTRYPOINT ["java","-jar","spring-boot-mysql-myfirstproject1.jar"]











#FROM openjdk:17
#EXPOSE 8080
#COPY target/spring-boot-mysql-myfirstproject.jar spring-boot-mysql-myfirstproject1.jar
#ENTRYPOINT ["java","-jar","spring-boot-mysql-myfirstproject1.jar"]




#FROM openjdk:11
#MAINTAINER "keshaw <shekhar>"
#COPY target/spring-boot-mysql-myfirstproject.jar  spring-boot-mysql-myfirstproject.jar

#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "spring-boot-mysql-myfirstproject.jar"]