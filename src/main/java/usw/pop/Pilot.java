package usw.pop;

import java.math.BigDecimal;

/**
 * Class represents a real-life pilot
 */
public class Pilot extends Employee {
    private String licenceID;
    private String licenceType;
    private int daysFlown;


    /**
     * Creates a new pilot
     *
     * @param licenceID   The ID of the licence
     * @param licenceType The type of pilot licence owned
     */
    public Pilot(String employeeName, String address, BigDecimal salary, int phoneNum, String licenceID,
                 String licenceType) {
        super(employeeName, address, salary, phoneNum);
        this.licenceID = licenceID;
        this.licenceType = licenceType;
    }


    /**
     * Adds a number of days flown to the pilot's data
     *
     * @param addDays Number of additional days flown
     */
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
