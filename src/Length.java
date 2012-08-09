
public class Length {

    private double feet;
    private double inches;


    public Length(double feet, double inches) {
        this.feet = feet;
        this.inches = inches;
    }

    public int compareTo(Length other) {
        if(this.lengthInInches() > other.lengthInInches()) return 1;
        if(this.lengthInInches() < other.lengthInInches()) return -1;
        return 0;
    }

    private double lengthInInches(){
        return this.feet*12 + this.inches;
    }
}
