
import containers.ProductContainer;
import containers.ProductContainerRecorder;

public class Main {

    public static void main(String[] args) {
        // write test code here
        ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);

        ProductContainerRecorder juice1 = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice1.takeFromTheContainer(11.3);
        System.out.println(juice1.getName()); // Juice
        juice1.addToTheContainer(1.0);
        System.out.println(juice1);
        System.out.println(juice1.history());
        
        
        juice1.printAnalysis();
    }

}
