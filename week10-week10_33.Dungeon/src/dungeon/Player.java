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
public class Player extends Character {
    
    private int moves;
    private int length;
    private int height;

    public Player(int length, int height, int moves) {
        super("@");
        this.length = length;
        this.height = height;
        this.moves = moves;
    }
    
    public void goUp() {
        int newPosition = getCurrentYPos() - 1;
        if(newPosition >= 0) {
            setCurrentYPos(newPosition);
        }
    }
    
    public void goLeft() {
        int newPosition = getCurrentXPos() - 1;
        if(newPosition >= 0) {
            setCurrentXPos(newPosition);
        }
    }
    
    public void goDown() {
        int newPosition = getCurrentYPos() + 1;
        if(newPosition < height) {
            setCurrentYPos(newPosition);
        }
    }
    
    public void goRight() {
        int newPosition = getCurrentXPos() + 1;
        if(newPosition < length) {
            setCurrentXPos(newPosition);
        }
    }
}
