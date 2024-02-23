package usw.pop;

public class HotelRoom {
    private final Hotel hotel;
    private final int roomNumber;
    private final int roomFloor;
    private final boolean hasFridge;


    public HotelRoom(Hotel hotel, int roomNumber, int roomFloor, boolean hasFridge) {
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.roomFloor = roomFloor;
        this.hasFridge = hasFridge;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public boolean isHasFridge() {
        return hasFridge;
    }
}
