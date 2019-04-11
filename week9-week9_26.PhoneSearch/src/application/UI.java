/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class UI {

    private Scanner reader;
    private PhoneDirectory phoneDirectory;

    public UI() {
        reader = new Scanner(System.in);
        phoneDirectory = new PhoneDirectory(reader);
    }

    public void start() {
        menu();
        while(true) {
            System.out.println("command: ");
            String command = reader.nextLine();
            if(command.contains("x")) {
                break;
            }
            if(command.contains("1")) {
                phoneDirectory.addNumber();
            }
            if(command.contains("2")) {
                phoneDirectory.searchByName();
            }
            if(command.contains("3")) {
                phoneDirectory.searchByNumber();
            }
            if(command.contains("4")) {
                phoneDirectory.addAddress();
            }
            if(command.contains("5")) {
                phoneDirectory.showInformation();
            }
            if(command.contains("6")) {
                phoneDirectory.deleteInformation();
            }
            if(command.contains("7")) {
                phoneDirectory.filteredListing();
            }
        }
    }

    private void menu() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
    }
}
