Spring boot Kafka project.
Project as example of event based microservcies.
Have three microservices Order, Email and Stock.
Order microservice acts as producer and create events.
Stock and Email services acts as kafka consumer which consumes events from Order service.
