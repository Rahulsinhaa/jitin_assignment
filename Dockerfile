FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.war login_signup-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-war","/login_signup-0.0.1-SNAPSHOT.war"]