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
}
