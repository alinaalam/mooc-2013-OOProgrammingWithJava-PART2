/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alinaalam
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> storage;
    private int duplicates;

    public PersonalDuplicateRemover() {
        storage = new HashSet<String>();
    }
            
    @Override
    public void add(String characterString) {
        if(storage.contains(characterString)) {
            duplicates++;
            return;
        }
        storage.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return storage;
    }

    @Override
    public void empty() {
        storage.clear();
        duplicates = 0;
    }
    
}
