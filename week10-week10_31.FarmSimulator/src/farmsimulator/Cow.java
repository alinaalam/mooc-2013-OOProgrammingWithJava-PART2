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
    private double capacity;
    private double amount; // amount left in udder
    
    private static final String[] NAMES;
    private final double START_LITRE_RANGE = 0.7;
    private final double END_LITRE_RANGE = 2.0;
    
    static {
        NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    }

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
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
        return name + " " + Math.ceil(amount) + "/" + capacity;
    }

    @Override
    public double milk() {
        double amountToBeMilked = amount;
        amount = 0;
        return amountToBeMilked;
    }

    @Override
    public void liveHour() {
        double random = (START_LITRE_RANGE + (new Random().nextDouble()) * (END_LITRE_RANGE - START_LITRE_RANGE));
        if((random + amount) <= capacity) {
            amount += random;
        }
        else {
            amount = capacity;
        }
    }
    
}
