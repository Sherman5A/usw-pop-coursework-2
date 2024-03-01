package usw.pop;

import java.math.BigDecimal;

/**
 * Interface that representing an aircraft
 */
public interface Aircraft {
    void fly(int distance);

    void land(String landingLocation);

    void refuel(int fuelAmount);

    void updateLocation(BigDecimal latitude, BigDecimal longitude);

    String getAircraftName();

    String getAircraftRegistration();

    BigDecimal getAircraftLat();

    BigDecimal getAircraftLong();

    String getAircraftAirport();
}
