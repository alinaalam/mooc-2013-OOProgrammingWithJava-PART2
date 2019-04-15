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
public class Vampire extends Character {

    private boolean isAlive;

    public Vampire() {
        super("v");
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
