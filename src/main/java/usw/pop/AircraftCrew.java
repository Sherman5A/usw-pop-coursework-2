package usw.pop;

import java.util.List;

public class AircraftCrew {
    List<Pilot> pilots;
    List<CabinCrew> cabinCrews;

    public AircraftCrew(List<Pilot> pilots, List<CabinCrew> cabinCrews) {
        this.pilots = pilots;
        this.cabinCrews = cabinCrews;
    }

    public void addPilot(Pilot pilot) {
        pilots.add(pilot);
    }

    public void addCrew(CabinCrew cabinCrew) {
        cabinCrews.add(cabinCrew);
    }
}
