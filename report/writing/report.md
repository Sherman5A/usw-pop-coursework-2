---
title: "IS1S481 Coursework 2"
author: [ Jake Real - 23056792 ]
date: "10/03/2024"
toc-own-page: true
titlepage: true
titlepage-background: "images/title-background.pdf"
bibliography: "references.bib"
csl: "university-of-south-wales-harvard.csl"
notcite: |
  @testcontainers-java, @stubbing-mocking-mockitio @large-scale-agile
...

# Program UML

![UML Representation of Program](images/uml-build-output.png){height=85%}

# Testing Report

## Introduction

## Automated Testing

The project will make extensive use of automated testing throughout development and deployment.
Automated testing allows a developer to monitor if any defects are present in their codebase without
manually testing and searching for errors, saving time. A report by the National Institute of
Standards & Technology [-@nist-report] reports software bugs are estimated to have cost the United
States of America $59.5 billion annually. They estimated that approximately $22.5 billion, a third of
the cost, could be saved through improvements in testing infrastructure. The impact of automated
testing is not only observed on the macro scale, but also on the team scale. Salesforce, customer
relationship management software provider, reported the following reductions after implementing
automated testing: staff involved in application deployment reduced by 65%, two to 3 hours of final
testing became 10 minutes of automated tests, 3 to 4 hours of post-release testing was handled by 45
minutes automated testing, the patch release team reduced by 80%, and savings of 300 hours per major
release [@succeeding-with-agile]. On the other hand, automated testing has the following
disadvantages: it has higher initial costs than manual testing, knowledge of the test tools is
required, the tests require maintenance, and implementing testing requires either a developer or
testing specialist [@automated-testing-article]. Despite these disadvantages, when automated testing
is implemented early into a project's development its advantages far outweigh the detriments.
Catching errors early without manual testing reduces the cost of finding and then solving them, in
addition to improving the structure of the project, as seen in processes like test-driven development.
Overall, automated testing is an extremely valuable area with a significant role in the project's
development process.


### Testing pyramid

![Testing Pyramid [@google-test-blog]](images/testing-pyramid.png){height=35%}

The automated test structure of the program will follow the testing pyramid strategy created by Mike
Cohn [-@succeeding-with-agile]. His initial interpretation was a pyramid with 3 levels. The bottom
being unit testing, then service testing, and finally, at the top, user interface testing. Various
interpretations have stemmed from Mike Cohn's original design, renaming the pyramid's stages or by
adding additional layers. However, it is agreed that the lowest layers receive the highest time and
processing investment with the largest number of tests. As you ascend the pyramid's layers, the tests
become more infrequent with lower investment. As seen in figure 2, unit tests would have the highest
amount of tests; whereas, end-to-end (E2E) and user interface tests number far fewer, running less
frequently. This is because end-to-end tests, whilst comprehensive, have several disadvantages. Cohn
[-@succeeding-with-agile] lists the drawbacks as, fragility, time cost, and processing cost. E2E
tests are brittle; small changes in the program's user interface could break several tests. Repeated
fixes create discontent and a reluctance to fix the broken test, leaving it useless. Moreover,
effective, non-brittle E2E testing increases development time costs, making a large E2E test suite
impractical. Finally, E2E testing costs more computationally than unit and integration testing,
therefore tests can not run as frequently, decreasing daily coverage compared to unit and integration
testing. On the other hand, unit testing, despite being quick, only deals with small independent
slices of the program, lacking coverage on external services and how they integrate with each
other. Therefore, service, or integration testing, acts middleman to avoid testing external
dependencies such as databases, APIs and user input through the user interface.

The explanation on the testing pyramid provided short insights into the stages. The following will
will explain each layer in further depth and provide example implementations.

### Unit tests

The first stages of testing occur during the development and programming process. Valley Cruises will
use unit tests as its foundation; these tests involve writing isolated
automated tests targeting small sections of the program, known as units. A single project can have
many unit tests; a common amount is one unit test per production class, however even more can be
added. Creation of the unit test involves developing a criteria, referred to as the test case. The
criteria should not be too strict, otherwise the test would break every time code is changed, but it
should not be too general either. A good way to implement unit tests is through check observable 
behaviours; Martin Fowler [-@martin-fowler-pyramid], states, 'think about, if I enter values x and y,
will the result be z? instead of, if I enter x and y, will the method call class A first, then call
class B and then return the result of class A plus the result of class B?'. Testing lots of small 
units that integrate to form a complex program reduces the amount of uncertain variables compared
to a large monolithic end-to-end tests. Unit tests will see use in most of Valley Cruises' production
classes. Within this project, the Java unit testing framework JUnit will be used.

`JUnit5` test for checking in process in `FlightBooking.java`,

```java
public boolean checkIn(){
    if(LocalDateTime.now().isAfter(flight.getFlightStart())){
        hasMissedFlight = true;
        return false;
    }
    hasCheckedIn = true;
    checkInTime = LocalDateTime.now();
    return true;
}
```

The unit test created to test the `checkIn` method in the `FlightBooking` class.

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FlightBookingTest {
    private Flight testFlight;
    private FlightBooking testFlightBooking;


    @Test
    @DisplayName("Check-in process with an on-time flight booking")
    public void checkIn() {
        LocalDateTime earlyDateTime = LocalDateTime.now().plusYears(1);
        /*
         Create a mocked class of testFlight testFlight could use
         an API for plane tracking, so creating a stub ensures that
         the test is independent
        */
        testFlight = Mockito.mock(Flight.class);
        // Set what to return when getFlightStart() is called
        Mockito.when(testFlight.getFlightStart()).thenReturn(
            earlyDateTime
        );

        // Call the check-in process
        testFlightBooking = new FlightBooking(
            testFlight, "economy", 12, 200
        );
        assertTrue(testFlightBooking.checkIn());
    }

    @Test
    @DisplayName("Check-in process with a late flight booking")
    public void checkInLate() {
        LocalDateTime lateDateTime = LocalDateTime.now().minusYears(1);

        // Create another mocked class
        testFlight = Mockito.mock(Flight.class);
        // Set return time to the future to fail check-in
        Mockito.when(testFlight.getFlightStart()).thenReturn(
            lateDateTime
        );

        // Call the check-in process
        testFlightBooking = new FlightBooking(
            testFlight, "economy", 12, 200
        );
        assertFalse(testFlightBooking.checkIn());
    }
}
```

### Integration tests

Integration, or service layer, testing involves verifying that independent components of the program
successfully interact and connect together as expected [@test-automation-theory-practice]. These
independent components could be databases, files, APIs, user inputs, and so on. It is one level above
the isolation of unit tests, but below end-to-end testing. Integration testing is split into 2 areas,
narrow and broad integration testing. The former tests: exercise the code that interacts with the
separate component, use test doubles - not production or development services in the test, and number
in higher numbers than the latter [@martin-fowler-integration-test]. Whereas, broad testing requires
live versions of every service, testing all code paths; not just those that interact with separate
services. Therefore, narrow integration tests will run quicker and provide earlier feedback at the
expense of the test's depth and code coverage. Thus, it is important to use both tests; a sizeable
amount of narrow test regularly running will spot most integration errors. Then, the broad tests can
be run during less frequently, such as during deployment pipelines, to spot any errors that passed
through the narrow tests.

Narrow integration tests can be implemented through many libraries: `JUnit`, `Spring`,
`testcontainers`, or mocking. Valley Cruises' service would require an SQL database for customer
information. This external service would require integration testing with the Customer class and code
that reads the customer information from the database. Using the library `testcontainers`, we create
a temporary isolated SQL database through docker, we then connect to it, interact with the database
through the customer's SQL classes, and check if those interactions propagate to the database. If the
tests succeed, the database and program are successfully integrated. In Valley Cruises application,
narrow integration tests will be used with the service's database for customer, holiday, flight,
and cruise information. Furthermore, narrow intergration tests can be used for any file input or
output in Valley cruises operations; these IO operations may be used to read images, Welsh language
localisation text, or configuration files for the service.

Integration test using `testcontainer` and the `Customer` class [@testcontainers-java],

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test the program's integration with a database
 */
public class CustomerIntegrationTest {

    /*
     Create a temporary database container to test a database's
     integration with the program
    */
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16-alpine");

    Customer customer;
    // CustomerDatabase customerDatabase;

    /**
     * Start the database
     */
    @BeforeAll
    public static void startContainer() {
        postgres.start();
    }

    /**
     * Stop the database container
     */
    @AfterAll
    public static void stopContainer() {
        postgres.stop();
    }

    /**
     * Connect to the database and proceed to clean it of previous
     * entries
     */
    @BeforeEach
    public void setUpCleanDb() {
        customerDatabase = new CustomerDatabase(postgres.getJbdcUrl());
        customerDatabase.deleteAll();
    }

    /**
     * Test that {@code customerDatabase} integrates with and adds
     * the customer to the database
     */
    @Test
    @DisplayName("Database create customer")
    public void dbCreateCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com",
            "3 Cool Road, Swandiff"
        );
        // Add the created customer to the database
        customerDatabase.addCustomer(customer)
        // Test that customer was created in the database
        assertEquals("Jake Real", customerDatabase.getCustomerByName(
            "Jake Real").getFullName()
        );
    }

    /**
     * Test that {@code customerDatabase} integrates with and deletes
     * the customer from the database
     */
    @Test
    @DisplayName("Database delete customer")
    public void dbDeleteCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com",
            "3 Cool Road, Swandiff"
        );
        // Add the created customer to the database
        customerDatabase.addCustomer(customer);
        // Test that customer was created in the database
        assertEquals("Jake Real", customerDatabase.getCustomerByName(
            "Jake Real").getFullName()
        );
        // Delete the customer from the database
        customerDatabase.deleteCustomerById(customer.getId);
        // Check that there are no customers
        assertEquals(0, customerDatabase.getAllCustomers().size());
    }

}
```

In a broad integration test, the process of creating a customer and booking the customer on a holiday
and that integration between these two concepts could be tested. Alternatively, APIs that are
external to Valley Cruise's network such as potential flight tracking APIs would be included in broad
tests due to a lack of control over them.

### Contract Testing

![Contract testing [@martin-fowler-contract-test]](images/contract-testing.png){width=75%}

Integration testing is very effective when the tester controls the external services. However, speed
and reliability decreases when tests occur between internal external, remote services. The external
service can be slow, update with breaking changes, or have downtime. These are very undesirable in a
test. To solve this issue, a test double is created through stubbing the remote service; this is when
the class is emulated by the test software, returning predefined information when called. However, it
is important that the test double is accurate to the remote service otherwise the developer will not
be aware of when changes need to made to code to reflect the service's changes. Therefore, contract
test's are used. Martin Fowler [-@martin-fowler-contract-test] describes them as tests that, 'check
all the calls against your test doubles return the same results as a call to the external service
world'. Failures in the contact tests should alert a developer to look at the codebase and the
external service to check they still integrate well. The test double should then be updated
accordingly. Within the Valley Cruises service, potential uses of the contract test would be
interacting with plane tracking APIs, postcode APIs for customer registration, and interacting with
civil aviation authorities for pilot licencing.

### End-to-end Testing

End-to-end tests cover the entire application, including the user interface. The user interface of
the application is automatically run through by the testing application. Inputs should correctly
trigger their actions, the correct data should be displayed, and the UI states should change when
expected to. [@martin-fowler-broad-stack-test] Furthermore, the layout of the frontend can be
visually tested. As the testing tool proceeds through the service, screenshots of layouts are taken;
these screenshots are compared to previous iterations and control screenshots. Any discrepancies are
flagged to the developers for manual checking [@browserstack-selenium-visual-tests]. End-end-testing's
major advantage is that it exercises the whole application and its connections connected; errors in
components that other tests were unable to find are discovered. However, end-to-end tests are far
more brittle than other testing categories. Browser peculiarities, timings, model dialogues, and
animations can create false positives that have to be debugged. Thus, these tests take more time and
specialists to develop. Moreover, they must be regularly maintained when changes are made to user
interface and data. These tests are far more expensive computationally, taking longer to complete.
Therefore, far fewer of these tests are created and run, in accordance with the testing pyramid, so
high-value scenarios are prioritised. In Valley Cruises' case, browsing the holidays, creating an
account, adding the holiday to the cart, paying for the holiday, and managing holidays in your
account would make good areas to use end-to-end testing on.

End-to-end testing for this project will be implemented by a framework supported in Java - `Selenium`.
`Selenium` uses the browser to automatically call a website, interact and enter data into it, and check
that the correct changes are made. Whilst doing this, `Selenium` can take screenshots of the process,
run in a headless, non-graphical browser, or run on a server with no graphical user interface.

Example of using `Selenium` to test logging in to Valley Cruises,

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private String username = "testing";
    private String password = "testing";

    @BeforeAll
    public static void setUpDriver() throws Exception {
        WebDriverManager.firefoxdriver.setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWebsite() {
        driver.get("https://www.valleycruises.com/login");

        WebElement usernameField = driver.findElement(
            By.id("login-username")
        );
        WebElement passwordField = driver.findElement(
            By.id("login-password")
        );
        WebElement loginButton = driver.findElement(
            By.id("login-button")
        );

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement usernameLabel = driver.findElement(
            By.id("label-username")
        );
        assertEquals(usernameField.getText(), username);
    }
}
```

## Manual Testing

## Conclusion

Building on top of unit testing, continuous integration ensures that all developers within the
organisation:

- feature flags
- ui testing
- test lab
- testing pyramid
- e2e testing - operational - max interaction - require running services - automated ui testing server
- integration testing - testing api code interactions, database connection
- black box testing - less interaction -
- martin fowler testing articles

Should the service require any external APIs. These could be tracking APIs offered by various
airports, or apis offered by the FIA (British equivalent) to ensure that planes are correctly en
route. Then the implementation of contract testing can ensure that updates to API returns and
interfaces are quickly recognised and corrected. To ensure that the service does not suffer for too
long.

End to end user testing.

# References

