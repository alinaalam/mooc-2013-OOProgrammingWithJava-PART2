/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Flight {
    private Airplane plane;
    private String departureCode;
    private String destinationCode;
    
    Flight(Airplane plane, String departureCode, String destinationCode) {
        this.plane = plane;
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }

    @Override
    public String toString() {
        return plane.getId() + " (" + plane.getCapacity() + " ppl) "
                + "(" + departureCode + "-" + destinationCode + ")";
    }
}
