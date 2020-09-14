#########################################################
# Stage 1
#########################################################
FROM maven:3.5.2-jdk-8-alpine AS mvn_build

MAINTAINER Andre Silva

WORKDIR /build
COPY pom.xml .
RUN mvn -B install -N

COPY api/pom.xml /api
COPY api/ api/

RUN cd api && mvn clean package -DskipTests=true

#########################################################
# Stage 2
#########################################################
FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=mvn_build /build/api/target/api.jar /app/

ENTRYPOINT ["java", "-jar", "api.jar"]
