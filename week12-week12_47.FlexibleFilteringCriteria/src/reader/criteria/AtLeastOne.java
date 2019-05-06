/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author alinaalam
 */
public class AtLeastOne implements Criterion {
    
    private final Criterion[] criterias;

    public AtLeastOne(Criterion... criterias) {
        this.criterias = criterias;
    }

    @Override
    public boolean complies(String line) {
        for(Criterion criteria : criterias) {
            if(criteria.complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}
