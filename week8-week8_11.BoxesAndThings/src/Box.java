
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alinaalam
 */
public class Box implements ToBeStored {

    private final double maxWeight;
    private final List<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored items) {
        if ((weight() + items.weight()) <= maxWeight) {
            things.add(items);
        }
    }
    
    @Override
    public double weight() { 
        double weight = 0.0;
        for(ToBeStored thing : things) {
            weight += thing.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + things.size() + " things, total weight " + weight() + " kg";
    }

}
