/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author alinaalam
 */
public class Thermometer implements Sensor {

    private boolean state;
    
    public Thermometer() {
        state = false;
    }
    
    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public int measure() {
        if(!state) {
            throw new IllegalStateException("The thermometer is switched off");
        }
        Random rand = new Random();
        int min = -30;
        int max = 30;
        return rand.nextInt((max - min) + 1) + min;
    }
    
}
