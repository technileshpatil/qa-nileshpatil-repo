FROM maven:3.6.3-jdk-11-slim AS buildJar

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven

RUN mvn clean install

# Run the tests
CMD ["mvn", "test"]