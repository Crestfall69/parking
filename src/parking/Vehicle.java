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
public class Vehicle {

    public void setVehicleModel(String x) {
        model = x;
    }

    public void setVehicleType(String x) {
        type = x;
    }

    public void setVehicleWheel(String x) {
        wheel = x;
    }

    public String getVehicleModel() {
        return model;
    }

    public String getVehicleType() {
        return type;
    }

    public String getVehicleWheel() {
        return wheel;
    }

    private String model;
    private String type;
    private String wheel;

    public Vehicle(String a, String b, String c) {
        model = a;
        type = b;
        wheel = c;
    }
}
