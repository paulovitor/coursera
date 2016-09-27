FROM jboss/wildfly:latest

COPY docker/wildfly/jrebel.jar /jrebel.jar
ENV JAVA_OPTS="-javaagent:/jrebel.jar -Drebel.remoting_plugin=true"

ADD target/forum.war /opt/jboss/wildfly/standalone/deployments/