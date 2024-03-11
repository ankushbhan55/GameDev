GameDev Coding Challenge

Table of Contents
1. Description
2. Key Technologies
3. Prerequisites
4. Installation
5. Usage


Description:
Welcome to the SpringBoot REST API for managing games and players! This API provides endpoints to handle various operations related to games and players, including creating, updating, retrieving and player information.

Key Technologies used:
Spring Boot: The project is built using the Spring Boot framework, providing a robust and efficient platform for developing Java-based applications.

Java 17: The latest version of Java is utilized to leverage the newest language features, improvements, and optimizations.

Swagger: API documentation is simplified and made interactive with Swagger, allowing developers to explore and understand the project's endpoints easily.

H2 In-Memory Database: For data storage during development, an H2 in-memory database is employed. This ensures a lightweight and fast database solution for testing and prototyping.

REST (Representational State Transfer): The project follows REST principles, enabling a scalable and stateless communication protocol for the web.

Lombok: To reduce boilerplate code, Lombok is used, enhancing the readability and maintainability of the codebase.

JPA (Java Persistence API): JPA is utilized for querying the database using Java objects, providing a convenient and object-oriented approach to database interactions.

MVC (Model-View-Controller) Pattern: The project architecture follows the MVC pattern, ensuring a clear separation of concerns and promoting modularity.


Prerequisites:
List any software, libraries, or other tools that users need to install before they can use your project.
- Java 17
- Maven 3
- Git
  Installation
  Provide step-by-step instructions on how to install your project.

Installation:
1. Clone the project by 'git clone https://github.com/ankushbhan55/GameDev.git'
2. Open the project in intelliJ
3. (Option 1) Simply run 'GameDevApplication' and navigate to 'http://localhost:8080/swagger-ui/index.html'
   (Option 2) mvn spring-boot:run


Usage:
1. From http://localhost:8080/swagger-ui/index.html choose the GET operation /api/players
2. Press 'Try it out'
3. See the results (A Player named Ankush should have a game "Counter-Strike" associated)
4. Go to the Post mapping /api/players/linkgameswithplayers
5. The json to be sent in the body should look like: 
      {
      "gameName": "Fortnite",
      "playerEmail": "shrub@gmail.com",
      "level": "pro"
      }

6. Confirm the new game has been assigned to Shruthi.

