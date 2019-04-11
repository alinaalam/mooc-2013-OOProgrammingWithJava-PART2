
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        if(this == null || obj == null) {
            return false;
        }
        Bird secondBird = (Bird) obj;
        
       return (this.latinName.equals(secondBird.latinName)) && 
               (this.ringingYear == secondBird.ringingYear);
    }

    @Override
    public int hashCode() {
        return this.latinName.hashCode() * this.ringingYear;
    }
}


