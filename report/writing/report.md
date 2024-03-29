---
title: "IS1S481 Coursework 2"
author: [ Jake Real - 23056792 ]
date: "13/03/2024"
toc-own-page: true
titlepage: true
titlepage-background: "images/title-background.pdf"
bibliography: "references.bib"
csl: "university-of-south-wales-harvard.csl"
notcite: |
  @testcontainers-java, @stubbing-mocking-mockitio @large-scale-agile, @large-scale-agile
...

# Program UML

![UML Representation of Program](images/uml-build-output.png){height=85%}

# Testing Report

## Introduction

Testing is the process of examining software's behaviour to check that it meets the required
specifications of services without errors arising. The process provides information concerning the
software under the conditions that the test is run under; however, it only guarantees that the
software will not fail under those specific conditions. Thus, it is imperative that the companies
testing strategy is comprehensive and covers most facets of the service to avoid undetected faults.
Achieving large test coverage manually would require people hours from the company, increasing
the cost and length of development. To tackle this problem, this report outlines a testing strategy
making use of both manual and automated, computer-operated test strategies to achieve high coverage
testing without major slowdowns in releases, or considerable expansions to testers and the quality
assurance team.

## Automated Testing

The company makes extensive use of automated testing throughout development and deployment.
Automated testing allows developers to monitor if any defects are present in the codebase without
manually testing and searching for errors, saving time. A report by the National Institute of
Standards & Technology [-@nist-report] reports software bugs are estimated to have cost the United
States of America $59.5 billion annually. They estimated that approximately $22.5 billion, a third of
the cost, could be saved through improvements to testing infrastructure. The impact of automated
testing is not only observed on the macro scale, but also on the team scale. Salesforce, a customer
relationship management software provider, reported the following reductions after implementing
automated testing: the amount of staff involved in application deployment reduced by 65%,
two to 3 hours of final testing was reduced to 10 minutes of automated tests, 3 to 4 hours of
post-release testing was handled by 45 minutes automated testing, the patch release team was reduced by
80%, and, overall, Salesforce acheived savings of 300 hours per major release [@succeeding-with-agile].
On the other hand, automated testing has the following disadvantages: it has higher initial costs than
manual testing, knowledge of the test tools is required, the tests require maintenance, and implementing
testing requires either a developer or testing specialist [@automated-testing-article]. Despite these
disadvantages, when automated testing is implemented early into a project's development its advantages
far outweigh its detriments. Catching errors early without manual testing reduces the cost of finding
and then solving them. Furthermore, it improves the structure of the project by clearly defining goals
and user journeys, as seen in processes like test-driven development. Overall, automated testing
is an extremely valuable area with a significant role in the company's development process.


### Testing pyramid

![Testing Pyramid [@google-test-blog]](images/testing-pyramid.png){height=35%}

The companies automated test structure follows the testing pyramid strategy created by Mike
Cohn [-@succeeding-with-agile]. His initial interpretation was a pyramid with 3 levels. The bottom
being unit testing, then service testing, and finally, at the top, user interface testing. Various
interpretations have stemmed from Mike Cohn's original design, renaming the pyramid's stages or by
adding additional layers. However, it is agreed that the lowest layers receive the highest time and
processing investment with the largest number of tests. As you ascend the pyramid's layers, the tests
become more infrequent with lower investment. As seen in figure 2, unit tests have the highest
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
explain each layer in further depth and provide examples implementations from the company.

### Unit tests

The first stages of testing occur during the development and programming process. The company
uses unit tests as its foundation; these tests involve writing isolated
automated tests targeting small sections of the program, known as units. A single project can have
many unit tests; a common amount is one unit test per production class, however even more can be
added. Creation of the unit test involves developing a criteria, referred to as the test case. The
criteria should not be too strict, otherwise the test would break every time code is changed, but it
should not be too general either. A good way to implement unit tests is through check observable
behaviours; Martin Fowler [-@martin-fowler-pyramid], states, 'think about, if I enter values x and y,
will the result be z? instead of, if I enter x and y, will the method call class A first, then call
class B and then return the result of class A plus the result of class B?'. Testing lots of small
units that integrate to form a complex program reduces the amount of uncertain variables compared
to a large monolithic end-to-end tests. Unit tests are used in most of the companies production
classes to ensure good coverage of the entire codebase. Within the company, the Java unit testing
framework `JUnit` is used.

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
independent components include be databases, files, APIs, user inputs, and so on. These tests are
one level above the isolation of unit tests, but below end-to-end testing. Integration testing is
split into 2 areas, narrow and broad integration testing. The former tests: exercise the code that
interacts with the separate component, use test doubles - not production or development services in
the test, and number in higher numbers than the latter [@martin-fowler-integration-test]. Whereas,
broad testing requires live versions of every service, testing all code paths; not just those that
interact with separate services. Therefore, narrow integration tests will run quicker and provide
earlier feedback at the expense of the test's depth and code coverage. Thus, it is important to use
both tests; a sizeable amount of narrow tests regularly running will spot most integration errors.
Then, the broad tests can be run less frequently, such as during deployment pipelines, to spot
any errors that passed through the narrow tests.

Narrow integration tests are implemented through many libraries like: `JUnit`, `Spring`, and
`testcontainers`. Valley Cruises' service requires an SQL database for customer
information. This external service needs integration testing with the Customer class and code
that reads the database. Using the library `testcontainers`, temporary isolated SQL database through
docker, we then connect to it, interact with the database through the customer's SQL classes, and check
if those interactions propagate to the database. If the tests succeed, the database and program are
successfully integrated. In Valley Cruises application, narrow integration tests will be used with the
service's database for customer, holiday, flight, and cruise information. Furthermore, narrow
integration tests can be used for any file input or outputs; these could be reading images,
Welsh language localisation text, or configuration files for the service.

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
and integration between these two concepts is tested. In addition, APIs that are external to Valley
Cruise's network such as flight tracking APIs are undergo broad testing due to a lack of control over
them.

### Contract Testing

![Contract testing [@martin-fowler-contract-test]](images/contract-testing.png){width=75%}

Integration testing is very effective when the tester controls the external services. However, speed
and reliability decreases when tests occur between internal and external, remote services. The external
service can be slow, update with breaking changes, or have downtime. These are very undesirable in a
test. To solve this issue, a test double is created through stubbing the remote service; this is when
the class is emulated by the test software, returning predefined information when called. However, it
is important that the test double is accurate to the remote service otherwise the company will not
be aware when changes must be made to reflect the service's changes. Therefore, contract
test's are used. Martin Fowler [-@martin-fowler-contract-test] describes them as tests that, 'check
all the calls against your test doubles return the same results as a call to the external service
world'. Failures in the contact tests alert the developers to check the codebase and
external service to verify they still integrate well. The test double are then updated accordingly.
Within the Valley Cruises service, contract tests are used when interacting with plane tracking APIs,
postcode APIs for customer registration, civil aviation authorities for pilot licencing.

### End-to-end Testing

End-to-end tests cover the entire application. The frontend user interface of the application is
automatically run through by the testing application. Inputs should correctly
trigger their actions, the correct data should be displayed, and the UI states should change when
expected to [@martin-fowler-broad-stack-test]. Furthermore, the layout of the frontend can be
visually tested. As the testing tool proceeds through the service, screenshots of the layouts are taken;
these screenshots are compared to previous iterations and set control screenshots. Any discrepancies are
flagged to the developers for manual checking [@browserstack-selenium-visual-tests]. End-end-testing's
major advantage is that it exercises the whole application and its connections, discovering errors in
components that other tests were unable to find. However, end-to-end tests are far
more brittle than other tests. Browser peculiarities, timings, modal dialogues, and
animations can create false positives that have to be debugged. Thus, these tests take more time and
specialists to develop. Moreover, they must be regularly maintained when changes are made to user
interface and data. Finally, these tests are far more expensive computationally, taking longer to complete.
Therefore, far fewer of these tests are created and run, in accordance with the testing pyramid, so
high-value scenarios are prioritised. In Valley Cruises' case, browsing the holidays, creating an
account, adding the holiday to the cart, paying for the holiday, and managing holidays in your
account would areas that use end-to-end tests.

End-to-end testing for this project is implemented by a framework supported in Java - `Selenium`.
`Selenium` uses the browser to automatically call a website, interact and enter data into it, and then
check that the correct changes are made. Whilst doing this, `Selenium` can take screenshots of
the process, run in a headless, non-graphical browser, or run on a server with no graphical
user interface.

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

Manual testing is when testers go through the program, using its features and checking for correct
behaviour. The testers follow a test plan that describes the scope, methodology, schedule, needed
resources and tools that are allocated for the test; this plan forms the general structure of
the test. The tester then follows multiple more detailed test cases. These outline the: steps taken
by the tester, the expected outcomes of said tests, and after testing, the actual outcomes of the
test and whether it passed or failed. Various test cases can be seen in tables 1 and 2.
Manual testing is most suitable for testing areas where
automation and computers fail. These are: accessibility testing, computers are unable emulate how
a visually impaired people will screen readers to access a service; layout testing, computers
struggle to find visual defects in programs so manually testing on different layouts and screens
is preferred; and exploratory testing, which emphasises tester freedom resulting in tests that
cover areas that automation might miss. The company aims for a split of 75% automated testing
with 25% manual testing, striking a balance between speed and cost.

---------------------------------------------------------------------------------------------------------------------------------------------------------
Test          Test                       Reason                                                                     Expected           Actual
number        data                                                                                                  outcome            outcome
------------- -------------------------- -------------------------------------------------------------------------- ------------------ ------------------
1             Password = testing123@@    Test that a password meeting the requirements of containing                Valid password     Valid password
                                         more 7 characters or more, 2 or more numbers and symbols is
                                         accepted


2             Password = testing123      Test that a password not meeting the requirements of containing            Invalid password   Invalid password
                                         more 7 characters or more, 2 or more numbers and symbols is not accepted


3             Password = testing@@#      Test that a password not meeting the requirements of containing            Invalid password   Invalid password
                                         more 7 characters or more, 2 or more numbers and symbols is not accepted

4             Password = testing         Test that a password not meeting the requirements of containing            Invalid password   Invalid password
                                         more 7 characters or more, 2 or more numbers and symbols is not accepted

---------------------------------------------------------------------------------------------------------------------------------------------------------

Table: Tests for password input in frontend,


---------------------------------------------------------------------------------------------------------------------------------------------------------
Test          Test                       Reason                                                                     Expected           Actual
number        data                                                                                                  outcome            outcome
------------- -------------------------- -------------------------------------------------------------------------- ------------------ ------------------
1             Search = £2000             Test that a valid search amount correctly returns a search query           Valid search       Valid search

2             Search = -£2000            Test that a negative money search amounts does not return a search         Invalid search     Invalid search
                                         query as negative money is not possible

---------------------------------------------------------------------------------------------------------------------------------------------------------

Table: Tests for searching by price in frontend,

### Static Testing

Finally, static testing is a subset of manual testing in which the program is not executed. Static
tests involve checking that the program is fault tolerant. Code is checked for preconditons. These
alter control flow to ensure potentailly errenous values are not passed to problematic statements.
For exmaple, using an `if` statement to prevent passing 0 as a divisor, or preventing negative numbers
from being the radicand in a root.


## Conclusion

In conclusion, the company uses a mixed testing strategy of automated and manual tests with a bias to
automation. The structure of the automated tests follows the testing pyramid, with many unit tests, a
medium number of integration and contract tests, and finally a fewer amount of end-to-end tests.
This strategy results in a bottom-up approach to automated testing where most errors should be caught
before the final end-to-end testing, ensuring that they are caught quickly before causing costing
considerable resources to fix. The manual testing process covers areas that are difficult or too in
depth to be automated, such as layout testing, accessibility testing, and freely exploring
through the program. Overall, the testing strategy of the company attempts to ensure fast development,
whilst keeping good testing coverage of the released program in an attempt to catch errors prior to
public release.

# References

