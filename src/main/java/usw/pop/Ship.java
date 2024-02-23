package usw.pop;

import java.util.List;

public class Ship {
    private String shipName;
    private String registeredCountry;
    private Cruise currentCruise;
    private List<Cruise> previousCruises;
    private ShipCrew shipCrew;


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

    public void setPreviousCruises(List<Cruise> previousCruises) {
        this.previousCruises = previousCruises;
    }

    public ShipCrew getShipCrew() {
        return shipCrew;
    }

    public void setShipCrew(ShipCrew shipCrew) {
        this.shipCrew = shipCrew;
    }
}
