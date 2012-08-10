import com.twu.whatever.Length;
import com.twu.whatever.LengthUnit;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LengthTests {

    @Test
    public void shouldGet0IfLengthsEqual(){
        Length lengthInFeet = new Length(1, LengthUnit.FEET);
        Length lengthInInches = new Length(12,LengthUnit.INCH);

        int result = lengthInFeet.compare(lengthInInches);

        assertThat(result, is(0));
    }

    @Test
    public void shouldGet1IfLength1GreaterThanLength2(){
        Length lengthInCm = new Length(5, LengthUnit.CENTIMETER);
        Length lengthInInches = new Length(1,LengthUnit.INCH);

        int result = lengthInCm.compare(lengthInInches);

        assertThat(result, is(1));

    }

    @Test
    public void shouldGetMinus1IfLength1LessThanLength2(){
        Length lengthInCm = new Length(1, LengthUnit.CENTIMETER);
        Length lengthInMm = new Length(15,LengthUnit.MILLIMETER);

        int result = lengthInCm.compare(lengthInMm);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldBeAbleToAddTwoLengths(){
        Length length1 = new Length(2, LengthUnit.INCH);
        Length length2 = new Length(2, LengthUnit.INCH);

        Length result = length1.add(length2);

        assertEquals(0, result.compare(new Length(4, LengthUnit.INCH)));
    }

    @Test
    public void shouldBeAbleToAddDifferentUnits(){
        Length lengthInInch=new Length(2,LengthUnit.INCH);
        Length lengthInCentimeter=new Length(2.5,LengthUnit.CENTIMETER);

        Length result=lengthInInch.add(lengthInCentimeter);

        assertEquals(0, result.compare(new Length(3, LengthUnit.INCH)));
    }


}
