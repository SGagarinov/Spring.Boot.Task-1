FROM openjdk:17-oracle

EXPOSE 8899

VOLUME /tmp
COPY target/*.jar mydocker.jar
ENTRYPOINT ["java","-jar","/mydocker.jar"]
