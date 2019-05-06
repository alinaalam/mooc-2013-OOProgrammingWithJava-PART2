/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author alinaalam
 */
public class Worm {
    
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> pieces;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>(Arrays.asList(new Piece(originalX, originalY)));
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    
    public int getLength() {
        return pieces.size();
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public void move() {
        if(direction == Direction.LEFT) {
            x--;
        }
        if(direction == Direction.DOWN) {
            y++;
        }
        if(direction == Direction.RIGHT) {
            x++;
        }
        if(direction == Direction.UP) {
            y--;
        }
        if(this.pieces.size() >= 3) {
            this.pieces.remove(0);
        }
        this.pieces.add(new Piece(x, y));
    }
    
    public void grow() {
        
    }
    
    public boolean runsInto(Piece piece) {
        for(Piece currentPiece : pieces) {
            if(currentPiece.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        for(int i=0; i<pieces.size(); i++) {
            for(int j=i+1; j<pieces.size(); j++) {
                if(pieces.get(i).runsInto(pieces.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
