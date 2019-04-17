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
public class Command {
    
    // w -> up, a -> left, s -> down, d -> right 
    public void handleCommand(String command, Player player) {
        for (char c : command.toCharArray()) {
            if (c == 'w') {
                player.goUp();
            }
            if (c == 'a') {
                player.goLeft();
            }
            if (c == 's') {
                player.goDown();
            }
            if (c == 'd') {
                player.goRight();
            }
        }
    }
}
