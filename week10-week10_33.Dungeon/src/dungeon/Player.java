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
    
    @Override
    public boolean isAlive() {
        return moves > 0;
    }
}
