FROM openjdk:8-jre
COPY target/babble-*.war app.war
ENTRYPOINT ["java","-Duser.timezone=<KR>", "-jar","app.war"]