FROM amazoncorretto:17-alpine
LABEL authors="Lyes Sefiane"
WORKDIR /api-gateway
COPY target/api-gateway.jar api-gateway.jar
RUN apk upgrade && apk upgrade openssl --no-cache
EXPOSE 8080
ENTRYPOINT ["java","-jar","api-gateway.jar"]