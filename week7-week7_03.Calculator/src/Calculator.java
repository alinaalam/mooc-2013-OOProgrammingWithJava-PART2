/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Calculator {

    private Reader reader;
    private int statistics;
    
    Calculator() {
        reader = new Reader();
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("sum")) {
                sum();
                statistics++;
            } else if (command.equals("difference")) {
                difference();
                statistics++;
            } else if (command.equals("product")) {
                product();
                statistics++;
            }
        }

        statistics();
    }
    
    private void sum() {
        int[] values = getValues();
        System.out.println("sum of the values " + (values[0]+values[1]));
    }
    
    private void difference() {
        int[] values = getValues();
        System.out.println("difference of the values " + (values[0]-values[1]));
    }
    
    private void product() {
        int[] values = getValues();
        System.out.println("products of the values " + (values[0]*values[1]));
    }
    
    private int[] getValues() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        return new int[] {value1, value2};
    }
    
    private void statistics() {
        System.out.println("Calculations done " + statistics);
    }
}
