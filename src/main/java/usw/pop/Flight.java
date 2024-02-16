package usw.pop;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Flight {
    private String flightID;
    private Aircraft aircraft;
    private AircraftCrew aircraftCrew;
    private LocalDateTime flightStart;
    private LocalDateTime flightEnd;
    private final String origAirport;
    private String destAirport;

    public Flight(String flightID, Aircraft aircraft, AircraftCrew aircraftCrew, LocalDateTime flightStart,
                  LocalDateTime flightEnd, String origAirport, String destAirport) {
        this.flightID = flightID;
        this.aircraft = aircraft;
        this.aircraftCrew = aircraftCrew;
        this.flightStart = flightStart;
        this.flightEnd = flightEnd;
        this.origAirport = origAirport;
        this.destAirport = destAirport;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public AircraftCrew getAircraftCrew() {
        return aircraftCrew;
    }

    public void setAircraftCrew(AircraftCrew aircraftCrew) {
        this.aircraftCrew = aircraftCrew;
    }

    public LocalDateTime getFlightStart() {
        return flightStart;
    }

    public void setFlightStart(LocalDateTime flightStart) {
        this.flightStart = flightStart;
    }

    public LocalDateTime getFlightEnd() {
        return flightEnd;
    }

    public void setFlightEnd(LocalDateTime flightEnd) {
        this.flightEnd = flightEnd;
    }

    public long getFlightDuration() {
        return flightStart.until(flightEnd, ChronoUnit.HOURS);
    }

    public String getOrigAirport() {
        return origAirport;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }
}
