package usw.pop;

import java.math.BigDecimal;

public class CabinCrew extends Employee {
    private String crewRank;

    public CabinCrew(String employeeName, String address, BigDecimal salary, int phoneNum, String crewRank) {
        super(employeeName, address, salary, phoneNum);
        this.crewRank = crewRank;
    }

    public String getCrewRank() {
        return crewRank;
    }

    public void setCrewRank(String crewRank) {
        this.crewRank = crewRank;
    }
}
