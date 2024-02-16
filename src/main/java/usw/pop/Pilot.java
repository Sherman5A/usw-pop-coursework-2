package usw.pop;

import java.math.BigDecimal;

public class Pilot extends Employee {
    private String licenceID;
    private String licenceType;
    private int daysFlown;


    public Pilot(String employeeName, String address, BigDecimal salary, int phoneNum, String licenceID,
                 String licenceType) {
        super(employeeName, address, salary, phoneNum);
        this.licenceID = licenceID;
        this.licenceType = licenceType;
    }


    public void addDaysFlown(int addDays) {
        this.daysFlown += addDays;
    }

    // Getters
    public int getDaysFlown() {
        return daysFlown;
    }

    public String getLicenceID() {
        return licenceID;
    }

    public void setLicenceID(String licenceID) {
        this.licenceID = licenceID;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }
}
