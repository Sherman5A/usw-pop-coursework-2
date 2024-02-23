package usw.pop;

import java.util.List;

/**
 * Class representing a cruise
 */
public class Cruise {
    private Ship ship;
    private String origPort;
    private String destPort;
    private List<String> portsOfCall;


    public Cruise(Ship ship, String origPort, String destPort, List<String> portsOfCall) {
        this.ship = ship;
        this.origPort = origPort;
        this.destPort = destPort;
        this.portsOfCall = portsOfCall;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public String getOrigPort() {
        return origPort;
    }

    public void setOrigPort(String origPort) {
        this.origPort = origPort;
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }

    public List<String> getPortsOfCall() {
        return portsOfCall;
    }

    public void setPortsOfCall(List<String> portsOfCall) {
        this.portsOfCall = portsOfCall;
    }
}
