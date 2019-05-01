
public class Main {

    public static void main(String[] args) {
        // write test code here
        System.out.println(clockTime("23:41:16"));
    }
    
    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public static boolean allVowels(String string) {
        return string.matches("[aeiouäö]+");
    }
    
    public static boolean clockTime(String string) {
        if(string.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")) {
            String[] timeSlots = string.split(":");
            if(timeSlots.length == 3) {
                return Integer.parseInt(timeSlots[0]) < 24 && 
                        Integer.parseInt(timeSlots[1]) < 60 &&
                        Integer.parseInt(timeSlots[2]) < 60;
            }
        }
        return false;
    }
}
