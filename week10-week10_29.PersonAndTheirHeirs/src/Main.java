
import java.util.List;
import people.Person;
import people.Student;



public class Main {

    public static void main(String[] args) {
        // test your code here
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());
    }
    
    public static void printDepartment(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }
}
