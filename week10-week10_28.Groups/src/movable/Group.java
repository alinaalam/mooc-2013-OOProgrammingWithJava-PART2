/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class Group implements Movable {

    private List<Movable> movableObjects;

    public Group() {
        movableObjects = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        movableObjects.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable object : movableObjects) {
            object.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Movable object : movableObjects) {
            sb.append(object).append("\n");
        }
        
        return sb.toString();
    }
    
}
