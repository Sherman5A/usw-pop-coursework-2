package usw.pop;

import java.math.BigDecimal;
import java.util.List;


/**
 * Representative of the holiday company. Placed on various Hotels or cruises
 */
public class PackageRep extends Employee {
    private List<Hotel> attendingHotels;
    private Cruise attendingCruise;


    /**
     * Creates a PackageRep that is attending to Hotels
     *
     * @param attendingHotels List of hotels that the package rep visits
     */
    public PackageRep(String employeeName, String address, BigDecimal salary, int phoneNum,
                      List<Hotel> attendingHotels) {
        super(employeeName, address, salary, phoneNum);
        this.attendingHotels = attendingHotels;
    }


    /**
     * Creates a PackageRep that works on a cruise
     *
     * @param attendingCruise The {@code Cruise} that the PackageRep is attending to
     */
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
