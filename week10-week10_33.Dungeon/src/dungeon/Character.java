/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author alinaalam
 */
public abstract class Character {
    
    protected final String representation;
    protected int currentYPos;
    protected int currentXPos;

    public Character(String representation) {
        this.representation = representation;
    }
    
    public void setCurrentYPos(int column) {
        this.currentYPos = column;
    }
    
    public void setCurrentXPos(int row) {
        this.currentXPos = row;
    }
    
    public int getCurrentYPos() {
        return currentYPos;
    }
    
    public int getCurrentXPos() {
        return currentXPos;
    }
    
    public String getRepresentation() {
        return representation;
    }
    
    @Override
    public String toString() {
        return representation + " " + currentXPos + " " + currentYPos;
    }
}
