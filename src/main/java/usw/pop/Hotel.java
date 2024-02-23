package usw.pop;

import java.util.List;


/**
 * Class that represents a hotel
 */
public class Hotel {
    private String hotelName;
    private String hotelAddress;
    private boolean hasCatering;
    private int hotelStars;
    private List<HotelRoom> hotelRooms;
    private PackageRep hotelPackageRep;

    public Hotel(String hotelName, String hotelAddress, boolean hasCatering, int hotelStars,
                 List<HotelRoom> hotelRooms, PackageRep hotelPackageRep) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hasCatering = hasCatering;
        this.hotelStars = hotelStars;
        this.hotelRooms = hotelRooms;
        this.hotelPackageRep = hotelPackageRep;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public boolean isHasCatering() {
        return hasCatering;
    }

    public void setHasCatering(boolean hasCatering) {
        this.hasCatering = hasCatering;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public List<HotelRoom> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(List<HotelRoom> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public int getNumHotelRooms() {
        return hotelRooms.size();
    }

    public PackageRep getHotelPackageRep() {
        return hotelPackageRep;
    }

    public void setHotelPackageRep(PackageRep hotelPackageRep) {
        this.hotelPackageRep = hotelPackageRep;
    }
}
