# Theorem Prototype
Greetings !

This project is built using Maven, TestNG and Selenium. I have also integrated Extent reports with the tests to visualize test runs.

My strategy while developing this testing framework was to go breadth first instead of depth. From the client (slack channel) discussions, the request was to create framework so that a junior QA or someone new to automation can take over this work. By covering as many features as possible, I have given them a starting point for writing more tests.

I tried to show various ways of using framework, like parameterizing tests, using custom test listener to do reporting, etc. This approach will be useful for new QA to get started with using various features. 

## How to run tests

#### Prerequisites:

1. You have installed Java 1.8 (JAVA_HOME environment variable points to installation) - [Instructions on how to install Java](https://java.com/en/download/help/download_options.html)
2. You have installed Maven (at least 3.6.3 or above) - [Instructions on how to install Maven](https://maven.apache.org/install.html)

#### Running Tests
* Open command line and go to base of the project, then execute command :

    `mvn clean test`
    
* To run one specific test, you can use command like : 
    
    `mvn -Dtest=CreateAccountTest test`
    
* testng.xml file is included in the project, to use it, uncomment the code in pom.xml and then provide following command :
    
    `mvn clean test -DsuiteXmlFile=testng.xml`
    
## Reports
Reports are generated using extent reports, a sample report is included in the repository. It is located in reports directory at the base of this project.

Whenever new tests are run, they replace the existing report in this directory.
    
## Nice to have if more time given
I would like to -
1. Have test coverage in terms of negative testing and may be adding couple of end-to-end tests which can serve as regression test suit.
2. Add test cases to cover error handling like verifying error messages on Webpages (for example, User authentication failure, Input field validation etc.)
3. Add much more validation based on Client's use cases (for example, In Checkout test, we can add validation for person placing the order, payment type etc.)
4. Put test data in better format rather than just JSON object.
