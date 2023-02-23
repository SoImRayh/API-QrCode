FROM maven as build

WORKDIR /usr/src/mymaven
COPY . .
RUN mvn package

FROM openjdk

COPY --from=build /usr/src/mymaven/target/QrCodeAPI-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]