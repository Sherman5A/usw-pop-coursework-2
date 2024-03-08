package usw.pop;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;


/**
 * Test the program's integration with a database
 */
public class CustomerIntegrationTest {

    /*
     Create a temporary database container to test database's interactions with
     the program
    */
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

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

    @BeforeEach
    public void cleanDb() {
        // customerDatabase = new CustomerDatabase(postgres.getJbdcUrl());
        // customerDatabase.deleteAll();
    }


    @Test
    public void dbCreateCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com", "3 Cool Road, Swandiff");
        // Add the created customer to the database
        // customerDatabase.addCustomer(customer)
        // Test that customer was created in the database
        // assertEquals("Jake Real", customerDatabase.getCustomerByName("Jake Real").getFullName);
    }

    public void dbDeleteCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com", "3 Cool Road, Swandiff");
        // Add the created customer to the database
        // customerDatabase.addCustomer(customer);
        // Test that customer was created in the database
        // assertEquals("Jake Real", customerDatabase.getCustomerByName("Jake Real").getFullName);
        // Delete the customer from the database
        // customerDatabase.deleteCustomerById(customer.getId);
        // Check that there are no customers
        // assertEquals(0, customerDatabase.getAllCustomers().size());
    }

}
