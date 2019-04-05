/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alinaalam
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors) {
            if(!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for(Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if(sensors.isEmpty()) {
            throw new IllegalStateException();
        }
        
        int sumOfMeasures = 0;
        
        for(Sensor sensor : sensors) {
            sumOfMeasures += sensor.measure();
        }
        
        int averageMeasure = sumOfMeasures/sensors.size();
        readings.add(averageMeasure);
        return averageMeasure;
    }
    
    public List<Integer> readings() {
        return readings;
    }
}
