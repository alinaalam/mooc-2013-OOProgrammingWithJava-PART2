package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if(weight < 0 ) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false; 
        }
        Thing anotherThing = (Thing) obj;
        return name.equals(anotherThing.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
