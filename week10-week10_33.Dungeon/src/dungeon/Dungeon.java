/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class Dungeon {

    private VampireController vampireController;
    private Character player;
    private Scanner reader;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.player = new Player(length, height, moves);
        this.vampireController = new VampireController(vampires, length, height, vampiresMove);
        this.reader = new Scanner(System.in);
    }
    
    public void run() {
        while(true) {
            showStats(); break;
        }
    }
    
    private void showStats() {
        System.out.println(player);
        System.out.println(vampireController);
    }
}
