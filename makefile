IMAGE_NAME ?= com.bfi.bravo/bpm
IMAGE_TAG ?= latest
.DEFAULT_GOAL := default

default: build

clean:
	mvn -U clean

unit-test-and-report:
	mvn verify -Dspring-boot.run.profiles=unit-test
	echo "Test report generated at target/site/jacoco"

compile: clean
	mvn package -Dmaven.test.skip=true

package: clean
	mvn verify -Dmaven.test.skip=true

build: clean
	mvn verify

check-style:
	mvn prettier:check

fix-style:
	mvn prettier:write

integration-test:
	mvn clean verify -Dspring-boot.run.profiles=integration-test

run-local:
	mvn -U clean spring-boot:run -Dspring-boot.run.profiles=default,local

stack-up: compile
	docker-compose build bpm
	docker-compose up -d

stack-logs:
	docker-compose logs -f

stack-down:
	docker-compose down

image: compile
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

push: image
	 docker push $(IMAGE_NAME):$(IMAGE_TAG)

reset: clean build run-local
