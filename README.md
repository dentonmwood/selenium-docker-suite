# Selenium Test Suite

## Overview
The test suite is designed to run End-to-End (E2E) tests on the microservices of the myICPC application. It may easily be extended to all microservices and the main ICPC application (hereafter referred to as the **"monolith"**). The tests are written in JUnit, and they use Selenium to scrape the browser output.

## Technologies Used
- **JUnit** - Java testing framework. Runs the tests and supplies input.
- **Selenium** - Reactive testing framework. Spins up browser instances and collects output. **Selenium Grid** ensures that the tests can be run on multiple browsers. It consists of a Hub and a Node. The Node runs several browser instances which connect to the Hub.
- **Maven** - dependency manager. Packages the tests as a JAR and handles any test dependencies.
- **Docker** - container software. Sticks the JAR in a small Linux container that is independent of the surrounding environment (defined in the Dockerfile). **Docker Compose** spins up containers for all elements of the application (Postgre, Redis, the main myICPC application, the UI, etc.), and runs the tests.

## Setup
Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) and [Docker Compose](https://docs.docker.com/compose/install/) downloaded and installed. Users running Windows Home may need to install [Docker Toolbox](https://docs.docker.com/toolbox/toolbox_install_windows/) instead.

## Running the Tests
Docker Compose builds the Selenium Hub and Node containers and runs the tests. Just run `docker-compose up --build` from the root directory of the project. Once the tests finish running, kill the process and run `docker-compose down` to clean out the images.

