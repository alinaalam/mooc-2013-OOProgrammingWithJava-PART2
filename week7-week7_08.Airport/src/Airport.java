/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */

import java.util.*;

public class Airport {
    
    private List<Flight> flights;
    private Map<String, Airplane> planes;
    private Scanner reader;
    
    public Airport(Scanner reader) {
        this.flights = new ArrayList();
        this.planes = new HashMap();
        this.reader = reader;
    }
    
    public void start() {
        airportPanel();
        flightPanel();
    }
    
    private void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        
        printAirportPanelMenu();
        
        String command = reader.nextLine();
        while(!command.equals("x")) {
            if(command.equals("1")) {
                addAirplane();
            }
            if(command.equals("2")) {
                addFlight();
            }
            printAirportPanelMenu();
            command = reader.nextLine();
        }
    }
    
    private void printAirportPanelMenu() {    
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }
    
    private void addAirplane() {
        System.out.println("Give plane ID:");
        String id = reader.nextLine();
        System.out.println("Give plane capacity:");
        int capacity = Integer.parseInt(reader.nextLine());
        planes.put(id, new Airplane(id, capacity));
    }
    
    private void addFlight() {
        System.out.println("Give plane ID:");
        String id = reader.nextLine();
        System.out.println("Give departure airport code:");
        String departureCode = reader.nextLine();
        System.out.println("Give destination airport code:");
        String destinationCode = reader.nextLine();
        flights.add(new Flight(planes.get(id), departureCode, destinationCode));
    }
    
    private void flightPanel() {
        System.out.println("Flight service");
        System.out.println("------------");
        
        printFlightPanelMenu();
        
        String command = reader.nextLine();
        while(!command.equals("x")) {
            if(command.equals("1")) {
                printPlanes();
            }
            if(command.equals("2")) {
                printFlights();
            }
            if(command.equals("3")) {
                printPlaneInfo();
            }
            printFlightPanelMenu();
            command = reader.nextLine();
        }
    }
    
    private void printFlightPanelMenu() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
    }
    
    private void printPlanes() {
        for(String plane : planes.keySet()) {
            System.out.println(planes.get(plane));
        }
    }
    
    private void printFlights() {
        for(Flight flight : flights) {
            System.out.println(flight);
        }
    }
    
    private void printPlaneInfo() {
        System.out.println("Give plane ID:");
        String id = reader.nextLine();
        System.out.println(planes.get(id));
    }
}
