Simple kubernetes examples
==========================

Actions on tags:
----------------
1) first deployment and and project version 1  
    ```
    // checkout to step 1
    git checkout v1
    // create image with version 1
    mvn package -DskipTests docker:build
    // apply deployment and service to k8s
    kubectl apply -f kubernetes/deployment.yml
    // look on created service
    kubectl get svc
    // call service on port mapped to 8083
    curl localhost:<mapped_port>/info
    ```
2) project version 2 and change version in deployment
    ```
    // checkout step 2
    git checkout v2
    // create image with version 2
    mvn package -DskipTests docker:build
    // apply changes to current deployment
    kubectl apply -f kubernetes/deployment.yml
    // call same service as before and see v2 application
    curl localhost:<mapped_port>/info
    ```
3) change count of replicas in deployment
    ```
    // checkout to step 3
    git checkout v3
    // apply changes to current deployment
    kubectl apply -f kubernetes/deployment.yml
    // call same service as before multiple times and see that requests balanced on different pods
    curl localhost:<mapped_port>/info
    // IMPORTANT TO DO ON THAT STEP. Clean current setup
    kubectl delete -f kubernetes/deployment.yml
    ```
4) two deployments under one service
    ```
    // checkout to step 4
    git checkout v4
    // apply new deployments and service
    kubectl apply kubernetes/deployment.yml
    // look created service
    kubectl get svc
    // call service on port mapped to 8083 and see that request balanced on application version 1 and version 2
    curl localhost:<mapped_port>/info
    ```
5) make service route requests to app v1
    ```
    // checkout to step 5
    git checkout v5
    // apply changes to existing service
    kubectl apply -f kubernetes/deployment.yml
    // call service on same port and see that all requests routes to app v1
    curl localhost:<mapped_port>/info
    ```
6) change service route to app v2 (blue/green deployment)
    ```
    // checkout to step 6
    git checkout v6
    // apply changes to existing service
    kubectl apply -f kubernetes/deployment.yml
    // call service on same port and see tha all requests routes to app v2
    curl localhost:<mapped_port>/info
    // IMPORTANT TO DO ON THAT STEP. Clean current setup
    kubectl delete -f kubernetes/deployment.yml
    ```
7) create app version 3 and call app version 1 through service discovery
    ```
    // checkout to step 7
    git checkout v7
    // apply setup to kubernetes
    kubectl apply -f kubernetes/deployment.yml
    // look at created services
    kubectl get svc
    // call service with app v3 (demo-kube-service-v3) on port mapped to 8083
    curl localhost:<mapped_port>/info
    // clear setup
    kubectl delete -f kubernetes/deployment.yml
    ```