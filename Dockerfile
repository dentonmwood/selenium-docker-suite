FROM maven:latest
LABEL maintainer="denton_wood@baylor.edu"

COPY pom.xml /pom.xml
COPY src/test/java/* /src/test/java/
CMD ["mvn", "clean", "test"]