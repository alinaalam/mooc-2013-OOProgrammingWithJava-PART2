/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Jumper implements Comparable<Jumper> {

    private String name;
    private int points;
    
    public Jumper(String name) {
        this.name = name;
        this.points = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void addPoints(int points) {
        this.points += points; 
    }

    @Override
    public int compareTo(Jumper o) {
        return this.getPoints() - o.getPoints();
    }

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }
}
