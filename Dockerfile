FROM openjdk:11-jre-slim
MAINTAINER email@willclark.org
EXPOSE 8080

COPY target/oauth-sforce-*.jar /opt/oauth-sforce/app.jar

VOLUME /opt/oauth-sforce

ENTRYPOINT ["java","-jar","/opt/oauth-sforce/app.jar"]