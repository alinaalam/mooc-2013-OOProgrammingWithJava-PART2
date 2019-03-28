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

public class Container {
    
    private int maxWeight;
    private List<Suitcase> suitcases;
    
    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        suitcases = new ArrayList();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if((suitcase.totalWeight() + totalWeight()) <= maxWeight) {
            suitcases.add(suitcase);
        }
    }
    
    private int totalWeight() {
        int totalWeight = 0;
        
        for(Suitcase suitcase : suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        
        return totalWeight;
    }
    
    public void printThings() {
        for(Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }
    
    public String toString() {
        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
