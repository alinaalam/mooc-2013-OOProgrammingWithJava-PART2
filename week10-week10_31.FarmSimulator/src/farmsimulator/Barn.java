/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author alinaalam
 */
public class Barn {
    
    private BulkTank bulkTank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank bulk) {
        this.bulkTank = bulk;
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        milkingRobot.setBulkTank(bulkTank);
    }
    
    public void takeCareOf(Cow cow) {
        try {
            milkingRobot.milk(cow);
        } catch(NullPointerException e) {
            throw new IllegalStateException();
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for(Cow cow : cows) {
            takeCareOf(cow);
        }
    }

    @Override
    public String toString() {
        return bulkTank.toString();
    }
}
