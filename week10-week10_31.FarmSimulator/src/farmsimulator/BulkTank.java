/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author alinaalam
 */
public class BulkTank {

    private double capacity;
    private double volume;
    
    public BulkTank() {
        this(2000);
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if(amount > 0) {
            volume = ((amount + volume) > capacity) ? capacity : volume + amount;
        }
    }
    
    public double getFromTank(double amount) {
        double amountToGet = 0.0;
        if(amount > 0) {
            if((volume - amount) <= 0) {
                amountToGet = volume;
                volume = 0;
            }
            else {
                amountToGet = amount;
                volume -= amount;
            }
        }
        return amountToGet;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
