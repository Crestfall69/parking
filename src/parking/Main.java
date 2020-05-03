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
        if ((vehicleList.get(i).getVehicleModel()).equals("DELETED")) {
            return true;
        }
        return false;
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

    public static boolean checkParking(int i) {
        return parkingList.get(i).occupied;
    }

    public static void addParkingSlot() {
        Parking park = new Parking("", vehicleList.get(0), "");
        parkingList.add(park);
    }

    public static void selectParking(int i) {
        System.out.format("%3d%10b%40s%25s%15s\n", i, checkParking(i), parkingList.get(i).getParkingName(), parkingList.get(i).getParkingVehicle().getVehicleModel(), parkingList.get(i).getParkingPlate());
    }

    public static void listParking() {
        System.out.format("%3s%10s%40s%25s%15s\n", "id", "occupied", "name", "vehicle", "plate");
        for (int i = 0; i < parkingList.size(); i++) {
            selectParking(i);
        }
        System.out.println("");
    }

    // Main Class
    public static void main(String[] args) {

        System.out.println("Added dummy empty vehicle.");
        addVehicle("Empty", "", "");

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
                    System.out.println("park_slot: Add empty parking slot.");
                    System.out.println("park_add: Add customer into a parking slot.");
                    System.out.println("park_del: Remove customer from parking slot.");
                    System.out.println("park_edit: Edit a customer in parking slot.");
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
                    System.out.println("Insert vehicle model name (ex: Toyota Trueno AE86). Type 'cancel' to cancel.");
                    System.out.print("Vehicle Model: ");
                    var model = scanner.nextLine();
                    if (model.equals("cancel")) {
                            break;
                        }
                    System.out.println("Insert vehicle type (ex: truck, sedan, suv, motorcycle). Type 'cancel' to cancel.");
                    System.out.print("Vehicle Type: ");
                    var type = scanner.nextLine();
                    if (type.equals("cancel")) {
                            break;
                        }
                    System.out.println("Insert amount of wheels on vehicle. Type 'cancel' to cancel.");
                    System.out.print("Vehicle Wheels: ");
                    var wheel = scanner.nextLine();
                    if (wheel.equals("cancel")) {
                            break;
                        }

                    addVehicle(model, type, wheel);

                    break;
                case "vhc_del":

                    // Start by listing vehicle.
                    listVehicle();

                    // Don't input anything stupid.
                    while (true) {
                        System.out.println("Select vehicle to delete. Type 'cancel' to cancel.");
                        System.out.print("ID: ");
                        var delete = scanner.nextLine();

                        if (delete.equals("cancel")) {
                            break;
                        }

                        if (delete.equals("0")) {
                            System.out.println("Can't delete dummy vehicle!");
                            System.out.println("");
                            break;
                        }

                        try {
                            int test = Integer.parseInt(delete);
                            // Just to make sure the user is not a fucking idiot.
                            if (checkVehicle(test)) {
                                System.out.println("Vehicle is already deleted!");
                                System.out.println("");
                            } else {
                                vehicleList.get(test).setVehicleModel("DELETED");
                                vehicleList.get(test).setVehicleType("");
                                vehicleList.get(test).setVehicleWheel("");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println(e);
                            System.out.println("Please input numbers only!");
                            System.out.println("");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e);
                            System.out.println("Vehicle doesn't exist!");
                            System.out.println("");
                        }
                    }
                    break;
                case "park_list":
                    listParking();
                    break;
                case "park_slot":
                    System.out.println("Insert amount of parking slots to add. Type 'cancel' to cancel.");
                    System.out.print("Number: ");
                    var num = scanner.nextLine();

                    if (num.equals("cancel")) {
                            break;
                        }

                    try {
                        Integer.parseInt(num);
                        for (int i = 0; i < Integer.parseInt(num);i++) {
                            addParkingSlot();
                        }                        
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        System.out.println("Please input numbers only!");
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
//                case "park_add":
//                    System.out.println("Insert customer name.");
//                    System.out.print("Name: ");
//                    String name = scanner.nextLine();
//                    listVehicle();
//                    while (true) {
//                    System.out.println("Choose customer vehicle.");
//                    System.out.print("ID: ");
//                    var vhcid = scanner.nextLine();
//                    
//                    if (vhcid == null) {
//                        vhcid = "0";
//                    }
//                    
//                    
//                    }
//                    break;
            }
            System.out.print("Command: ");
            command = scanner.nextLine();
        }
    }
}