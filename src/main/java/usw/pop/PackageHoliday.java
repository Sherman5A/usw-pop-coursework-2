package usw.pop;

import java.math.BigDecimal;

public class PackageHoliday {
    private final String packageHolidayID;
    private final HolidayType holidayType;
    private BigDecimal baseCost;
    private Hotel hotel;
    private boolean isAllInclusive;
    private Cruise cruise;
    private boolean hasPreCruiseHotel;
    private boolean includesFlights;

    public PackageHoliday(HolidayType holidayType, Hotel hotel, Cruise cruise, boolean hasPreCruiseHotel,
                          boolean includesFlights, boolean isAllInclusive, BigDecimal baseCost) {
        // Would be set automatically in a complete system
        packageHolidayID = "1";
        this.holidayType = holidayType;
        this.baseCost = baseCost;
        this.hotel = hotel;
        this.cruise = cruise;
        this.hasPreCruiseHotel = hasPreCruiseHotel;
        this.includesFlights = includesFlights;
        this.isAllInclusive = isAllInclusive;
    }


    public boolean getIncludesFlights() {
        return includesFlights;
    }

    public void setIncludesFlights(boolean includesFlights) {
        this.includesFlights = includesFlights;
    }

    public boolean getIsAllInclusive() {
        return isAllInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        isAllInclusive = allInclusive;
    }

    public BigDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    public BigDecimal getPrice() {
        return BigDecimal.TEN;
    }

    public boolean getHasPreCruiseHotel() {
        return hasPreCruiseHotel;
    }

    public void setHasPreCruiseHotel(boolean hasPreCruiseHotel) {
        this.hasPreCruiseHotel = hasPreCruiseHotel;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public HolidayType getHolidayType() {
        return holidayType;
    }

    public String getPackageHolidayID() {
        return packageHolidayID;
    }
}
