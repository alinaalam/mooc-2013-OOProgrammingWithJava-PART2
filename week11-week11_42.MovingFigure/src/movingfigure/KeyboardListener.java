/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author alinaalam
 */
public class KeyboardListener implements KeyListener {
    
    private Figure figure;
    private Component component;

    public KeyboardListener(Component component, Figure figure) {
        this.figure = figure;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int x = 0, y = 0;
        
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                x--;
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                break;
            case KeyEvent.VK_UP:
                y--;
                break;
            case KeyEvent.VK_DOWN:
                y++;
                break;
        }
        
        figure.move(x, y);
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
