docker build -t prometheus/quarkus -f Dockerfile.prometheus.yml  .

docker run -p 9090:9090 prometheus/quarkus --config.file /etc/quarkus-prometheus.yml

Prometheus : http://localhost:9090/

mvn package -Pnative -Dnative-image.docker-build=true

docker build -f src/main/docker/Dockerfile.native -t demo/quarkus-metrics .

docker build -f src/main/docker/Dockerfile.prometheus.yml -t demo/prometheus .


docker network create demo-net

docker run -d -p 8080:8080 --name quarkus --net demo-net demo/quarkus-metrics

docker run -d -p 9090:9090 --name prometheus --net demo-net demo/prometheus


curl localhost:8080/350

curl localhost:8080/350154785








docker rm -f $(docker ps -a -q)