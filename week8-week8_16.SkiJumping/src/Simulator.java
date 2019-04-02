
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alinaalam
 */
public class Simulator {

    private Scanner reader;
    List<Jumper> jumpers;
    Map<String, List<String>> scoreBoard;

    Simulator() {
        reader = new Scanner(System.in);
        jumpers = new ArrayList<Jumper>();
        scoreBoard = new HashMap<String, List<String>>();
    }

    public void start() {
        System.out.println("Kumpula ski jumping week");
        getParticipants();
        jumpPhase();
        quit();
    }

    private void getParticipants() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.println("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            jumpers.add(new Jumper(name));
        }
    }

    private void jumpPhase() {
        System.out.println("The tournament begins!");
        int round = 1;

        while (true) {
            System.out.println("Write \"jump\" to jump; otherwise you quit:");
            String command = reader.nextLine();
            if (!command.equals("jump")) {
                break;
            }
            System.out.println("Round " + round);
            jumpingOrder();
            System.out.println("Results of round " + round);
            printResults();
            round++;
        }
    }

    private void jumpingOrder() {
        Collections.sort(jumpers);
        System.out.println("Jumping order:");
        int sr = 1;

        for (Jumper jumper : jumpers) {
            System.out.println("  " + sr + ". " + jumper);
            sr++;
        }
    }
    
    private void printResults() {
        for(Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            int length = generateRandomNumber(60, 120);
            System.out.println("    length: " + length);
            int[] judgesScores = generateJudgesScores();
            System.out.println("    judge votes: " + Arrays.toString(judgesScores));
            calculateAndStoreScores(jumper, length, judgesScores);
            List<String> lengths = scoreBoard.getOrDefault(jumper.getName(), new ArrayList<String>());
            lengths.add(length + " m");
            scoreBoard.put(jumper.getName(), lengths);
        }
    }
    
    private int generateRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    
    private int[] generateJudgesScores() {
        int[] scores = new int[5];
       
        for(int i=0; i<scores.length; i++) {
            scores[i] = generateRandomNumber(10, 20);
        }
        
        return scores;
    }
    
    private void calculateAndStoreScores(Jumper jumper, int length, int[] judgesScores) {
        jumper.addPoints(length);
        Arrays.sort(judgesScores);
        // don't include first and last points
        for(int i=1; i<=3; i++) {
            jumper.addPoints(judgesScores[i]);
        }
    }
    
    private void quit() {
        System.out.println("Thanks!");
        System.out.println("Tournament results:");
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        System.out.println("Position    Name");
        int position = 1;
        for(Jumper jumper : jumpers) {
            System.out.println(position + "           " + jumper);
            System.out.println("            jump lengths: " + String.join(", ", scoreBoard.get(jumper.getName())));
            position++;
        }
    }
}
