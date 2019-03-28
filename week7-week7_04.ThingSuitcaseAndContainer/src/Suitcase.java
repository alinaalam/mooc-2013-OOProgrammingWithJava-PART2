/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
import java.util.*;

public class Suitcase {
    
    private List<Thing> things;
    private int maxWeight;
    
    public Suitcase(int maxWeight) {
        things = new ArrayList();
        this.maxWeight = maxWeight;
    }
    
    public void addThing(Thing thing) {
        if((totalWeight() + thing.getWeight()) <= maxWeight) {
            things.add(thing);
        }
    }
    
    public String toString() {
        String howManyThings = things.size() + " things";
        if(things.size() == 0) {
            howManyThings = "empty";
        }
        else if(things.size() == 1) {
            howManyThings = howManyThings.substring(0, howManyThings.length()-1);
        }
        return howManyThings + " (" + totalWeight() + " kg)";
    }
    
    public void printThings() {
        for(Thing thing : things) {
            System.out.println(thing);
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for(Thing thing : things) {
            totalWeight += thing.getWeight();
        }
        return totalWeight;
    }
    
    public Thing heaviestThing() {
        Thing heaviestThing = null;
        for(Thing thing : things) {
            if(heaviestThing == null) {
                heaviestThing = thing;
            }
            else if(thing.getWeight() > heaviestThing.getWeight()){
                heaviestThing = thing;
            }
        }
        return heaviestThing;
    }
}
