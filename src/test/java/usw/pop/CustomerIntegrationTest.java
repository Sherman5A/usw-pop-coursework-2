package usw.pop;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.testcontainers.containers.PostgreSQLContainer;


/**
 * Test the program's integration with a database
 */
public class CustomerIntegrationTest {

    /*
     Create a temporary database container to test a database's integration with
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


    /**
     * Connect to the database and proceed to clean it of previous entries
     */
    @BeforeEach
    public void setUpCleanDb() {
        // customerDatabase = new CustomerDatabase(postgres.getJbdcUrl());
        // customerDatabase.deleteAll();
    }


    /**
     * Test that {@code customerDatabase} integrates with and adds the customer
     * to the database
     */
    @Test
    @DisplayName("Database create customer")
    public void dbCreateCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com", "3 Cool Road, Swandiff");
        // Add the created customer to the database
        // customerDatabase.addCustomer(customer)
        // Test that customer was created in the database
        // assertEquals("Jake Real", customerDatabase.getCustomerByName("Jake Real").getFullName());
    }

    /**
     * Test that {@code customerDatabase} integrates with and deletes the
     * customer from the database
     */
    @Test
    @DisplayName("Database delete customer")
    public void dbDeleteCustomer() {
        customer = new Customer("Jake Real", "jakeemail@email.com", "3 Cool Road, Swandiff");
        // Add the created customer to the database
        // customerDatabase.addCustomer(customer);
        // Test that customer was created in the database
        // assertEquals("Jake Real", customerDatabase.getCustomerByName("Jake Real").getFullName());
        // Delete the customer from the database
        // customerDatabase.deleteCustomerById(customer.getId);
        // Check that there are no customers
        // assertEquals(0, customerDatabase.getAllCustomers().size());
    }

}
