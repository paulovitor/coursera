FROM jboss/wildfly:latest

COPY docker/wildfly/jrebel.jar /jrebel.jar
ENV JAVA_OPTS="-javaagent:/jrebel.jar -Drebel.remoting_plugin=true"

ADD target/forum.war /opt/jboss/wildfly/standalone/deployments/

RUN $JBOSS_HOME/bin/add-user.sh admin admin --silent

EXPOSE 8787

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]