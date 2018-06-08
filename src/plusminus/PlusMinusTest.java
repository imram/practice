package plusminus;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class PlusMinusTest {
    @Test
    public void givenEmptyArray_ReturnsEmptyArray() {
        int[] a = {};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {0.0, 0.0, 0.0} ) );
    }

    @Test
    public void givenArraymWithOneZero_ReturnsArrayWithResultDecimal() {
        int[] a = {0};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {0.0, 0.0, 1.0} ) );
    }

    @Test
    public void givenArraymWithATwoZeros_ReturnsArrayWithZeros() {
        int[] a = {0, 0};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {0.0, 0.0, 1.0} ) );
    }

    @Test
    public void givenArraymWithAPositiveNumber_ReturnsArrayWithResultDecimal() {
        int[] a = {1};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {1.0, 0.0, 0.0} ) );
    }

    @Test
    public void givenArraymWithANegativeNumber_ReturnsArrayWithResultDecimal() {
        int[] a = {-1};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {0.0, 1.0, 0.0} ) );
    }

    @Test
    public void integration() {
        int[] a = {-1, 2, 3, 5, -7, 0, 3, -3, 0};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {4.0d / 9, 3.0d / 9, 2.0d / 9} ) );
    }

/*    @Test
    public void integration1() {
        int[] a = {-4, 3, -9, 0, 4, 1};
        Assert.assertThat( fractionNumbers( a ), is( new double[] {0.500000, 0.333333, 0.166667} ) );
    }*/

    private double[] fractionNumbers(int... arr) {

        if (arr.length == 0) {
            return new double[] {0.0, 0.0, 0.0};
        }

        int zeroCounter = 0;
        int positiveCounter = 0;
        int negativeCounter = 0;

        for (int index = 0; index < arr.length; index++)
            if (arr[index] == 0)
                zeroCounter++;
            else if (arr[index] > 0)
                positiveCounter++;
            else
                negativeCounter++;

        return new double[] {(double) positiveCounter / arr.length, (double) negativeCounter / arr.length, (double) zeroCounter / arr.length};
    }

    static void plusMinus(int[] arr) {
        if (arr.length == 0) {
            System.out.println( "0 \n 0\n 0" );
        }

        int zeroCounter = 0;
        int positiveCounter = 0;
        int negativeCounter = 0;

        for (int index = 0; index < arr.length; index++)
            if (arr[index] == 0)
                zeroCounter++;
            else if (arr[index] > 0)
                positiveCounter++;
            else
                negativeCounter++;

        System.out.println( String.format( "%.6f\n%.6f\n%.6f", (double) positiveCounter / arr.length, (double) negativeCounter / arr.length, (double) zeroCounter / arr.length ) );

    }

    public static void main(String[] args) {
        plusMinus( new int[] {1} );
    }
}

