API Test Automation Framework

## Now the Design Pattern:

Service Objects are a design pattern commonly used in software development, particularly in web applications,
to encapsulate business logic and keep it separate from other layers of the application.

Technologies Used
Java 11
TestNG
Log4j
Extent Reports
Filters

Code Structure

com.api
├── services
│   ├── BaseService.java
│   └── AuthService.java
├── models
│   ├── request
│   │   └── LoginRequest.java
│   └── response
│       └── LoginResponse.java
└── tests
     └── AuthTest.java
#In BaseService class:
All common component in all service kept in side the BaseService class
.base url
.Creating the request
.Response handling

public class BaseService {
    public static final BASE_URL=" base url";
    public RequestSpecification requestSpec;

    #constructor-
    public BaseService() {
        requestSpec = RestAssured.given()
            .baseUri(ConfigManager.getBaseUrl())
           
    }
}

    
