/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Crestfall
 */
public class Main {

    int currentid = 0;

    private static ArrayList<Vehicle> vehicleList = new ArrayList();
    
    private static ArrayList<Parking> parkingList = new ArrayList();
    
    
    public static boolean checkVehicle(int i) {
        if (vehicleList.get(i).getVehicleModel() == "DELETED") {
            return true;
        }
        return false;
    }

    public static void addParkingSlot() {
        Parking park = new Parking(null, null, null);
        parkingList.add(park);
    }
    
    public static void addVehicle(String a, String b, String c) {
        Vehicle vhc = new Vehicle(a, b, c);
        vehicleList.add(vhc);
        System.out.println("Succesfully added!");
        selectVehicle(vehicleList.size() - 1);
        System.out.println("");
    }

    public static void selectVehicle(int i) {
        System.out.format("%3d%25s%15s%15s\n", i, vehicleList.get(i).getVehicleModel(), vehicleList.get(i).getVehicleType(), vehicleList.get(i).getVehicleWheel());
    }

    public static void listVehicle() {
        System.out.format("%3s%25s%15s%15s\n", "id", "model", "type", "wheels");
        for (int i = 0; i < vehicleList.size(); i++) {
            selectVehicle(i);
        }
        System.out.println("");
    }

    // Main Class
    public static void main(String[] args) {

        // CMD Bootleg 1.0 by Davey
        // Initial Creation
        Scanner scanner = new Scanner(System.in);
        var command = "help";

        // Commands
        while (true) {
            switch (command) {
                default:
                    System.out.println("Unknown command.");
                    System.out.println("Refer to 'help' for list of commands.");
                    System.out.println("");
                    break;
                case "help":
                    System.out.println("help: List of available commands.");
                    System.out.println("credits: Show credits.");
                    System.out.println("vhc_list: Show vehicle list.");
                    System.out.println("vhc_add: Create new vehicle model.");
                    System.out.println("vhc_del: Delete a vehicle model.");
                    System.out.println("park_list: Show parking list.");
                    System.out.println("park_add: Add customer into a parking slot.");
                    System.out.println("park_del: Remove customer from parking slot.");
                    System.out.println("");
                    break;
                case "credits":
                    System.out.println("Basic Vehicle Parking");
                    System.out.println("by: Davey");
                    System.out.println("BID: 2301907252");
                    System.out.println("");
                    break;
                case "vhc_list":
                    listVehicle();
                    break;
                case "vhc_add":
                    System.out.println("Insert vehicle model name (ex: Toyota Trueno AE86).");
                    System.out.print("Vehicle Model: ");
                    var model = scanner.nextLine();
                    System.out.println("Insert vehicle type (ex: truck, sedan, suv, motorcycle).");
                    System.out.print("Vehicle Type: ");
                    var type = scanner.nextLine();
                    System.out.println("Insert amount of wheels on vehicle.");
                    System.out.print("Vehicle Wheels: ");
                    var wheel = scanner.nextLine();

                    addVehicle(model, type, wheel);

                    break;
                case "vhc_delete":

                    // Start by listing vehicle.
                    listVehicle();

                    // Don't input anything stupid.
                    int id = 0;
                    while (true) {
                        System.out.println("Select vehicle to delete.");
                        System.out.print("ID: ");
                        var delete = scanner.nextLine();

                        if (delete == null) {
                            break;
                        }
                        try {
                            id = Integer.parseInt(delete);
                            // Just to make sure the user is not a fucking idiot.
                            if (checkVehicle(id)) {
                                System.out.println("Vehicle is already deleted!");
                                System.out.println("");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(e);
                            System.out.println("Please input numbers only!");
                            System.out.println("");
                        }
                    }
                    vehicleList.get(id).setVehicleModel("DELETED");
                    vehicleList.get(id).setVehicleType(null);
                    vehicleList.get(id).setVehicleWheel(null);
                    break;
            }
            System.out.print("Command: ");
            command = scanner.nextLine();
        }
    }
}
