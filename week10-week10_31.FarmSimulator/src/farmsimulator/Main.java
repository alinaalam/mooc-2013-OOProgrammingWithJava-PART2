package farmsimulator;

public class Main {

    public static void main(String[] args) {
        // Test your program here
//        BulkTank m = new BulkTank(5782.4);
//        m.addToTank(3232.13);
//        m.addToTank(50000.99);
//        m.addToTank(5000.0);
//        m.getFromTank(1.5);
//        m.getFromTank(1432.1232);
//        m.getFromTank(50000.0);
//        m.getVolume();
//        System.out.println(m.getVolume());

//        Cow cow = new Cow();
//        System.out.println(cow);
//
//        Alive livingCow = cow;
//        livingCow.liveHour();
//        livingCow.liveHour();
//        livingCow.liveHour();
//        livingCow.liveHour();
//
//        System.out.println(cow);
//
//        Milkable milkingCow = cow;
//        milkingCow.milk();
//
//        System.out.println(cow);
//        System.out.println("");
//
//        cow = new Cow("Ammu");
//        System.out.println(cow);
//        cow.liveHour();
//        cow.liveHour();
//        System.out.println(cow);
//        cow.milk();
//        System.out.println(cow);
        MilkingRobot milkingRobot = new MilkingRobot();
        Cow cow = new Cow();
        System.out.println("");

        BulkTank tank = new BulkTank();
        milkingRobot.setBulkTank(tank);
        System.out.println("Bulk tank: " + tank);

        for (int i = 0; i < 2; i++) {
            System.out.println(cow);
            System.out.println("Living..");
            for (int j = 0; j < 5; j++) {
                cow.liveHour();
            }
            System.out.println(cow);

            System.out.println("Milking...");
            milkingRobot.milk(cow);
            System.out.println("Bulk tank: " + tank);
            System.out.println("");
        }
    }
}
