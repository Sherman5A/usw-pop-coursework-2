package usw.pop;

import java.time.LocalDateTime;

public class FlightBooking {
    private String bookingID;
    private final Flight flight;
    private final AirportParking airportParking;
    private final String seatingClass;
    private final int seatNumber;
    private final int baggageLimit;
    private boolean hasCheckedIn;
    private LocalDateTime checkinTime;
    private boolean hasMissedFlight;

    public FlightBooking(Flight flight, AirportParking airportParking, String seatingClass, int seatNumber,
                         int baggageLimit) {
        this.flight = flight;
        this.airportParking = airportParking;
        this.seatingClass = seatingClass;
        this.seatNumber = seatNumber;
        this.baggageLimit = baggageLimit;
    }

    public boolean checkIn() {
        if (LocalDateTime.now().isAfter(flight.getFlightStart())) {
            hasMissedFlight = true;
            return false;
        }
        hasCheckedIn = true;
        checkinTime = LocalDateTime.now();
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

    public LocalDateTime getCheckinTime() {
        return checkinTime;
    }

    public boolean isHasMissedFlight() {
        return hasMissedFlight;
    }
}
