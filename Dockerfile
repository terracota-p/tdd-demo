# To be called like eg:
# docker build --build-arg origJar=target/tdd-demo-0.0.1.jar -t tdd-demo -f docker/Dockerfile .

FROM openjdk:8-jdk-alpine

WORKDIR /app

ARG origJar

ENV jar=app.jar

ADD $origJar ./$jar

ADD start.sh ./start.sh

RUN chmod a+x ./start.sh

EXPOSE 8080
ENTRYPOINT ["./start.sh"]