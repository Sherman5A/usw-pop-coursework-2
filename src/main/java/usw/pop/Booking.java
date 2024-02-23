package usw.pop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Class that acts as an intermediary, between PackageHoliday and Customer
 * Handles booking information unrelated to the package: booked flights,
 * costs, and dates
 */
public class Booking {
    private final Customer customer;
    private final PackageHoliday packageHoliday;
    private final BigDecimal totalCost;
    private final BigDecimal totalPaid;
    private List<Flight> bookedFlights;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * Creates an instance of the Booking class
     *
     * @param customer       The customer account that is booking the holiday
     * @param packageHoliday The package holiday the customer is booking
     * @param usePoints      Whether to use the customers points to reduce the price
     * @param initialPayment The initial payment of the customer
     */
    public Booking(Customer customer, PackageHoliday packageHoliday, boolean usePoints, BigDecimal initialPayment) {
        this.customer = customer;
        this.packageHoliday = packageHoliday;
        totalCost = (usePoints) ? packageHoliday.getPrice().subtract(customer.usePoints()) : packageHoliday.getPrice();
        totalPaid = initialPayment;
    }

    /**
     * @param customer
     * @param packageHoliday
     * @param usePoints
     * @see Booking#Booking(Customer, PackageHoliday, boolean, BigDecimal)  Booking
     */
    public Booking(Customer customer, PackageHoliday packageHoliday, boolean usePoints) {
        this(customer, packageHoliday, usePoints, BigDecimal.ZERO);
    }


    /**
     * @param customer
     * @param packageHoliday
     * @param usePoints
     * @param initialPayment
     * @param bookedFlights
     * @see Booking#Booking(Customer, PackageHoliday, boolean, BigDecimal) Base booking class
     */
    public Booking(Customer customer, PackageHoliday packageHoliday, boolean usePoints, BigDecimal initialPayment,
                   List<Flight> bookedFlights) {
        this(customer, packageHoliday, usePoints, initialPayment);
        this.bookedFlights = bookedFlights;
    }
}
