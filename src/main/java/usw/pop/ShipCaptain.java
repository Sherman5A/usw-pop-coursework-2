package usw.pop;

import java.math.BigDecimal;
import java.util.List;

public class ShipCaptain extends Employee {
    private int yearsCaptain;
    private Ship currentShip;
    private List<Ship> shipHistory;

    /**
     * Creates a captain object
     *
     * @param currentShip The ship the captain is currently in command of
     */
    public ShipCaptain(String employeeName, String address, BigDecimal salary, int phoneNum, Ship currentShip) {
        super(employeeName, address, salary, phoneNum);
        this.currentShip = currentShip;
    }

    public List<Ship> getShipHistory() {
        return shipHistory;
    }

    public void addShipToHistory(Ship ship) {
        shipHistory.add(ship);
    }

    public int getYearsCaptain() {
        return yearsCaptain;
    }

    public void incrementYearsCaptain() {
        this.yearsCaptain++;
    }

    public Ship getCurrentShip() {
        return currentShip;
    }

    public void setCurrentShip(Ship currentShip) {
        this.currentShip = currentShip;
    }

    public void addShipHistory(Ship previousShip) {
        shipHistory.add(previousShip);
    }
}
