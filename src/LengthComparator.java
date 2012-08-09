
public class LengthComparator {
    private static final int FEET_TO_INCHES = 12;

    public int compareFeetToInches(double lengthInFeet, double lengthInInches) {
        double convertedLength = lengthInFeet * FEET_TO_INCHES;

        if(convertedLength >lengthInInches) return 1;
        if(convertedLength <lengthInInches) return -1;
        return 0;
    }
}
