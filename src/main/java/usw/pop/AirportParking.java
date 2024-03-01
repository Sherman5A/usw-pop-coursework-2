package usw.pop;

import java.time.LocalDateTime;

/**
 * Manages parking information on a per-car basis for the airport
 */
public class AirportParking {
    private final String parkingID;
    private final String vehicleRegistration;
    private LocalDateTime parkingStart;
    private LocalDateTime parkingEnd;


    /**
     * Creates a parking object containing information about duration and car registered to it
     *
     * @param vehicleRegistration Registration of parked car
     * @param parkingStart        Start date and time of the parking
     * @param parkingEnd          End date and time of the parking
     */
    public AirportParking(String vehicleRegistration, LocalDateTime parkingStart, LocalDateTime parkingEnd) {
        // In complete program, set automatically
        parkingID = "1";
        this.vehicleRegistration = vehicleRegistration;
        this.parkingStart = parkingStart;
        this.parkingEnd = parkingEnd;
    }


    /**
     * Checks if the parking is valid for the object's car
     *
     * @return If parking is still valid, within parkingStart and parkingEnd
     */
    public boolean isParkingValid() {
        return LocalDateTime.now().isAfter(parkingStart) && LocalDateTime.now().isBefore(parkingEnd);
    }

    public String getParkingID() {
        return parkingID;
    }

    public LocalDateTime getParkingEnd() {
        return parkingEnd;
    }

    public void setParkingEnd(LocalDateTime parkingEnd) {
        this.parkingEnd = parkingEnd;
    }

    public LocalDateTime getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(LocalDateTime parkingStart) {
        this.parkingStart = parkingStart;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }
}
