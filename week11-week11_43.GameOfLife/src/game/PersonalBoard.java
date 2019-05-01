/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author alinaalam
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random random = new Random();

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (random.nextDouble() <= d) {
                    turnToLiving(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (checkIfCoordinatesAreValid(x, y)) {
            return getBoard()[x][y];
        }
        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        setValue(x, y, true);
    }

    @Override
    public void turnToDead(int x, int y) {
        setValue(x, y, false);
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        // need to get eight neighbours and for each neighbour need to check if they are alive or not
        int numberOfAliveNeighbours = 0;
        int[][] neighbours = {{x, y + 1}, {x, y - 1}, {x + 1, y}, {x - 1, y}, {x + 1, y - 1},
        {x - 1, y + 1}, {x - 1, y - 1}, {x + 1, y + 1}};

        for (int[] currentNeighbour : neighbours) {
            if (isAlive(currentNeighbour[0], currentNeighbour[1])) {
                numberOfAliveNeighbours++;
            }
        }

        return numberOfAliveNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (isAlive(x, y)) {
            // every living cell dies if they have less than two living neighbours
            // every living cell dies if they have more than three living neighbours
            if(livingNeighbours < 2 || livingNeighbours > 3) {
                turnToDead(x, y);
            }
            // every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours
            else {
                turnToLiving(x, y);
            }
        } else {
            // every dead cell is turned back to life if they have exactly three living neighbours
            if(livingNeighbours == 3) {
                turnToLiving(x, y);
            }
        }
    }

    private boolean checkIfCoordinatesAreValid(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    private void setValue(int x, int y, boolean value) {
        if (checkIfCoordinatesAreValid(x, y)) {
            getBoard()[x][y] = value;
        }
    }

}
