# Step : Test and package
FROM maven:3.6.1-jdk-13-alpine as target
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package -Dmaven.test.skip=true

# Step : Package image
FROM openjdk:13-jdk-alpine
EXPOSE 8081
CMD exec java $JAVA_OPTS -jar /app/my-app.jar
COPY --from=target /build/target/condominio-acme.jar /app/my-app.jar