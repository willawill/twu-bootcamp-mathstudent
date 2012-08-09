
public class Probability {

    private final double value;
    private static final int MAX_VALUE = 1;
    private static final double EPSILON = 0.00000001;

    public Probability(double value){
        if(value > 1 || value < 0)
            throw new IllegalArgumentException("Probability has to be between 0 and 1");
        this.value = value;
    }

    public Probability(int eventPoints, int sampleSpacePoints) {
        if(sampleSpacePoints == 0)  throw new IllegalArgumentException("Sample Space Points cannot be zero");

        if(eventPoints<0 || sampleSpacePoints<0)
            throw new IllegalArgumentException("Number of occurences has to be positive");

        this.value = (double)eventPoints/sampleSpacePoints;
    }

    public Probability inverse() {
        return new Probability(MAX_VALUE-value);
    }

    public Probability and(Probability other) {
        return new Probability(this.value * other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if(Math.abs(this.value - that.value) > EPSILON) return false;
        return true;
    }

    @Override
    public int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }

    public Probability or(Probability other) {
        //return new Probability(value + other.value - this.and(other).value);
        Probability probability = this.inverse().and(other.inverse());
        return probability.inverse();
    }

}
