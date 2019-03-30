/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
import java.util.*;

public class VehicleRegister {

    private Map<RegistrationPlate, String> owners;

    public VehicleRegister() {
        owners = new HashMap();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (!owners.containsKey(plate)) {
            owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        return owners.getOrDefault(plate, null);
    }
    
    public boolean delete(RegistrationPlate plate) {
        if(owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        }
        return false;
    }
    
    public void printRegistrationPlates() {
        for(RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownersUsed = new ArrayList();
        for(RegistrationPlate plate : owners.keySet()) {
            if(!ownersUsed.contains(owners.get(plate))) {
                System.out.println(owners.get(plate));
                ownersUsed.add(owners.get(plate));
            }
        }
    }
}
