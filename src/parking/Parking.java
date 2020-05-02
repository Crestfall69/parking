/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Crestfall
 */
public class Parking {

    public void setParkingOccupied(String x) {
        if (x == "true") {
            occupied = true;
        } else if (x == "false") {
            occupied = false;
        } else {
            System.out.println("ERROR");
            System.out.println("Unknown setParkingOccupied statement! Use \"True\" or \"False\" only!");
        }
    }

    public void setParkingName(String x) {
        name = x;
    }

    public void setParkingVehicle(Vehicle x) {
        vhc = x;
    }

    public void setParkingPlate(String x) {
        plate = x;
    }

    public String getParkingOccupied() {
        return Boolean.toString(occupied);
    }

    public String getParkingStatus() {
        if (occupied) {
            return "Occupied";
        } else {
            return "Empty";
        }
    }

    public String getParkingName() {
        return name;
    }

    public Vehicle getParkingVehicle() {
        return vhc;
    }

    public String getParkingPlate() {
        return plate;
    }

    boolean occupied;
    String name;
    Vehicle vhc;
    String plate;

    public Parking(String a, Vehicle b, String c) {
        occupied = false;
        name = a;
        vhc = b;
        plate = c;
    }
}
