package usw.pop;

import java.math.BigDecimal;

public class Plane implements Aircraft {

    private final String aircraftName;
    private final String aircraftManufactureer;
    private final String aircraftRegistration;
    private final String aircraftCallsign;
    private final int fuelConsumption;
    private int fuelAmount;
    private BigDecimal currentLatitude;
    private BigDecimal currentLongitude;
    private String currentAirport;


    /**
     * Object that represents a plane
     *
     * @param aircraftName         Name of plane
     * @param aircraftManufacturer Creator of the plane
     * @param aircraftRegistration Plane registration number
     * @param aircraftCallSign     Plane's call sign
     * @param fuelAmount           Amount of fuel in plane at initialisation
     * @param fuelConsumption      Fuel consumption of plane per km
     * @param currentAirport       Airport the plane is currently at
     */
    public Plane(String aircraftName, String aircraftManufacturer, String aircraftRegistration,
                 String aircraftCallSign, int fuelAmount, int fuelConsumption, String currentAirport) {
        this.aircraftName = aircraftName;
        this.aircraftManufactureer = aircraftManufacturer;
        this.aircraftRegistration = aircraftRegistration;
        this.aircraftCallsign = aircraftCallSign;
        this.fuelAmount = fuelAmount;
        this.fuelConsumption = fuelConsumption;
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
