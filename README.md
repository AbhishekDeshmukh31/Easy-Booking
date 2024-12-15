# EasyBooking (Hotel Booking) <br><hr>

<b>Description</b>
*The EasyBooking (Hotel Booking System) is a Java-based application built using **Spring Boot** and **Hibernate** for managing hotel reservations. This system allows users to book rooms, view available rooms, and manage reservations and update booking details. The backend is exposed as a RESTful API, and Postman is used to test the API endpoints.*
<br><hr>

<b>Features</b>
<b>Layered Architecture:</b> *Separates the application into distinct layers: entity, dao, service, and controller.* <br>
<b>RESTful API:</b> *Provides endpoints to manage the Candidate entity.* <br>
<b>Spring Boot Integration:</b> *Leverages Spring Boot for application management, dependency injection, and auto-configuration.* <br>
<b>MySQL Database:</b> *Uses MySQL for persistent storage (can be swapped with other relational databases).* <br>
<b>Hibernate ORM:</b> *Handles object-relational mapping (ORM) for entities.* <br><hr>

<b>Technologies Used</b>
*Java 17* <br>
Spring Boot: *For building and managing the application.* <br>
Hibernate ORM: *For managing entity persistence.* <br>
MySQL: *As the database (can be swapped with another relational database).* <br>
Maven: *For project dependency management.* </p><br><hr>

<b>Installation and Setup </b><br>
*AppConfig.java: Contains Spring Boot configuration settings like Hibernate configurations, entity scanning, etc.<br>*

<b>Step 1: Clone the Repository <br></b>
*git clone https://github.com/your-username/hotel-booking.git
cd hotel-booking <br>*


<b>Server Configuration <br></b>
*server.port=8080<br>*

<b>Step 2:Configure Database Connection</b> <br>
*Update the application.properties file located in src/main/resources/ with your database connection details.<br>*
<b>Example application.properties Configuration:</b><br>
*Server Configuration : server.port=8080* <br>

<b>Database Configuration (MySQL) </b><br>
*spring.datasource.url=jdbc:mysql://localhost:3306/your_database <br>
spring.datasource.username=username <br>
spring.datasource.password=password <br>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver <br>
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect <br>* 

<b>Hibernate Configuration <b><br>
*spring.jpa.hibernate.ddl-auto=update <br>
spring.jpa.show-sql=true <br>*
<b>Logging Configuration </b><br>
*logging.level.org.springframework.web=DEBUG<br>
logging.level.org.hibernate.SQL=DEBUG*<br><hr>

<b>Step 3: Build and Run the Project </b><br>
*To build and run the project, use Maven:* <br>
<b>Build the project:</b><br>
*mvn clean install <br>
Run the Project:
mvn spring-boot:run*<br><hr>

# Contact Information <br>
For further questions or support, feel free to reach out:<br>
 *Email:ad904108@.com*<br>
 *GitHub: AbhishekDeshmukh31*
