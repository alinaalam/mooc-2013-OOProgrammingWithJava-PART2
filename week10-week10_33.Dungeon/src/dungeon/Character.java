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
    protected int column;
    protected int row;

    public Character(String representation) {
        this.representation = representation;
    }
    
    public abstract boolean isAlive();
    
    @Override
    public String toString() {
        return representation + " " + column + " " + row;
    }
}
