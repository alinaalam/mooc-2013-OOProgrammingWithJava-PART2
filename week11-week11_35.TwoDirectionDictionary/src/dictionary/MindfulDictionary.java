/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class MindfulDictionary {

    private Map<String, String> dictionary;
    private File file;

    public MindfulDictionary() {
        dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this();
        this.file = new File(file);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String[] currentLine = reader.nextLine().split(":");
                if (currentLine.length > 1) {
                    dictionary.put(currentLine[0], currentLine[1]);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
        }
    }

    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        if (dictionary.containsValue(word)) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
        }
        if (dictionary.containsValue(word)) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(word)) {
                    dictionary.remove(entry.getKey());
                    break;
                }
            }
        }
    }

    public boolean save() {
        try {
            FileWriter fw = new FileWriter(file);
            
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                fw.write(entry.getKey() + ":" + entry.getValue());
                fw.write("\n");
            }
            
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
