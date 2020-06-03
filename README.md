## Complete SpringBoot Microservice 
For Study Purposes  

## Technologies:

-SpringBoot  
-Gradle  
-Lombok  
-JPA  
-Actuator  
-Kafka  
-H2 Database  
-Spring Cloud  

## How to run

Project discovery-server needs to be running:
https://github.com/rafaelCarinha/discovery-server

Development environment: 
-Dspring.profiles.active=dev

Production environment:
-Dspring.profiles.active=prod

## Dependency

Sonarqube running: http://localhost:9000  
docker run -d --name sonarqube -p 9000:9000 sonarqube:7.5-community

## Run DynamoDB locally

docker pull amazon/dynamodb-local    

docker run -p 8000:8000 amazon/dynamodb-local  

http://localhost:8000/shell/  


