package usw.pop;

import java.util.List;

public class ShipCrew {
    private ShipCaptain shipCaptain;
    private List<ShipEmployee> shipEmployees;

    public ShipCrew(ShipCaptain shipCaptain, List<ShipEmployee> shipEmployees) {
        this.shipCaptain = shipCaptain;
        this.shipEmployees = shipEmployees;
    }

    public void addShipEmployee(ShipEmployee shipEmployee) {
        shipEmployees.add(shipEmployee);
    }

    public ShipCaptain getShipCaptain() {
        return shipCaptain;
    }

    public void setShipCaptain(ShipCaptain shipCaptain) {
        this.shipCaptain = shipCaptain;
    }

    public List<ShipEmployee> getShipEmployees() {
        return shipEmployees;
    }

    public void setShipEmployees(List<ShipEmployee> shipEmployees) {
        this.shipEmployees = shipEmployees;
    }
}
