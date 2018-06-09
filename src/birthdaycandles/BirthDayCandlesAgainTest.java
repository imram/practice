package birthdaycandles;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BirthDayCandlesAgainTest {
    @Test
    public void test() {
        assertThat( blownCandles( 1 ), is( 1 ) );
        assertThat( blownCandles( 1, 2 ), is( 1 ) );
        assertThat( blownCandles( 2, 2 ), is( 2 ) );
        assertThat( blownCandles( 2, 2, 2 ), is( 3 ) );
        assertThat( blownCandles( 2, 2, 2, 3, 1, 5, 7, 3, 7 ), is( 2 ) );
    }

    private int blownCandles(int... ar) {
        int count = 1;
        int largestHeight = ar[0];

        for (int index = 1; index < ar.length; index++) {
            if (ar[index] > largestHeight) {
                largestHeight = ar[index];
                count = 1;
            } else if (ar[index] == largestHeight) {
                count++;
            }
        }
        return count;
    }
}
