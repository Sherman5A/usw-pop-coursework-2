package usw.pop;

import java.time.LocalDateTime;

public class AirportParking {
    private final String parkingID;
    private final String vehicleRegistration;
    private LocalDateTime parkingStart;
    private LocalDateTime parkingEnd;

    public AirportParking(String vehicleRegistration, LocalDateTime parkingStart, LocalDateTime parkingEnd) {
        // In complete program, set automatically
        parkingID = "1";
        this.vehicleRegistration = vehicleRegistration;
        this.parkingStart = parkingStart;
        this.parkingEnd = parkingEnd;
    }

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
