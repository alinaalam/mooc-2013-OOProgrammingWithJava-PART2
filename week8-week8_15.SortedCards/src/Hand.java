
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Hand implements Comparable<Hand> {
    
    private List<Card> cards;
    
    public Hand() {
        cards = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        for(Card c : cards) {
            System.out.println(c);
        }
    }
    
    public void sort() {
        Collections.sort(cards);
    }

    @Override
    public int compareTo(Hand o) {
       return getCardsSum() - o.getCardsSum();
    }
    
    private int getCardsSum() {
        int sum = 0;
        
        for(Card c : cards) {
            sum += c.getValue();
        }
        
        return sum;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }
}
