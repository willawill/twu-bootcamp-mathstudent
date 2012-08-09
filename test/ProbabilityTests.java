import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProbabilityTests {

    @Test
    public void shouldReturnProbabilityOfGetting3WhenRollingDie() {
        Probability chanceOfGetting3 = new Probability(1,6);
        Probability expectedChanceOfGetting3 = new Probability(1/6d);

        assertEquals(expectedChanceOfGetting3, chanceOfGetting3);
    }

    @Test
    public void shouldReturnProbabilityOfNotGetting3WhenRollingDie(){
        Probability chanceOfGetting3 = new Probability(1,6);
        Probability chanceOfNotGetting3 = chanceOfGetting3.inverse();

        Probability expectedChanceOfNotGetting3 = new Probability(5/6d);

        assertEquals(expectedChanceOfNotGetting3, chanceOfNotGetting3);
    }

    @Test
    public void shouldEquateTwoProbabilitiesWithSameValue()
    {
        Probability probability1 = new Probability(1,4);
        Probability probability2 = new Probability(1,4);

        Assert.assertEquals(probability1, probability2);
    }

    @Test
    public void shouldBeAbleToCombineWithOtherProbability(){
        Probability chanceOfGetting1 = new Probability(1,6);
        Probability chanceOfGetting6 = new Probability(1,6);

        Probability result = chanceOfGetting1.and(chanceOfGetting6);

        Assert.assertEquals(result, new Probability(1/36d));
    }

    @Test
    public void shouldBeAbleToComputeORProbability()
    {
        //Given
        Probability probabilityOfGettingOne=new Probability(1,6);
        Probability probabilityOfGettingSix=new Probability(1,6);
        //When
        Probability result=probabilityOfGettingOne.or(probabilityOfGettingSix);
        //Then
        Assert.assertEquals(result, new Probability(11/36d));
    }

    @Test(expected = Exception.class)
    public void shouldThrowErrorIfProbabilityIsLargerThanOne() {
        Probability probability = new Probability(2);
    }

    @Test(expected = Exception.class)
    public void shouldThrowErrorIfProbabilityIsNegative() {
        Probability probability = new Probability(-0.5);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfSamplePointsIsZero(){
        Probability probability = new Probability(1,0);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenEventPointsAreNegative(){
        Probability probability = new Probability(-1, 6);
    }

}
