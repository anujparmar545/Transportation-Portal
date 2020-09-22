FROM openjdk:11-jre-slim
EXPOSE 9000
ADD /target/transportation-portal-0.0.1-SNAPSHOT.jar transportation-portal-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar","transportation-portal-0.0.1-SNAPSHOT.jar"]
