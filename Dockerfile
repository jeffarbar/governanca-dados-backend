FROM amd64/openjdk:8-jre-alpine3.9

LABEL author="Jefferson Farias"
LABEL email="jefferson.barbosa@claro.com.br"
LABEL company="CLARO"
RUN mkdir /app
RUN mkdir /app/logs/
WORKDIR /app
ADD ./target/CatalogoDados*.jar /app/app.jar
EXPOSE 8092
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]

