import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LengthComparatorTests {

    @Test
    public void shouldReturnZeroWhenEqualLength(){
        double lengthInFeet = 1;
        double lengthInInches = 12;
        LengthComparator comparator = new LengthComparator();

        int result = comparator.compareFeetToInches(lengthInFeet, lengthInInches);

        assertThat(result, is(0));

    }

    @Test
    public void shouldReturnMinusOne_WhenLengthInFeetLessThan_LengthInInches(){
        double lengthInFeet = 1;
        double lengthInInches = 15;
        LengthComparator comparator = new LengthComparator();

        int result = comparator.compareFeetToInches(lengthInFeet, lengthInInches);

        assertThat(result, is(-1));

    }

    @Test
    public void shouldReturnOne_WhenLengthInFeetMoreThan_LengthInInches(){
        double lengthInFeet = 2;
        double lengthInInches = 15;
        LengthComparator comparator = new LengthComparator();

        int result = comparator.compareFeetToInches(lengthInFeet, lengthInInches);

        assertThat(result, is(1));

    }
}
