package usw.pop;

import java.math.BigDecimal;

public class Helicopter implements Aircraft {
    private String aircraftName;
    private String aircraftRegistration;
    private String aircraftManufacturer;
    private String aircraftCallSign;
    private String currentAirport;
    private BigDecimal currentLatitude;
    private BigDecimal currentLongitude;
    private int fuelAmount;
    private int distanceFuelConsumption;
    private int timeFuelConsumption;

    public Helicopter(String aircraftName, String aircraftRegistration, String aircraftManufacturer,
                      String aircraftCallSign, String currentLocation, int distanceFuelConsumption,
                      int timeFuelConsumption) {
        this.aircraftName = aircraftName;
        this.aircraftRegistration = aircraftRegistration;
        this.aircraftManufacturer = aircraftManufacturer;
        this.aircraftCallSign = aircraftCallSign;
        this.currentAirport = currentLocation;
        this.distanceFuelConsumption = distanceFuelConsumption;
        this.timeFuelConsumption = timeFuelConsumption;
    }

    @Override
    public void fly(int distance) {
        fuelAmount -= distance * distanceFuelConsumption;
    }

    public void hover(int duration) {
        fuelAmount -= duration * timeFuelConsumption;
    }

    @Override
    public void land(String landingLocation) {
        currentAirport = landingLocation;
    }

    @Override
    public void refuel(int addedFuel) {
        fuelAmount += addedFuel;
    }

    @Override
    public void updateLocation(BigDecimal latitude, BigDecimal longitude) {
        this.currentLatitude = latitude;
        this.currentLongitude = longitude;
    }

    // Getters
    @Override
    public String getAircraftName() {
        return aircraftName;
    }

    @Override
    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    @Override
    public BigDecimal getAircraftLat() {
        return currentLatitude;
    }

    @Override
    public BigDecimal getAircraftLong() {
        return currentLongitude;
    }

    @Override
    public String getAircraftAirport() {
        return currentAirport;
    }
}
