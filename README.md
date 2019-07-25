# TDD demo

A test-driven RPG Character REST service.

## Build

`mvn clean install`

## Run

`java -jar target/tdd-demo-0.0.1-SNAPSHOT.jar`

## Test

See [acceptance-tests/](acceptance-tests/README.md)

## [optional] deploy to minikube

Alternatively you can run on minikube, although acceptance-tests currently are not configured to connect to it.

### [first time] set up minikube

Start:
`minikube start`

Enable ingress:
`minikube addons enable ingress`

Use k8s' docker daemon so that the image built is accessible from k8s (needs to be done in each new terminal):
`eval $(minikube docker-env)`

### Build docker and deploy to minikube

`build_run_k8s_LOCAL.sh`

### Test:

```
echo "$(minikube ip) tdd-demo.apis.local" | sudo tee -a /etc/hosts
curl tdd-demo.apis.local/actuator/health
curl -X POST http://tdd-demo.apis.local/characters -H 'Content-Type: application/json' -d '{"name":"Jarl", "leadership":1, "endurance":4}'
curl tdd-demo.apis.local/characters
```
