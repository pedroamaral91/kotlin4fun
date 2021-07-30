FROM alpine:latest

RUN mkdir /clean

RUN apk update \
 && apk --no-cache add openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community

WORKDIR /clean

ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

COPY . .

EXPOSE 8080

ENTRYPOINT ["tail", "-f", "/dev/null"]
