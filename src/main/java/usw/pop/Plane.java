package usw.pop;

import java.math.BigDecimal;

public class Plane implements Aircraft {

    private final String aircraftName;
    private final String aircraftManufactureer;
    private final String aircraftRegistration;
    private final String aircraftCallsign;
    private int fuelAmount;
    private final int fuelConsumption;
    private final String registeredAirport;
    private BigDecimal currentLat;
    private BigDecimal currentLong;
    private String currentAirport;


    public Plane(String aircraftName, String aircraftManufacturer, String aircraftRegistration,
                 String aircraftCallsign, int fuelAmount, int fuelConsumption, String registeredAirport,
                 String currentAirport) {
        this.aircraftName = aircraftName;
        this.aircraftManufactureer = aircraftManufacturer;
        this.aircraftRegistration = aircraftRegistration;
        this.aircraftCallsign = aircraftCallsign;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
        this.registeredAirport = registeredAirport;
        this.currentAirport = currentAirport;
    }

    @Override
    public void fly(int distance) {
        fuelAmount -= distance * fuelConsumption;
    }

    @Override
    public void land(String landingAirport) {
        currentAirport = landingAirport;
    }

    @Override
    public void refuel(int addedFuel) {
        this.fuelAmount += addedFuel;
    }

    @Override
    public void updateLocation(BigDecimal latitude, BigDecimal longitude) {
        this.currentLat = latitude;
        this.currentLong = longitude;
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
        return currentLat;
    }

    @Override
    public BigDecimal getAircraftLong() {
        return currentLong;
    }

    @Override
    public String getAircraftAirport() {
        return currentAirport;
    }
}
