<div align="center">
    
[![Typing SVG](https://readme-typing-svg.demolab.com?font=Jersey+15&size=34&pause=1000&color=FFFFFF&center=true&width=435&lines=Microservices+Monitoring+Platform)](https://git.io/typing-svg)

</div>
<div align="center">

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.0-brightgreen.svg)
[![Docker](https://img.shields.io/badge/docker-supported-blue.svg)](https://www.docker.com/)
![Kubernetes](https://img.shields.io/badge/Kubernetes-1.28-blue.svg)
![Kafka](https://img.shields.io/badge/Kafka-3.6-red.svg)
![MongoDB](https://img.shields.io/badge/MongoDB-6.0-green.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Angular](https://img.shields.io/badge/Angular-18-red.svg)
![Keycloak](https://img.shields.io/badge/Keycloak-23.0-orange.svg)
![Grafana](https://img.shields.io/badge/Grafana-10.2-orange.svg)

A microservices monitoring platform using an ecommerce microservice architecture as a demonstration case
</div>

## Table of Contents 📑
- [🎯 Overview](#-overview)
- [🔧 Tech Stack](#-tech-stack)
  - [Infrastructure & Deployment](#infrastructure--deployment)
  - [Authentication & Security](#authentication--security)
  - [Message Broker & Event Streaming](#message-broker--event-streaming)
  - [Databases](#databases)
  - [Backend Services](#backend-services)
  - [Frontend](#frontend)
  - [Monitoring & Observability Stack](#monitoring--observability-stack)
  - [Email Service](#email-service)
- [📋 Prerequisites](#-prerequisites)
- [🏗️ Architecture](#%EF%B8%8F-architecture)
- [🏗️ Architecture Details](#arch-details)
- [🐋 Docker Image](#docker-image)
- [🚀 Quick Start Guide](#-quick-start-guide)
- [📊 Monitoring Features](#-monitoring-features)
- [🔐 Security](#-security)
- [🎥 Demo Video](#-demo-video)

## 🎯 Overview

This platform demonstrates modern monitoring and observability practices for microservices architectures. It uses a sample ecommerce application to showcase:
- Distributed tracing with Tempo
- Metrics collection with Prometheus
- Log aggregation with Loki
- Visualization with Grafana
- Service mesh observability
- Real-time alerting

## 🔧 Tech Stack

### Infrastructure & Deployment
- **Kubernetes** - Container orchestration
- **Docker** - Containerization
- **Kind** - Local Kubernetes cluster

### Authentication & Security
- **Keycloak** - Identity and access management
- **OAuth2/OpenID Connect** - Authentication protocols
- **Spring Security** - Security framework

### Message Broker & Event Streaming
- **Apache Kafka** - Event streaming platform
- **Schema Registry** - Schema management for Kafka
- **Apache Avro** - Data serialization
- **Kafka UI** - Kafka management interface

### Databases
- **MongoDB** - NoSQL database for Product Service
- **MySQL** - Relational database for Order and Inventory Services
- **Flyway** - Database migration tool

### Backend Services
- **Spring Boot** - Application framework
- **Spring Cloud** - Distributed system patterns
- **Spring Cloud Gateway** - API Gateway
- **Spring Data JPA/MongoDB** - Data access layer
- **Spring Cloud Circuit Breaker** - Fault tolerance
- **Resilience4j** - Circuit breaker implementation

### Frontend
- **Angular** - Frontend framework
- **TailwindCSS** - CSS framework

### Monitoring & Observability Stack
- **Grafana** - Metrics visualization & dashboards
- **Prometheus** - Metrics collection and alerting
- **Loki** - Log aggregation
- **Tempo** - Distributed tracing
- **Micrometer** - Application metrics facade
- **Spring Actuator** - Application monitoring
- **AlertManager** - Alert handling

### Email Service
- **Spring Mail** - Email integration
- **Mailtrap** - Email testing

## 📋 Prerequisites

- Java 21
- Docker
- Kubernetes (Kind)
- kubectl
- Node.js & npm

## 🏗️ Architecture
![diagram-export-12-25-2024-8_55_25-PM](https://github.com/user-attachments/assets/dc39853f-0822-4069-bd05-fb54c179d0c8)

<details id="arch-details">
    <summary><h2>🏗️ Architecture Details (click to expand)</h2></summary>

    └── Jaafarhh-microservices-manager/
        ├── docker/
        │   ├── grafana/
        │   ├── mysql/
        │   ├── prometheus/
        │   ├── tempo/
        │   └── keycloak/
        │       └── realms/
        ├── k8s/
        │   ├── manifests/
        │   │   ├── applications/
        │   │   └── infrastructure/
        │   └── kind/
        ├── frontend/
        │   ├── Dockerfile
        │   ├── public/
        │   ├── package-lock.json
        │   ├── package.json
        │   ├── src/
        │   │   ├── index.html
        │   │   ├── styles.css
        │   │   ├── main.ts
        │   │   └── app/
        │   │       ├── interceptor/
        │   │       ├── services/
        │   │       ├── shared/
        │   │       │   └── header/
        │   │       ├── config/
        │   │       ├── pages/
        │   │       │   ├── add-product/
        │   │       │   └── home-page/
        │   │       └── model/
        │   └── angular.json
        ├── api-gateway/
        │   ├── pom.xml
        │   └── src/main/java/com/alioui/microservices/
        │       └── main/
        │           ├── resources/
        │           └── java/com/alioui/microservices/gateway/
        │               ├── config/
        │               ├── routes/
        │               └── ApiGatewayApplication.java
        ├── notification-service/
        │   ├── pom.xml
        │   └── src/main/
        │       ├── resources/
        │       │   └── avro/
        │       └── java/com/alioui/microservices/notification/
        │           ├── config/
        │           ├── service/
        │           └── NotificationServiceApplication.java
        ├── order-service/
        │   ├── pom.xml
        │   └── src/
        │       ├── main/
        │       │   ├── resources/
        │       │   │   ├── avro/
        │       │   │   └── db/migration/
        │       │   └── java/com/alioui/microservices/order/
        │       │       ├── dto/
        │       │       ├── event/
        │       │       ├── controller/
        │       │       ├── repository/
        │       │       ├── config/
        │       │       ├── model/
        │       │       ├── service/
        │       │       ├── client/
        │       │       └── OrderServiceApplication.java
        │       └── test/
        │           ├── resources/
        │           └── java/com/alioui/microservices/order/
        │               ├── stubs/
        │               ├── OrderServiceApplicationTests.java
        │               └── TestOrderServiceApplication.java
        ├── inventory-service/
        │   ├── pom.xml
        │   └── src/
        │       ├── main/
        │       │   ├── resources/
        │       │   │   └── db/migration/
        │       │   └── java/com/alioui/microservices/
        │       │       └── inventory/
        │       │           ├── controller/
        │       │           ├── repository/
        │       │           ├── config/
        │       │           ├── model/
        │       │           ├── service/
        │       │           └── InventoryServiceApplication.java
        │       └── test/java/com/alioui/microservices/inventory/
        │           ├── InventoryServiceApplicationTests.java
        │           └── TestInventoryServiceApplication.java
        ├── product-service/
        │   ├── pom.xml
        │   └── src/main/
        │       ├── resources/
        │       └── java/com/alioui/microservices/product/
        │           ├── dto/
        │           ├── controller/
        │           ├── repository/
        │           ├── config/
        │           ├── model/
        │           ├── service/
        │           └── ProductServiceApplication.java                                    
        ├── pom.xml
        └── docker-compose.yml
</details>


<details id="docker-image">
  <summary><h2>🐋 Docker Image (click to expand)</h2></summary>

    version: '4'
    services:
      mongodb:
        image: mongo:7.0.5
        container_name: mongodb
        ports:
          - "27017:27017"
        environment:
          MONGO_INITDB_ROOT_USERNAME: root
          MONGO_INITDB_ROOT_PASSWORD: password
          MONGO_INITDB_DATABASE: product-service
        volumes:
          - ./data/mongodb:/data/db
      mysql:
        image: mysql:8.3.0
        container_name: mysql
        environment:
          MYSQL_ROOT_PASSWORD: mysql
        ports:
          - "3306:3306"
        volumes:
          - ./data/mysql:/var/lib/mysql
          - ./docker/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
      zookeeper:
        image: confluentinc/cp-zookeeper:7.5.0
        hostname: zookeeper
        container_name: zookeeper
        ports:
          - "2181:2181"
        environment:
          ZOOKEEPER_CLIENT_PORT: 2181
          ZOOKEEPER_TICK_TIME: 2000

      broker:
        image: confluentinc/cp-kafka:7.5.0
        container_name: broker
        ports:
          - "9092:9092"
          - "29092:29092"
        depends_on:
          - zookeeper
        environment:
          KAFKA_BROKER_ID: 1
          KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
          KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
          KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://broker:29092,PLAINTEXT_HOST://localhost:9092
          KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

      schema-registry:
        image: confluentinc/cp-schema-registry:7.5.0
        hostname: schema-registry
        container_name: schema-registry
        depends_on:
          - broker
        ports:
          - "8085:8081"
        environment:
          SCHEMA_REGISTRY_HOST_NAME: schema-registry
          SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS : 'broker:29092'
          SCHEMA_REGISTRY_LISTENERS: http://schema-registry:8081
      kafka-ui:
        container_name: kafka-ui
        image: provectuslabs/kafka-ui:latest
        ports:
          - "8086:8080"
        depends_on:
          - broker
        environment:
          KAFKA_CLUSTERS_NAME: local
          KAFKA_CLUSTERS_BOOTSTRAPSERVERS: broker:29092
          #      KAFKA_CLUSTERS_SCHEMAREGISTRY: http://schema-registry:8081
          DYNAMIC_CONFIG_ENABLED: 'true'
      keycloak-mysql:
        container_name: keycloak-mysql
        image: mysql:8
        volumes:
          - ./volume-data/mysql_keycloak_data:/var/lib/mysql
        environment:
          MYSQL_ROOT_PASSWORD: root
          MYSQL_DATABASE: keycloak
          MYSQL_USER: keycloak
          MYSQL_PASSWORD: password
      keycloak:
        container_name: keycloak
        image: quay.io/keycloak/keycloak:24.0.1
        command: [ "start-dev", "--import-realm" ]
        environment:
          DB_VENDOR: MYSQL
          DB_ADDR: mysql
          DB_DATABASE: keycloak
          DB_USER: keycloak
          DB_PASSWORD: password
          KEYCLOAK_ADMIN: admin
          KEYCLOAK_ADMIN_PASSWORD: admin
        ports:
          - "8181:8080"
        volumes:
          - ./docker/keycloak/realms/:/opt/keycloak/data/import/
        depends_on:
          - keycloak-mysql
      loki:
        image: grafana/loki:main
        container_name: loki
        command: [ "-config.file=/etc/loki/local-config.yaml" ]
        ports:
          - "3100:3100"
      prometheus:
        image: prom/prometheus:v2.46.0
        container_name: prometheus
        command:
          - --enable-feature=exemplar-storage
          - --config.file=/etc/prometheus/prometheus.yml
        volumes:
          - ./docker/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml:ro
          - ./docker/prometheus/alerts.yml:/etc/prometheus/alerts.yml:ro
        ports:
          - "9090:9090"
      alertmanager:
        image: prom/alertmanager:v0.25.0
        container_name: alertmanager
        volumes:
          - ./docker/alertmanager:/etc/alertmanager
        command:
          - '--config.file=/etc/alertmanager/alertmanager.yml'
        ports:
          - "9093:9093"
      tempo:
        image: grafana/tempo:2.2.2
        container_name: tempo
        command: ["-config.file=/etc/tempo.yaml"]
        volumes:
          - ./docker/tempo/tempo.yml:/etc/tempo.yaml:ro
          - ./data/tempo:/tmp/tempo
        ports:
          - "3110:3100"  # Tempo
          - "9411:9411" # zipkin
      grafana:
        image: grafana/grafana:10.1.0
        container_name: grafana
        volumes:
          - ./docker/grafana:/etc/grafana/provisioning/datasources:ro
        environment:
          - GF_AUTH_ANONYMOUS_ENABLED=true
          - GF_AUTH_ANONYMOUS_ORG_ROLE=Admin
          - GF_AUTH_DISABLE_LOGIN_FORM=true
        ports:
          - "3000:3000"
</details>

## 🚀 Quick Start Guide
### 1. Clone the repository
```bash
git clone https://github.com/Jaafarhh/microservices-monitoring.git
```
### 2. Start Infrastructure
```bash
# Create Kind cluster with pre-loaded images (use a bash terminal to run the .sh file)
./k8s/kind/create-kind-cluster.sh

# Navigate to the manifests directory
cd k8s/manifests/

# Deploy infrastructure components
kubectl apply -f infrastructure.

# Deploy application services
kubectl apply -f applications
```
### 3. Access Services
```bash
# API Gateway
kubectl port-forward svc/gateway-service 9000:9000

# Grafana
kubectl port-forward svc/grafana 3000:3000

# Keycloak
kubectl port-forward svc/keycloak 8080:8080
```
### 4. Run Frontend
```bash
cd frontend
npm install
npm run start
```
## 📊 Monitoring Features

- Real-time metrics visualization
- Service dependency mapping
- Distributed trace analysis
- Log correlation
- Custom dashboards
- Alerting rules
- SLO monitoring

## 🔐 Security

- OAuth2/OpenID Connect with Keycloak
- Service-to-service authentication
- TLS encryption
- Role-based access control
- API Gateway security

## 🎥 Demo Video

---
<div align="center">

made with <3 by Alioui Jaâfar and Belhaddad Rayan

</div>
