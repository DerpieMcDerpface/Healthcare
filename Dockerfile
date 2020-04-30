FROM tomcat

COPY target/HealthCare-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
COPY target/HealthCare-0.0.1-SNAPSHOT/ /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
