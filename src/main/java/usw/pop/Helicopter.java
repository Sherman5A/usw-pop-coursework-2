package usw.pop;

import java.math.BigDecimal;

public class Helicopter implements Aircraft {
    private final String aircraftName;
    private final String aircraftRegistration;
    private final String aircraftManufacturer;
    private final String aircraftCallSign;
    private final int distanceFuelConsumption;
    private final int timeFuelConsumption;
    private String currentAirport;
    private BigDecimal currentLatitude;
    private BigDecimal currentLongitude;
    private int fuelAmount;


    /**
     * Object representing a helicopter with its registration information
     *
     * @param aircraftName            Name of helicopter
     * @param aircraftRegistration    Helicopter registration number
     * @param aircraftManufacturer    Creator of helicopter
     * @param aircraftCallSign        Call sign of helicopter
     * @param currentAirport          Airport the helicopter is currently at
     * @param distanceFuelConsumption How much fuel the helicopter uses per kilometer
     * @param timeFuelConsumption     How much fuel the helicopter uses over time
     */
    public Helicopter(String aircraftName, String aircraftRegistration, String aircraftManufacturer,
                      String aircraftCallSign, String currentAirport, int distanceFuelConsumption,
                      int timeFuelConsumption) {
        this.aircraftName = aircraftName;
        this.aircraftRegistration = aircraftRegistration;
        this.aircraftManufacturer = aircraftManufacturer;
        this.aircraftCallSign = aircraftCallSign;
        this.currentAirport = currentAirport;
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


    /**
     * Land at an airport
     *
     * @param landingLocation Airport landing at
     */
    @Override
    public void land(String landingLocation) {
        currentAirport = landingLocation;
    }


    /**
     * Refuel the helicopter
     *
     * @param addedFuel Additional fuel
     */
    @Override
    public void refuel(int addedFuel) {
        fuelAmount += addedFuel;
    }


    /**
     * Update the location of the Helicopter
     *
     * @param latitude  New latitude of Helicopter
     * @param longitude New longitude of Helicopter
     */
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
