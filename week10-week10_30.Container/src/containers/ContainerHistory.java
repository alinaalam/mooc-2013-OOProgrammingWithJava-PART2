/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class ContainerHistory {
    
    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public double maxValue() {
        return (history.isEmpty()) ? 0.0 : Collections.max(history);
    }
    
    public double minValue() {
        return (history.isEmpty()) ? 0.0 : Collections.min(history);
    }
    
    public double average() {
        return (history.isEmpty()) ? 0.0 : getSum()/history.size();
    }
    
    private double getSum() {
        double sum = 0.0;
        
        for(Double d : history) {
            sum += d;
        }
        
        return sum;
    }
    
    public double greatestFluctuation()  {
        
        if(history.size() < 2) {
            return 0.0;
        }
        
        double fluctuation = 0.0;
        
        for(int i=0; i<history.size()-1; i++) {
            double currentFluctuation = Math.abs(history.get(i) - history.get(i+1));
            if(currentFluctuation > fluctuation) {
                fluctuation = currentFluctuation;
            }
        }
        
        return fluctuation;
    }
    
    public double variance() {
        
        if(history.size() < 2) {
            return 0.0;
        }
        
        double average = average();
        double variance = 0.0;
        
        for(Double d : history) {
            variance += (average - d)*(average - d);
        }
        
        return variance/(history.size() - 1); 
    }

    @Override
    public String toString() {
        return history.toString();
    }
}
