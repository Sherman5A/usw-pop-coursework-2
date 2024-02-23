package usw.pop;

import java.math.BigDecimal;
import java.util.List;

public class ShipCaptain extends Employee {
    private int yearsCaptain;
    private Ship currentShip;
    private List<Ship> shipHistory;

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
}
