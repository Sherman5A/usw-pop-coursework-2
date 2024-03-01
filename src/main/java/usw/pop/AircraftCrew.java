package usw.pop;

import java.util.List;

public class AircraftCrew {
    List<Pilot> pilots;
    List<CabinCrew> cabinCrew;

    /**
     * Creates an AirCraft crew object
     * @param pilots Aircraft can have multiple pilots
     * @param cabinCrew Cabin crew of an aircraft
     */
    public AircraftCrew(List<Pilot> pilots, List<CabinCrew> cabinCrew) {
        this.pilots = pilots;
        this.cabinCrew = cabinCrew;
    }

    public void addPilot(Pilot pilot) {
        pilots.add(pilot);
    }

    public void addCrew(CabinCrew cabinCrew) {
        this.cabinCrew.add(cabinCrew);
    }
}
