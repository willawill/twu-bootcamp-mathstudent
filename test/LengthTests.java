import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LengthTests {

    @Test
    public void shouldReturnZeroIfEqual(){
        Length length1 = new Length(1,36);
        Length length2 = new Length(1,36);

        int result = length1.compareTo(length2);

        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnMinusOneIfLess(){
        Length length1 = new Length(0,36);
        Length length2 = new Length(1,36);

        int result = length1.compareTo(length2);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldReturnOneIfMore(){
        Length length1 = new Length(2,36);
        Length length2 = new Length(1,36);

        int result = length1.compareTo(length2);

        assertThat(result, is(1));
    }
}
