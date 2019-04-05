/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alinaalam
 */
public class WordInspection {

    private File file;
    private List<String> words;

    public WordInspection(File file) throws Exception {
        this.file = file;
        words = new ArrayList<String>();
        readFile();
    }

    public int wordCount() throws Exception {
        return words.size();
    }

    public List<String> wordsContainingZ() {
        List<String> wordsFound = new ArrayList<String>();

        for (String word : words) {
            if (word.contains("z")) {
                wordsFound.add(word);
            }
        }

        return wordsFound;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsFound = new ArrayList<String>();

        for (String word : words) {
            if (word.endsWith("l")) {
                wordsFound.add(word);
            }
        }

        return wordsFound;
    }

    public List<String> palindromes() {
        List<String> wordsFound = new ArrayList<String>();

        for (String word : words) {
            boolean isPalindrome = true;

            for (int i = 0; i <= (word.length() / 2); i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                wordsFound.add(word);
            }
        }

        return wordsFound;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsFound = new ArrayList<String>();

        for (String word : words) {
            // aeiouyäö
            if (word.contains("a") && word.contains("e")
                    && word.contains("i") && word.contains("o") && word.contains("u")
                    && word.contains("y") && word.contains("ä") && word.contains("ö")) {
                wordsFound.add(word);
            }
        }

        return wordsFound;
    }

    private void readFile() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        while (reader.hasNext()) {
            words.add(reader.next());
        }
    }
}
