package minmax;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinMaxSumTest {

    @Test
    public void test() {
        assertThat( minMaxSum( 1 ), is( "0 0" ) );
        assertThat( minMaxSum( 2 ), is( "0 0" ) );
        assertThat( minMaxSum( 1, 1 ), is( "1 1" ) );
        assertThat( minMaxSum( 2, 1 ), is( "1 2" ) );
        assertThat( minMaxSum( 2, 1, 3 ), is( "3 5" ) );
        assertThat( minMaxSum( 1, 2, 3, 4, 5 ), is( "10 14" ) );

    }

    private String minMaxSum(long... arr) {
        long[] sums = new long[arr.length];

        for (int counter = 0; counter < arr.length; counter++)
            for (int index = 0; index < arr.length; index++)
                if (counter != index)
                    sums[counter] += arr[index];

        return formatedMinMax( sums );
    }

    private String formatedMinMax(long[] sums) {
        long min = sums[0];
        long max = sums[0];

        for (int index = 0; index < sums.length; index++) {
            if (sums[index] < min)
                min = sums[index];
            if (sums[index] > max)
                max = sums[index];
        }

        return String.format( "%d %d", min, max );
    }

}
