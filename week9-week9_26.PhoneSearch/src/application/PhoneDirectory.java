/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class PhoneDirectory {
    
    private Scanner reader;
    private Map<String, Person> people;
    private Map<String, String> phoneNumbers;

    public PhoneDirectory(Scanner reader) {
        this.reader = reader;
        people = new HashMap<String, Person>();
        phoneNumbers = new HashMap<String, String>();
    }
    
    public void addNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        System.out.println("number: ");
        String number = reader.nextLine();
        
        Person person = people.getOrDefault(name, new Person(name));
        person.addNumber(number);
        people.put(name, person);
        phoneNumbers.put(number, name);
    }
    
    public void searchByName() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        if(people.containsKey(name)) {
            listNumbersByName(name);
        }
        else {
            System.out.println("  not found");
        }
    }
    
    public void searchByNumber() {
        System.out.println("number: ");
        String number = reader.nextLine();
        if(phoneNumbers.containsKey(number) && people.containsKey(phoneNumbers.get(number))) {
            System.out.println(phoneNumbers.get(number));
        }
        else {
            System.out.println("  not found");
        }
    }
    
    private void listNumbersByName(String name) {
        for(String number : people.get(name).getNumbers()) {
            System.out.println(number);
        }
    }
    
    public void addAddress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        
        Person person = people.getOrDefault(name, new Person(name));
        person.addAddress(street, city);
        people.put(name, person);
    }
    
    public void showInformation() {
        System.out.println("whose information:");
        String name = reader.nextLine();
        if(people.containsKey(name)) {
            System.out.println(people.get(name));
        }
        else {
            System.out.println("not found");
        }
    }
    
    public void deleteInformation() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        
        // remove it from the people
        people.remove(name);
        
        // need to remove it from the phone numbers as well
        Iterator<Map.Entry<String, String>> iter = phoneNumbers.entrySet().iterator();
        
        while(iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if(name.equals(entry.getValue())) {
                iter.remove();
            }
        }
    }
    
    public void filteredListing() {
        System.out.println("keyword (if empty, all listed):");
        String keyword = reader.nextLine();
        boolean isFound = false;
        
        System.out.println();
        
        // need to arrange the list alphabetically
        List<String> names = new ArrayList<String>(people.keySet());
        Collections.sort(names);
        for(String name : names) {
            if(people.containsKey(name) && people.get(name).checkIfItContains(keyword)) {
                isFound = true;
                System.out.println(name);
                System.out.println(people.get(name));
            }
        }
        
        if(!isFound) {
            System.out.println("not found");
        }
    }
}
