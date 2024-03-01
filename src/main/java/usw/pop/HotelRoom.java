package usw.pop;


/**
 * Room within a Hotel
 */
public class HotelRoom {
    private final Hotel hotel;
    private final int roomNumber;
    private final int roomFloor;
    private final boolean hasFridge;


    /**
     * Create a room within the hotel
     *
     * @param hotel      The hotel that the room belongs to
     * @param roomNumber Room number
     * @param roomFloor  The floor of the room
     * @param hasFridge  Whether the room has a fridge
     */
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
