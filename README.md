# Property Manager Project

## Overview
The Property Manager is a Spring Boot application designed to simplify property management tasks such as tracking property details, managing tenants, and handling related operations efficiently.

## Features
- Property management functionality
- Tenant and rental management
- Database integration using Spring Data JPA

## Technologies Used
- **Java**: Core programming language
- **Spring Boot (3.4.0)**: Framework for building the application
- **Spring Data JPA**: For database persistence
- **Maven**: Build and dependency management tool

## Project Structure
```
PropertyManager_OMKAR_PATIL/
├── src/              # Source code
├── target/           # Compiled output
├── pom.xml           # Maven configuration
├── HELP.md           # Documentation and references
```

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Spring Tool Suite (STS) for development (optional)
- An SQL-compatible database (e.g., MySQL, PostgreSQL)

## Installation

### Using Spring Tool Suite (STS)

1. **Import Project into STS**:
   - Open **Spring Tool Suite (STS)**.
   - Go to `File > Import > Existing Maven Projects`.
   - Navigate to the project directory (`PropertyManager_OMKAR_PATIL`) and click **Finish**.

2. **Build the Project**:
   - Right-click on the project in the Project Explorer.
   - Select `Run As > Maven install` to build the project and resolve dependencies.

3. **Run the Application**:
   - Right-click the project and choose `Run As > Spring Boot App`.
   - The application will start, and you can access it at `http://localhost:8080` (default port).

### Using Command Line

1. **Clone or Copy the Project**:
   - If the project is shared via a repository:
     ```bash
     git clone <repository-url>
     ```
   - If shared via a ZIP file:
     - Extract the ZIP file and navigate to the project folder.

2. **Build the Project**:
   Open a terminal in the project root directory and run:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   Start the application using:
   ```bash
   mvn spring-boot:run
   ```

4. **Configure the Database**:
   Update the `application.properties` file in `src/main/resources` to set up your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/property_manager
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

## Dependencies
Key dependencies included in `pom.xml`:
- **Spring Boot Starter**: For core Spring Boot functionality
- **Spring Boot Starter Data JPA**: For database interaction
- **H2 Database** (optional): Embedded database for testing
- **Lombok**: Simplifies Java code with annotations (e.g., `@Getter`, `@Setter`)
- **Spring Boot Starter Validation**: Provides support for data validation annotations (e.g., `@NotNull`, `@Size`).

## Documentation
For additional details, refer to:
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Guide](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Maven Documentation](https://maven.apache.org/guides/)

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request for review.


