# TDD demo

A test-driven RPG Character REST service.

## Standalone

### Build

`mvn clean install`

### Run

`java -jar target/tdd-demo-0.0.1-SNAPSHOT.jar`

## minikube

Alternatively you can run on minikube.

## Build docker and deploy to minikube

`build_run_k8s_LOCAL.sh`

### Pre: set up minikube

Start:
`minikube start`

Enable ingress:
`minikube addons enable ingress`

Use k8s' docker daemon so that the image built is accessible from k8s (needs to be done in each new terminal):
`eval $(minikube docker-env)`

### Test:

```
echo "$(minikube ip) tdd-demo.apis.local" | sudo tee -a /etc/hosts
curl tdd-demo.apis.local/actuator/health
curl tdd-demo.apis.local/tdd-demo/characters
```

## acceptance-tests

See [acceptance-tests/](acceptance-tests/README.md)