docker build --tag selenium-tests .

docker run --name tests --rm --network selenium-docker-suite_selenium-grid selenium-tests
