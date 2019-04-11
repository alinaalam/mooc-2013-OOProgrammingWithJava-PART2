/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class Person {

    private String name;
    private Address address;
    private List<String> phoneNumbers;

    public Person(String name, Address address, List<String> phoneNumbers) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public Person(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public Person(String name) {
        this.name = name;
        phoneNumbers = new ArrayList<String>();
    }

    public void addNumber(String number) {
        phoneNumbers.add(number);
    }

    public List<String> getNumbers() {
        return phoneNumbers;
    }

    public void addAddress(String street, String city) {
        address = new Address(street, city);
    }

    public boolean checkIfItContains(String keyword) {
        if(address != null) {
            return (name.contains(keyword))
                || address.getStreet().contains(keyword)
                || address.getCity().contains(keyword);
        }
        return name.contains(keyword);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  address");
        sb.append((address == null) ? " unknown" : ": " + address);
        sb.append("\n");
        if (phoneNumbers.size() > 0) {
            sb.append("  phone numbers:");
            sb.append("\n");
            for (String number : phoneNumbers) {
                sb.append("   ").append(number);
                sb.append("\n");
            }
        } else {
            sb.append("  phone number not found");
        }
        return sb.toString();
    }
}
