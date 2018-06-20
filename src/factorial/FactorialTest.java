package factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ramgupta on 6/15/18.
 */
public class FactorialTest {
    @Test
    public void getFactorial() {
        assertThat(factorial(0), is(1));
        assertThat(factorial(1), is(1));
        assertThat(factorial(2), is(2*1));
        assertThat(factorial(3), is(3*2*1));
    }

    private int factorial(int n) {
        if(n == 0 || n ==1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
