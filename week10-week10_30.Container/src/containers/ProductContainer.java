/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author alinaalam
 */
public class ProductContainer extends Container {
    
    private String name;

    public ProductContainer(String name, double tilavuus) {
        super(tilavuus);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
}
