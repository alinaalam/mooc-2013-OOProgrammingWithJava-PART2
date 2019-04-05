/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class Box implements Thing {
    
    private int maximumCapacity;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        things = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if((getVolume()+thing.getVolume()) <= maximumCapacity) {
            things.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int capacity = 0;
        
        for(Thing thing : things) {
            capacity += thing.getVolume();
        }
        
        return capacity;
    }
}
