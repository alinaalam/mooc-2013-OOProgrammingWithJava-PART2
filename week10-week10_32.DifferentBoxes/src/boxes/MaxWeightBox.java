/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
        if((getCurrentBoxWeight() + thing.getWeight()) <= maxWeight) {
            things.add(thing);
        }
    }
    
    private int getCurrentBoxWeight() {
        int weight = 0;
        
        for(Thing thing : things) {
            weight += thing.getWeight();
        }
        
        return weight;
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
    
}
