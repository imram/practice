package reversearrays;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ReverseArrayTest {
    @Test
    public void test() {
        Assert.assertThat(reverseArray(1), is(new int[] {1}));
        Assert.assertThat(reverseArray(1, 2), is(new int[] {2, 1}));
        Assert.assertThat(reverseArray(1, 2, 3), is(new int[] {3, 2, 1}));
        Assert.assertThat(reverseArray(1, 2, 3, 4), is(new int[] {4, 3, 2, 1}));
    }

    private int[] reverseArray(int... a) {

        for (int firstIndex = 0, lastIndex = a.length - 1; firstIndex < lastIndex; firstIndex++, lastIndex--) {
            int temp = a[firstIndex];
            a[firstIndex] = a[lastIndex];
            a[lastIndex] = temp;
        }
        return a;
    }

}
