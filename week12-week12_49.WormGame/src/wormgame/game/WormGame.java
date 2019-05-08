package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
       
        random = new Random();
        
        this.apple = createApple(width, height);
        
        addActionListener(this);
        setInitialDelay(2000);

    }
    
    private Apple createApple(int width, int height) {
        while(true) {
            Apple newApple = new Apple(random.nextInt(width), random.nextInt(height));
            if(!this.worm.runsInto(newApple)) {
                return newApple;
            }
        }
    }
    
    public Worm getWorm() {
        return worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if(worm.runsInto(apple)) { 
            worm.grow();
            apple = createApple(width, height);
        }
        if(worm.runsIntoItself() || wormHasHitTheWall()) {
            continues = false;
        }
        updatable.update();
        setDelay(1000 / worm.getLength());
    }
    
    private boolean wormHasHitTheWall() {
        for(Piece piece : worm.getPieces()) {
            if(piece.getX() < 0 || piece.getX() >= width) {
                return true;
            }
            if(piece.getY() < 0 || piece.getY() >= height) {
                return true;
            }
        }
        return false;
    }

}
