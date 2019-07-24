eval $(minikube docker-env)

mvn clean install

docker build --build-arg origJar=target/tdd-demo-0.0.1-SNAPSHOT.jar -t tdd-demo:latest -f Dockerfile .

kubectl delete -f kubeapp/LOCAL/

kubectl apply -f kubeapp/LOCAL/
kubectl get pod -l app=tdd-demo -o jsonpath="{.items[0].metadata.name}"

echo "To see the logs run:"
echo 'kubectl logs $(kubectl get pod -l app=tdd-demo --field-selector=status.phase=Running -o jsonpath="{.items[0].metadata.name}") -f'