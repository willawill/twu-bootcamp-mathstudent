import com.twu.whatever.Celcius;
import com.twu.whatever.Fahrenheit;
import com.twu.whatever.Temperature;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TemperatureTest {

    @Test
    public void shouldBeAbleToCompareTemperatures() {

        Temperature temperatureInF = new Fahrenheit(212);
        Temperature temperatureInC = new Celcius(100);

        int result = temperatureInF.compareTemperature(temperatureInC);

        assertThat(result, is(0));


    }

    @Test
    public void shouldGet1If100CGreaterThan200F() {
        Temperature temperatureInF = new Fahrenheit(200);
        Temperature temperatureInC = new Celcius(100);

        int result = temperatureInC.compareTemperature(temperatureInF);

        assertThat(result, is(1));
    }

    @Test
    public void shouldBeAbleToConvertFtoC() {
        Fahrenheit temperatureInF = new Fahrenheit(212);

        Celcius result = temperatureInF.convertToCelcius();

        assertThat(result, is(new Celcius(100d)));
    }

    @Test

    public void shouldBeAbleToAddAnyTemperatureInCelcius() {
        Temperature temperatureInF = new Fahrenheit(212);
        Temperature temperatureInC = new Celcius(100);

        Temperature result = (Temperature) temperatureInF.add(temperatureInC, Celcius.class);

        assertThat(result, is((Temperature) new Celcius(200)));
    }

    @Test
    public void shouldBeAbleToAddTwoTemperaturesInFahrenheit() {
        Temperature temperatureInF = new Fahrenheit(32);
        Temperature temperatureInC = new Celcius(0);

        Temperature result = (Temperature) temperatureInF.add(temperatureInC, Fahrenheit.class);

        assertThat(result, is((Temperature) new Fahrenheit(64)));
    }


}
