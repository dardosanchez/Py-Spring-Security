FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/proyectoFinalSpringSecurity-0.0.1.jar
COPY ${JAR_FILE} proyectoFinalSpringSecurity.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","proyectoFinalSpringSecurity.jar"]