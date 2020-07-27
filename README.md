# Selenium Test Suite

## Overview
This test suite is designed to quickly build and run End-to-End (E2E) Selenium tests on the UI of a website using containers. This approach allows quick setup and tear-down with minimal local installation. These tests are specifically written for the [MyICPC application](https://my.icpc.global), but the framework is easily extensible to other applications. The tests are written in JUnit, and they use Selenium to scrape the browser output.

## Motivation
UI tests are notoriously brittle and dependent on local browser installation. This means that tests could fail for no reason other than that the tester's version of Firefox was different from the developer's. We attempt to solve this problem by separating the test from the user's local browser installation using headless browsers inside containers. The tester can then specify the version of the browser to run by changing the image for the browser container.

Additionally, UI testing takes a while, and testing across multiple browsers can be time-consuming. Selenium Grid is an amazing technology which allows running Selenium tests in parallel (speeding up the process), but it requires some setup. We integrate the provided Docker images for the Grid hub and nodes into our architecture to make submitting and running the tests in parallel with multiple browsers easy. You can boot a grid locally to run tests or submit tests to a remote grid - installing the grid and running tests are separated in the configuration.

## Technologies Used
- **JUnit** - Java testing framework. Runs the tests and supplies input.
- **Selenium** - Reactive testing framework. Spins up browser instances and collects output. **Selenium Grid** ensures that the tests can be run on multiple browsers. It consists of a Hub and a Node. The Node runs several browser instances which connect to the Hub.
- **Maven** - dependency manager. Packages the tests as a JAR and handles any test dependencies.
- **Docker** - container software. Sticks the JAR in a small Linux container that is independent of the surrounding environment (defined in the Dockerfile). **Docker Compose** spins up containers for all elements of the application (Postgre, Redis, the main myICPC application, the UI, etc.), and runs the tests.

## Setup

### Windows and Mac
Make sure you have [Docker Desktop](https://www.docker.com/products/docker-desktop) installed. Users running Windows Home may need to install [Docker Toolbox](https://docs.docker.com/toolbox/toolbox_install_windows/) and [Docker Compose](https://docs.docker.com/compose/install/) instead.

### Linux
Install [Docker Engine - Community](https://docs.docker.com/install/linux/docker-ce/ubuntu/) and [Docker Compose](https://docs.docker.com/compose/install/). Make sure to add `sudo` to all commands below.

## Running the Tests
Docker Compose builds the Selenium Grid setup (the Hub and Node containers). Before you run any tests, you need to boot them:

```
# Run in the root directory of the project
docker-compose up -d
```

Note: if you're running Linux, add `sudo` to the beginning of the Docker commands.

Once booted, the Grid containers will stay up until you take them down, so you can run the tests as many times as you like. You 
might run them on a dedicated server and point the hub URL to it.

After that, we've provided two scripts which build and run the tests using Docker. However, you can also configure Maven locally to run the scripts instead. Note that you'll need to change the URL for the grid in the JUnit code if you do this.

```
# Build the tests with Docker
./build_tests.sh

# Run the tests with Docker
./run_tests.sh

# Build and run the tests without Docker
mvn clean test
```

The tests will be run by Maven's surefire plugin - just look for the success or failure message.
