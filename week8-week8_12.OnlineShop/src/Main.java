
public class Main {

    public static void main(String[] args) {
        // write some test code here
//        Storehouse store = new Storehouse();
//        store.addProduct("coffee", 5, 1);
//
//        System.out.println("stocks:");
//        System.out.println("coffee:  " + store.stock("coffee"));
//        System.out.println("sugar: " + store.stock("sugar"));
//
//        System.out.println("we take a coffee " + store.take("coffee"));
//        System.out.println("we take a coffee " + store.take("coffee"));
//        System.out.println("we take sugar " + store.take("sugar"));
//
//        System.out.println("stocks:");
//        System.out.println("coffee:  " + store.stock("coffee"));
//        System.out.println("sugar: " + store.stock("sugar"));
//        
//        store.addProduct("milk", 3, 10);
//        store.addProduct("coffee", 5, 6);
//        store.addProduct("buttermilk", 2, 20);
//        store.addProduct("jogurt", 2, 20);
//
//        System.out.println("products:");
//        for (String product : store.products()) {
//            System.out.println(product);
//        }

        ShoppingBasket basket = new ShoppingBasket();
        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("buttermilk", 2);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");
    }
}
