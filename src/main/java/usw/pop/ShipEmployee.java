package usw.pop;

import java.math.BigDecimal;

public class ShipEmployee extends Employee {
    private ShipCrewType crewType;
    private int bunkNumber;


    /**
     * @param crewType The type of crew member
     */
    public ShipEmployee(String employeeName, String address, BigDecimal salary, int phoneNum, ShipCrewType crewType) {
        super(employeeName, address, salary, phoneNum);
        this.crewType = crewType;
    }

    public ShipCrewType getCrewType() {
        return crewType;
    }

    public void setCrewType(ShipCrewType crewType) {
        this.crewType = crewType;
    }

    public int getBunkNumber() {
        return bunkNumber;
    }

    public void setBunkNumber(int bunkNumber) {
        this.bunkNumber = bunkNumber;
    }
}
