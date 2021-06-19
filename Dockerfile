#tdpersonal
FROM java:8
MAINTAINER xinsida<274866280@qq.com>

ENV CATALINA_HOME=/home/tomcat/tdpersonal

COPY tdpersonal-start-0.0.1-SNAPSHOT.jar $CATALINA_HOME/tdpersonal.jar

EXPOSE $PORT
WORKDIR $CATALINA_HOME

ENTRYPOINT ["java","-jar","/home/tomcat/tdpersonal/tdpersonal.jar","tail -f $CATALINA_HOME/application.log"]