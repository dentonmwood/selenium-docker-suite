# Good articles:
# https://codefresh.io/docker-tutorial/java_docker_pipeline/
# https://docs.docker.com/develop/develop-images/multistage-build/
# https://maven.apache.org/plugins/maven-jar-plugin/examples/create-test-jar.html
# https://www.baeldung.com/junit-tests-run-programmatically-from-java
# https://maven.apache.org/plugins/maven-jar-plugin/examples/create-test-jar.html
# https://stackoverflow.com/questions/49441049/junit-5-does-not-execute-method-annotated-with-beforeeach

# Note: look at image/container size (is apparently a big deal)

FROM maven:3.6.3-jdk-8-slim as maven
LABEL maintainer="denton_wood@baylor.edu"

COPY pom.xml /pom.xml
COPY src/test/java/* /src/test/java/
CMD ["mvn", "clean", "test"]