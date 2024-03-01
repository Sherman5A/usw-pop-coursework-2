package usw.pop;

import java.time.LocalDateTime;


/**
 * Represents a booking for a flight.
 * Booking between {@code Flight} and {@code customer}
 */
public class FlightBooking {
    private final Flight flight;
    private final String seatingClass;
    private final int seatNumber;
    private final int baggageLimit;
    private AirportParking airportParking;
    private String bookingID;
    private boolean hasCheckedIn;
    private LocalDateTime checkInTime;
    private boolean hasMissedFlight;

    public FlightBooking(Flight flight, String seatingClass, int seatNumber, int baggageLimit) {
        this.flight = flight;
        this.seatingClass = seatingClass;
        this.seatNumber = seatNumber;
        this.baggageLimit = baggageLimit;
    }

    /**
     * Creates a {@code FlightBooking} object with the optional {@code AirportParking}
     *
     * @param flight
     * @param airportParking
     * @param seatingClass
     * @param seatNumber
     * @param baggageLimit
     */
    public FlightBooking(Flight flight, AirportParking airportParking, String seatingClass, int seatNumber,
                         int baggageLimit) {
        this.flight = flight;
        this.airportParking = airportParking;
        this.seatingClass = seatingClass;
        this.seatNumber = seatNumber;
        this.baggageLimit = baggageLimit;
    }


    /**
     * Check in the booking, checks that the flight has not started before the
     * booking
     *
     * @return whether the checking in was successful
     */
    public boolean checkIn() {
        if (LocalDateTime.now().isAfter(flight.getFlightStart())) {
            hasMissedFlight = true;
            return false;
        }
        hasCheckedIn = true;
        checkInTime = LocalDateTime.now();
        return true;
    }

    public Flight getFlight() {
        return flight;
    }

    public AirportParking getAirportParking() {
        return airportParking;
    }

    public String getSeatingClass() {
        return seatingClass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getBaggageLimit() {
        return baggageLimit;
    }

    public String getBookingID() {
        return bookingID;
    }

    public boolean isHasCheckedIn() {
        return hasCheckedIn;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public boolean isHasMissedFlight() {
        return hasMissedFlight;
    }
}
