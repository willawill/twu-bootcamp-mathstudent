import com.twu.whatever.Volume;
import com.twu.whatever.VolumeUnit;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class VolumeTests {

    @Test
    public void shouldGet0IfVolumesEqual(){
        Volume volumeInLiter=new Volume(3.78, VolumeUnit.LITER);
        Volume volumeInGallon=new Volume(1,VolumeUnit.GALLON);

        int result=volumeInGallon.compareTemperature(volumeInLiter);

        assertThat(result,is(0));
    }

    @Test
    public void shouldGetMinus1IfVolume1IsLesserThanVolume2(){
        Volume volumeInLiter=new Volume(1, VolumeUnit.LITER);
        Volume volumeInGallon=new Volume(1,VolumeUnit.GALLON);

        int result=volumeInLiter.compareTemperature(volumeInGallon);

        assertThat(result,is(-1));
    }

    @Test
    public void shouldGet1IfVolume1IsGreaterThanVolume2(){
        Volume volumeInLiter=new Volume(5.78, VolumeUnit.LITER);
        Volume volumeInGallon=new Volume(1,VolumeUnit.GALLON);

        int result=volumeInLiter.compareTemperature(volumeInGallon);

        assertThat(result,is(1));
    }

    @Test
    public void shouldBeAbleToAddVolumeInAnyUnit(){
        Volume volumeInGallon = new Volume(1, VolumeUnit.GALLON);
        Volume volumeInLiter = new Volume(1, VolumeUnit.LITER);

        Volume result = volumeInLiter.add(volumeInGallon);
        assertEquals(0, result.compareTemperature(new Volume((1 * 3.78) + 1 * 1, VolumeUnit.LITER)));


    }
}
