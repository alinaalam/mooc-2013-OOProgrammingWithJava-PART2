
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alinaalam
 */
public class Printer {
    
    private File file;

    public Printer(String fileName) throws Exception {
        file = new File(fileName);
    }
    
    public void printLinesWhichContain(String word) throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        while(reader.hasNext()) {
            String currentLine = reader.nextLine();
            if(word.isEmpty() || currentLine.contains(word)) {
                System.out.println(currentLine);
            }
        }
    }
}
