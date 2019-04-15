/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class Farm implements Alive {

    private String owner;
    private List<Cow> cows;
    private Barn barn;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public String getOwner() {
        return owner;
    }
    
    private String getCowsData() {
        StringBuilder sb = new StringBuilder();
        
        if(cows.isEmpty()) {
            sb.append("No cows.").append("\n");
        }
        else {
            sb.append("Animals:").append("\n");
            for(Cow cow : cows) {
                sb.append("        ").append(cow).append("\n");
            }
        }
        
        return sb.toString();
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barn.installMilkingRobot(milkingRobot);
    }
    
    @Override
    public void liveHour() {
        for(Cow cow : cows) {
            cow.liveHour();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Farm owner: ").append(owner).append("\n");
        sb.append("Barn bulk tank: ").append(barn).append("\n");
        sb.append(getCowsData());
        
        return sb.toString();
    }
}
