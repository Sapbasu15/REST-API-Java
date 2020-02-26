# Build The Source
FROM maven as build

WORKDIR /build

COPY . .

RUN mvn clean install tomcat7:exec-war-only

# Run the Executables

FROM maven

LABEL Author="sapbasu"

WORKDIR /app

COPY --from=build /build/target .

EXPOSE 7070

ENTRYPOINT ["java","-jar","restApiJava.jar","-httpPort=7070"]
