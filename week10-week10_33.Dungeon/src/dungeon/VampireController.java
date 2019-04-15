/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alinaalam
 */
public class VampireController {
    
    private List<Vampire> vampires;
    private Map<Integer, Integer> occupiedPositions;
    private boolean vampiresMove;
    
    private int length;
    private int height;

    public VampireController(int vampireCount, int length, int height, boolean vampiresMove) {
        vampires = new ArrayList<Vampire>();
        this.vampiresMove = vampiresMove;
        this.length = length;
        this.height = height;
        initiliazeVampires(vampireCount);
    }
    
    private void initiliazeVampires(int vampireCount) {
        for(int i = 0; i < vampireCount; i++) {
            vampires.add(new Vampire());
        }
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
