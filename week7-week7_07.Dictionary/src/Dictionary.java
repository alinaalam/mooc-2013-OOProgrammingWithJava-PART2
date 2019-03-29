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
import java.util.ArrayList;

public class Dictionary {
    
    private Map<String, String> dictionary;
    
    public Dictionary() {
        dictionary = new HashMap();
    }
    
    public String translate(String word) {
        return dictionary.get(word);
    }
    
    public void add(String word, String translation) {
        dictionary.put(word, translation);
    }
    
    public int amountOfWords() {
        return dictionary.keySet().size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList();
        for(String word : dictionary.keySet()) {
            translations.add(word + " = " + dictionary.get(word));
        }
        return translations;
    }
}
