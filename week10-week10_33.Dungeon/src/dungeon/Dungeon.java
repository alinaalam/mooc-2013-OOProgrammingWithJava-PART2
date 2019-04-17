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
    private int length;
    private int height;
    private int moves;
    private Command commandHandler;
    private boolean vampiresMove;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(length, height, moves);
        this.vampireController = new VampireController(vampires, length, height);
        this.reader = new Scanner(System.in);
        this.commandHandler = new Command();
    }
    
    public void run() {
        while(moves > 0) {
            System.out.println(moves);
            System.out.println();
            
            showStats(); 
            showDungeon();
            
            commandHandler.handleCommand(reader.nextLine(), (Player) player);
            if(!vampireController.checkIfVampiresAreAlive(player.getCurrentXPos(), player.getCurrentYPos())) {
                break;
            }
            
            if(vampiresMove) {
                vampireController.setVampireCoordinates();
            }
            moves--;
        }
        
        if(moves > 0) {
            System.out.println("YOU WIN");
        }
        else {
            System.out.println("YOU LOSE");
        }
    }
    
    private void showStats() {
        System.out.println(player);
        System.out.println(vampireController);
    }
    
    private void showDungeon() {
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                boolean isPositionOccupied = false;
                
                if(positionOccupiedByCharacter(i, j, player)) {
                    System.out.print(player.getRepresentation());
                    isPositionOccupied = true;
                }
                else {
                    for(Vampire vampire : vampireController.getVampires()) {
                        if(positionOccupiedByCharacter(i, j, vampire)) {
                            System.out.print(vampire.getRepresentation());
                            isPositionOccupied = true;
                        }
                    }
                }
                
                if(!isPositionOccupied) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    
    private boolean positionOccupiedByCharacter(int row, int column, Character character) {
        return (character.getCurrentYPos() == row) && (character.getCurrentXPos() == column);
    }
}
