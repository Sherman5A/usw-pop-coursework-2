package usw.pop;

import java.util.List;

/**
 * Class representing the ship
 */
public class Ship {
    private final String shipName;
    private final String registeredCountry;
    private Cruise currentCruise;
    private List<Cruise> previousCruises;
    private ShipCrew shipCrew;

    /**
     * Create an object {@code Ship}
     *
     * @param shipName          Name of the ship
     * @param registeredCountry The country the ship is registered in
     * @param shipCrew          The crew of the ship
     */
    public Ship(String shipName, String registeredCountry, ShipCrew shipCrew) {
        this.shipName = shipName;
        this.registeredCountry = registeredCountry;
        this.shipCrew = shipCrew;
    }

    public String getShipName() {
        return shipName;
    }

    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setCurrentCruise(Cruise currentCruise) {
        this.currentCruise = currentCruise;
    }

    public List<Cruise> getPreviousCruises() {
        return previousCruises;
    }

    public void addPreviousCruises(Cruise previousCruise) {
        this.previousCruises.add(previousCruise);
    }

    public ShipCrew getShipCrew() {
        return shipCrew;
    }

    public void setShipCrew(ShipCrew shipCrew) {
        this.shipCrew = shipCrew;
    }
}
