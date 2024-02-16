package usw.pop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String fullName;
    private String email;
    private String address;
    private LocalDate signUpDate;
    private BigDecimal amountSpent;
    private BigDecimal packagePoints;
    private List<Booking> packageBookings = new ArrayList<>();

    public Customer(String fullName, String email, String address) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.signUpDate = LocalDate.now();
        this.amountSpent = BigDecimal.ZERO;
        this.packagePoints = BigDecimal.ZERO;
    }

    public void addBooking(Booking newBooking) {
        packageBookings.add(newBooking);
//        packagePoints += newBooking
    }

    public BigDecimal usePoints() {
        BigDecimal usePoints = packagePoints;
        packagePoints = BigDecimal.ZERO;
        return usePoints;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getPackageBookings() {
        return packageBookings;
    }
}
