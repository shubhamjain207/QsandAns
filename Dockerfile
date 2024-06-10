FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/demo/Bloger1.jar Bloger1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Bloger1.jar"]