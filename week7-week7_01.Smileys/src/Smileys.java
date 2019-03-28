
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("87.");
         printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        characterString = appendSpacesIfRequired(characterString);
        
        printTopAndBottomRows(characterString);
        System.out.println(":) " + characterString + " :)");
        printTopAndBottomRows(characterString);
    }
    
    private static void printSmileyRows(int length) {
        for(int i=1; i<=length; i++) {
            System.out.print(":)");
        }
    }
    
    private static String appendSpacesIfRequired(String characterString) {
        if(characterString.length()%2 != 0) {
            characterString += " ";
        }
        return characterString;
    }
    
    private static void printTopAndBottomRows(String characterString) {
        int smileysToAdd = characterString.length()/2;
        printSmileyRows(4 + (smileysToAdd) -1);
        System.out.println("");
    }
}
