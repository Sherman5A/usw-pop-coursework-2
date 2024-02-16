package usw.pop;

import java.math.BigDecimal;

public class CabinCrew extends Employee {
    private CabinCrewRank crewRank;

    public CabinCrew(String employeeName, String address, BigDecimal salary, int phoneNum, CabinCrewRank crewRank) {
        super(employeeName, address, salary, phoneNum);
        this.crewRank = crewRank;
    }

    public CabinCrewRank getCrewRank() {
        return crewRank;
    }

    public void setCrewRank(CabinCrewRank crewRank) {
        this.crewRank = crewRank;
    }
}
