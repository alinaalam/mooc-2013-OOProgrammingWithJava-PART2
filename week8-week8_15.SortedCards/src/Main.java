
public class Main {

    public static void main(String[] args) {
        // write some test code here
//        Card first = new Card(2, Card.DIAMONDS);
//        Card second = new Card(14, Card.CLUBS);
//        Card third = new Card(12, Card.HEARTS);
//        
//        List<Card> cards = new ArrayList();
//        
//        Collections.addAll(cards, first, second, third);
//        
//        Collections.sort(cards);
//        
//        System.out.println(cards);

//        Hand hand1 = new Hand();
//
//        hand1.add(new Card(2, Card.SPADES));
//        hand1.add(new Card(14, Card.CLUBS));
//        hand1.add(new Card(12, Card.HEARTS));
//        hand1.add(new Card(2, Card.CLUBS));
//
//        Hand hand2 = new Hand();
//
//        hand2.add(new Card(11, Card.DIAMONDS));
//        hand2.add(new Card(11, Card.CLUBS));
//        hand2.add(new Card(11, Card.HEARTS));
//
//        int comparison = hand1.compareTo(hand2);
//
//        if (comparison < 0) {
//            System.out.println("the most valuable hand contains the cards");
//            hand2.print();
//        } else if (comparison > 0) {
//            System.out.println("the most valuable hand contains the cards");
//            hand1.print();
//        } else {
//            System.out.println("the hands are equally valuable");
//        }
        Hand hand = new Hand();

        hand.add(new Card(12, Card.HEARTS));
        hand.add(new Card(4, Card.CLUBS));
        hand.add(new Card(2, Card.DIAMONDS));
        hand.add(new Card(14, Card.CLUBS));
        hand.add(new Card(7, Card.HEARTS));
        hand.add(new Card(2, Card.CLUBS));

        hand.sortAgainstSuit();

        hand.print();
    }
}
