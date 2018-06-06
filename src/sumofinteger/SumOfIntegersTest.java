package sumofinteger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SumOfIntegersTest {

    @Test
    public void sumOfIntegers() {
        assertThat( sumOf( 0 ), is( 0 ) );
        assertThat( sumOf( 1 ), is( 1 ) );
        assertThat( sumOf( 1, 2 ), is( 3 ) );
        assertThat( sumOf( 1, 2, 3 ), is( 6 ) );
    }

    private int sumOf(Integer... n) {
        int sum = 0;
        for (int index = 0; n.length > index; index++)
            sum += n[index];
        return sum;
    }
}
