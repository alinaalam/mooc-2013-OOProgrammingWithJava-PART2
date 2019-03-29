/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */

import java.util.Map;
import java.util.HashMap;

public class PromissoryNote {
    private Map<String, Double> loans;
    
    public PromissoryNote() {
        loans = new HashMap();
    }
    
    public void setLoan(String toWhom, double value) {
        loans.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        return loans.getOrDefault(whose, 0.0);
    }
}
