package birthdaycandles;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BirthDayCandlesTest {
    @Test
    public void countBlownCandels() {
        assertThat( birthDayCandles( 1 ), is( 1 ) );
        assertThat( birthDayCandles( 1, 1 ), is( 2 ) );
        assertThat( birthDayCandles( 1, 2 ), is( 1 ) );
        assertThat( birthDayCandles( 2, 1 ), is( 1 ) );
        assertThat( birthDayCandles( 2, 1 ), is( 1 ) );
        assertThat( birthDayCandles( 1, 1, 1 ), is( 3 ) );
        assertThat( birthDayCandles( 1, 2, 1 ), is( 1 ) );
        assertThat( birthDayCandles( 3, 2, 1, 3 ), is( 2 ) );
    }

    private int birthDayCandles(int... ar) {
        int largestCount = 1;
        int largestHeight = ar[0];

        for (int index = 1; index < ar.length; index++) {
            if (largestHeight < ar[index]) {
                largestHeight = ar[index];
                largestCount = 1;
            } else if (largestHeight == ar[index]) {
                largestCount++;
            }
        }
        return largestCount;
    }
}
