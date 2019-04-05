docker build -t prometheus/quarkus -f Dockerfile.prometheus.yml  .

docker run -p 9090:9090 prometheus/quarkus --config.file /etc/quarkus-prometheus.yml

Prometheus : http://localhost:9090/