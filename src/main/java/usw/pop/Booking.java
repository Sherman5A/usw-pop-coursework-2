package usw.pop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Booking {
    private final Customer customer;
    private final PackageHoliday packageHoliday;
    private final BigDecimal totalCost;
    private final BigDecimal totalPaid;
    private List<Flight> bookedFlights;
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * @param customer
     * @param packageHoliday
     * @param usePoints
     * @param initialPayment
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
     */
    public Booking(Customer customer, PackageHoliday packageHoliday, boolean usePoints) {
        this(customer, packageHoliday, usePoints, BigDecimal.ZERO);
    }

    public Booking(Customer customer, PackageHoliday packageHoliday, boolean usePoints, BigDecimal initialPayment,
                   List<Flight> bookedFlights) {
        this(customer, packageHoliday, usePoints, initialPayment);
        this.bookedFlights = bookedFlights;
    }
}
