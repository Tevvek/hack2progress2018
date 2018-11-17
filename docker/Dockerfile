FROM openjdk:8-jdk-alpine
RUN apk update
RUN apk upgrade
RUN apk add bash
COPY gestionVuelos.war app.war
COPY myCA.pem /usr/local/share/ca-certificates/myCA.pem
COPY gestionVuelos_start.sh /scripts/ 
RUN chmod 777 /scripts/gestionVuelos_start.sh
COPY wait-for-it.sh /scripts/ 
RUN chmod 777 /scripts/wait-for-it.sh
ENV JAVA_CACERTS /etc/ssl/certs/java/cacerts
RUN keytool -keystore ${JAVA_CACERTS} -storepass changeit -noprompt -trustcacerts -importcert -alias kong  -file /usr/local/share/ca-certificates/myCA.pem
#RUN find / -iname 'cacerts'
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=production -jar /app.war




