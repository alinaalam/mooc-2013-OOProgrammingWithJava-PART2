
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        
        if(getClass() != obj.getClass()) {
            return false;
        }
        
        RegistrationPlate registrationPlate = (RegistrationPlate) obj;
        
        if(regCode == null || country == null) {
            return false;
        }
        
        return regCode.equals(registrationPlate.regCode) && country.equals(registrationPlate.country);
    }

    @Override
    public int hashCode() {
        return this.regCode.hashCode() + this.country.hashCode();
    }
}
