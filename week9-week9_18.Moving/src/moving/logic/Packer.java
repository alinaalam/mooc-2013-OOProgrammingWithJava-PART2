/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author alinaalam
 */
public class Packer {
    
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        Box box = new Box(boxesVolume);
        
        for(Thing thing : things) {
            // if we can't add another item, store this box in the packer and create another box
            if(!box.addThing(thing)) {
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThing(thing);
            }
        }
        boxes.add(box);
        return boxes;
    }
}
