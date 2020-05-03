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
        vehicle = x;
    }

    public void setParkingPlate(String x) {
        plate = x;
    }

    public String getParkingOccupied() {
        return Boolean.toString(occupied);
    }

    public String getParkingName() {
        return name;
    }

    public Vehicle getParkingVehicle() {
        return vehicle;
    }

    public String getParkingPlate() {
        return plate;
    }

    boolean occupied;
    String name;
    Vehicle vehicle;
    String plate;

    public Parking(String nam, Vehicle vhc, String pla) {
        occupied = false;
        name = nam;
        vehicle = vhc;
        plate = pla;
    }
}
