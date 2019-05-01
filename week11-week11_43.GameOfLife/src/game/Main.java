package game;

import gameoflife.Simulator;

public class Main {

    public static void main(String[] args) {
        // test your program here
        PersonalBoard board = new PersonalBoard(1, 1);
        board.initiateRandomCells(1);

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();
    }
}
