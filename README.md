# TDD demo

A test-driven RPG Character REST service.

## Compile, build docker, run locally on minikube - Single command

You can run single command: `build_run_k8s_LOCAL.sh`

Or do step by step as described in the following sections.

## Compile, build docker, run locally on minikube - Step by step

### Compile

`mvn clean install`

### Set up minikube for local deployment

Start:
`minikube start`

Enable ingress:
`minikube addons enable ingress`

Use k8s' docker daemon so that the image built is accessible from k8s (needs to be done in each new terminal):
`eval $(minikube docker-env)`

### Build docker image

See `docker build ...` in `build_run_k8s_LOCAL.sh`. 

### Deploy and run on local k8s (minikube)

Deploy and run (also scylla and kafka): see `build_run_k8s_LOCAL.sh`. 

#### Check if running:

```
kubectl logs $(kubectl get pod -l app=tdd-demo -o jsonpath="{.items[0].metadata.name}") -f
```

#### Test:

```
echo "$(minikube ip) tdd-demo.apis.local" | sudo tee -a /etc/hosts
curl tdd-demo.apis.local/actuator/health
curl tdd-demo.apis.local/tdd-demo/characters
```

## acceptance-tests

See [acceptance-tests/](acceptance-tests/README.md)