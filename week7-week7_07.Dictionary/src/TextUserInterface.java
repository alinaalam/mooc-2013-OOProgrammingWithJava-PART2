/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
import java.util.Scanner;

public class TextUserInterface {
    
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        printMenu();
        String command = reader.nextLine();
        
        while(!command.equals("quit")) {
            if(command.equals("add")) {
                addCommand();
            }
            if(command.equals("translate")) {
                translateCommand();
            }
            else {
                System.out.println("Unknown statement");

            }
            command = reader.nextLine();
        }
        
        System.out.println("Cheers!");
    }
    
    private void printMenu() {
        System.out.println("Statements:");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quits the text user interface");
    }
    
    private void addCommand() {
        System.out.println("In Finnish:");
        String finnish = reader.nextLine();
        System.out.println("Translation:");
        String translation = reader.nextLine();
        dictionary.add(finnish, translation);
    }
    
    private void translateCommand() {
        System.out.println("Give a word:");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
    }
}
