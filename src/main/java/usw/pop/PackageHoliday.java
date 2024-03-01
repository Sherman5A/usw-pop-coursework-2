package usw.pop;

import java.math.BigDecimal;

/**
 * Pre-made Holiday that a {@code Customer} can buy
 */
public class PackageHoliday {
    private String packageHolidayID;
    private HolidayType holidayType;
    private Hotel hotel;
    private Cruise cruise;
    private BigDecimal baseCost;
    private boolean isAllInclusive;
    private boolean hasPreCruiseHotel;
    private boolean includesFlights;


    /**
     * Creates a single package holiday that has hotels as accommodation
     *
     * @param hotel           The hotel that the package holiday includes
     * @param includesFlights Whether the package holiday includes the flight bookings
     * @param isAllInclusive  Whether the food is included within the holiday price
     * @param baseCost        The base cost of the holiday without any discounts
     */
    public PackageHoliday(Hotel hotel, BigDecimal baseCost, boolean isAllInclusive, boolean includesFlights) {
        // Would be set automatically in a complete system
        this.hotel = hotel;
        this.baseCost = baseCost;
        this.isAllInclusive = isAllInclusive;
        this.includesFlights = includesFlights;
    }


    /**
     * Creates a single package holiday that has a cruise as accommodation
     *
     * @param cruise            The cruise that the package holiday includes
     * @param baseCost          The base cost of the holiday without any discounts
     * @param isAllInclusive    Whether the cruise food is all-inclusive
     * @param hasPreCruiseHotel If the package includes a hotel to sleep in prior to boarding the ship
     * @param includesFlights   If the package includes any flights to the origin / destination port location
     */
    public PackageHoliday(Cruise cruise, BigDecimal baseCost, boolean isAllInclusive, boolean hasPreCruiseHotel,
                          boolean includesFlights) {
        // Would be set automatically in a complete system
        this.cruise = cruise;
        this.baseCost = baseCost;
        this.isAllInclusive = isAllInclusive;
        this.hasPreCruiseHotel = hasPreCruiseHotel;
        this.includesFlights = includesFlights;
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
