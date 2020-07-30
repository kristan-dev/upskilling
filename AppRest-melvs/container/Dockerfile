FROM maven:3.6-jdk-12-alpine as base
WORKDIR /usr/app
COPY src src
COPY pom.xml pom.xml
COPY set_cron.sh set_cron.sh
COPY rest_client_utility.jar rest_client_utility.jar
RUN mvn clean install
RUN /usr/app/set_cron.sh http://localhost:7224/page/bike
ENTRYPOINT ["java", "-jar", "/usr/app/target/melvsboot-0.0.1-SNAPSHOT.jar"]
