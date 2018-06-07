package tripletcomparision;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TripletComparisionTest {
    @Test
    public void givenAPointsZerosAndBPointsZero_ReturnsOneOne() {
        int a[] = {0, 0, 0};
        int b[] = {0, 0, 0};

        assertThat( compare( a, b ), is( "0 0" ) );
    }

    @Test
    public void givenAPoints1WithZerosBPointsZeros_returnsOneZero() {
        int a[] = {1, 0, 0};
        int b[] = {0, 0, 0};

        assertThat( compare( a, b ), is( "1 0" ) );
    }

    @Test
    public void givenAPoints1sWithZeroBPointsZeros_returnsOneZero() {
        int a[] = {1, 1, 0};
        int b[] = {0, 0, 0};

        assertThat( compare( a, b ), is( "2 0" ) );
    }

    @Test
    public void givenAPoints1sWithZeroBPointsOnesWithZero_returnsOneOne() {
        int a[] = {8, 91, 20};
        int b[] = {10, 50, 20};

        assertThat( compare( a, b ), is( "1 1" ) );
    }

    private String compare(int[] a, int[] b) {
        int aNo = 0;
        int bNo = 0;
        int index = 0;
        while (index < a.length) {
            if (a[index] > b[index]) {
                aNo++;
            } else if (a[index] < b[index]) {
                bNo++;
            }
            index++;
        }

        return String.format( "%d %d", aNo, bNo );
    }
}
