/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author alinaalam
 */
public class Cow implements Milkable, Alive {
    
    private String name;
    private int capacity;
    private double amount;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        name = NAMES[new Random().nextInt(NAMES.length)];
        capacity = 15 + new Random().nextInt(26);
    }

    public Cow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }
    
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(getAmount()) + "/" + getCapacity();
    }

    @Override
    public double milk() {
        double temp = amount;
        amount = 0.0;
        return temp;
    }

    @Override
    public void liveHour() {
        double amountToAdd = 0.7;
        if((amount + amountToAdd) <= capacity) {
            amount += amountToAdd;
        }
    }
}
