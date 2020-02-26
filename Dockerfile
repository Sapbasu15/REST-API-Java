FROM maven

LABEL Author="Sapbasu"

ENV PORT=7070

WORKDIR /app

ENTRYPOINT ["mvn","clean","install","tomcat7:exec-war-only"]
