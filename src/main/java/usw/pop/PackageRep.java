package usw.pop;

import java.math.BigDecimal;
import java.util.List;

public class PackageRep extends Employee {
    private List<Hotel> attendingHotels;
    private Cruise attendingCruise;


    public PackageRep(String employeeName, String address, BigDecimal salary, int phoneNum, List<Hotel> attendingHotels) {
        super(employeeName, address, salary, phoneNum);
        this.attendingHotels = attendingHotels;
    }

    public PackageRep(String employeeName, String address, BigDecimal salary, int phoneNum, Cruise attendingCruise) {
        super(employeeName, address, salary, phoneNum);
        this.attendingCruise = attendingCruise;
    }

    public Cruise getAttendingCruise() {
        return attendingCruise;
    }

    public void setAttendingCruise(Cruise attendingCruise) {
        this.attendingCruise = attendingCruise;
    }

    public List<Hotel> getAttendingHotels() {
        return attendingHotels;
    }

    public void setAttendingHotels(List<Hotel> attendingHotels) {
        this.attendingHotels = attendingHotels;
    }
}
