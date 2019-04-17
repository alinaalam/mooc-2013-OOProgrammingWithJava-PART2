/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author alinaalam
 */
public class VampireController {
    
    private List<Vampire> vampires;
    private Map<Integer, Integer> occupiedPositions;
    
    private int length;
    private int height;

    public VampireController(int vampireCount, int length, int height) {
        vampires = new ArrayList<Vampire>();
        occupiedPositions = new HashMap();
        
        this.length = length;
        this.height = height;
        
        initiliazeVampires(vampireCount);
    }
    
    private void initiliazeVampires(int vampireCount) {
        for(int i = 0; i < vampireCount; i++) {
            vampires.add(new Vampire());
        }
        setVampireCoordinates();
    }
    
    public void setVampireCoordinates() {
        // get three random coordinates within the given range
        occupiedPositions.clear();
        int getLocationsForVampires = 0;
        
        while(getLocationsForVampires < vampires.size()) {
            int[] coordinates = generateRandomLocations();
            if(!occupiedPositions.containsKey(coordinates[0]) 
                    || !occupiedPositions.containsValue(coordinates[1])) {
                occupiedPositions.put(coordinates[0], coordinates[1]);
                
                vampires.get(getLocationsForVampires).setCurrentYPos(coordinates[0]);
                vampires.get(getLocationsForVampires).setCurrentXPos(coordinates[1]);
                
                getLocationsForVampires++;
            }
        }
    }
    
    private int[] generateRandomLocations() {
        
        Random random = new Random();
        int column = random.nextInt(length);
        int row = random.nextInt(height);
        
        int[] coordinates = new int[] {column, row};
        
        return coordinates;
    }
    
    public List<Vampire> getVampires() {
        return vampires;
    }
    
    public boolean checkIfVampiresAreAlive(int positionX, int positionY) {
        for(int i=0; i<vampires.size(); i++) {
            Vampire vampire = vampires.get(i);
            if(vampire.getCurrentXPos() == positionX && vampire.getCurrentYPos() == positionY) {
                vampires.remove(i);
            }
        }
        return vampires.size() > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Vampire vampire : vampires) {
            sb.append(vampire).append("\n");
        }
        
        return sb.toString();
    }
}
