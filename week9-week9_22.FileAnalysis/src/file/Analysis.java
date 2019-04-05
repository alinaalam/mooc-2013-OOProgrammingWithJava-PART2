/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class Analysis {
    
    private File file;

    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws Exception {
        Scanner reader = new Scanner(file);
        int numOfLines = 0;
        
        while(reader.hasNext()) {
            reader.nextLine();
            numOfLines++;
        }
        
        return numOfLines;
    }
    
    public int characters() throws Exception {
        Scanner reader = new Scanner(file);
        int numOfCharacters = 0;
        
        while(reader.hasNext()) {
            numOfCharacters += reader.nextLine().length();
            numOfCharacters++; // for the line breaks
        }
        
        return numOfCharacters;
    }
}
