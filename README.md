## Project Overview
This project demonstrates a simple Kafka producer and consumer setup using Spring Boot and Redpanda as the Kafka-compatible broker. The core components are in two folders: producer and consumer.

## Key Components

#### producer
    - KafkaConfiguration.java: Contains Spring Beans for configuring both the Kafka producer and consumer.
    - KafkaComponent.java: Provides 'send' and 'consumerMessage' methods for producing and consuming Kafka messages, respectively.

#### comsumer
- KafkaConfiguration.java: Similar to the producer, defines beans for Kafka consumer configuration.
- KafkaComponent.java: Contains a KafkaListener method to receive and process messages from a specified Kafka topic.

#### docker-compose.yml
- Defines the services for the project:
    - redpanda-0: The Redpanda (Kafka-compatible) server.
    - console: (Optional) Redpanda Console for cluster management.
    - producer-0: The Spring Boot Kafka producer application.
    - consumer-0: The Spring Boot Kafka consumer application.

## Dependencies
- Java
- Spring Boot
- Spring Kafka
- Redpanda
- Docker and Docker Compose (for local testing/deployment)

## Configuration

 The applications expect configuration properties in their application.properties (or .yml) files:
- app.config.kafka.server: The address of your Kafka broker (e.g., redpanda-0:9092)
- app.config.kafka.topic: The Kafka topic for communication.
- app.config.kafka.groupId: The Kafka consumer group ID.
- app.config.kafka.offset-reset: (Consumer) How to handle message offsets if no existing offset is found ('earliest' or 'latest').

## How to Run

1. Start Redpanda:
    - docker compose up -d redpanda-0 console

2. Build and Run Applications:
    - Navigate to the producer directory and run ./mvnw package (or mvn) to build the producer application.
    - Navigate to the consumer directory and repeat the build process to build the consumer application.
    - Start the producer and consumer (the order doesn't matter, assuming your Docker Compose setup is running): java -jar producer/build/libs/producer-x.x.x.jar and similarly for the consumer application.

## Testing
The producer's KafkaComponent has a send method. Use this to send messages to the configured Kafka topic.
The consumer should automatically receive and log the messages.

## Notes
This is a simplified setup. Explore Spring Kafka documentation for more complex scenarios, error handling, etc.
Adjust ports and network configurations in the Docker Compose file as needed for your environment.