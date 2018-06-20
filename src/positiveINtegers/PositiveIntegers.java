package positiveINtegers;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ramgupta on 6/15/18.
 */
public class PositiveIntegers {
    @Test
    public void sumArrays() {
        assertThat(sumOf(null), is(0));
        assertThat(sumOf(new int[]{}), is(0));
        assertThat(sumOf(new int[]{0}), is(0));
        assertThat(sumOf(new int[]{1}), is(1));
        assertThat(sumOf(new int[]{-1}), is(0));
        assertThat(sumOf(new int[]{-1, 1}), is(1));
        assertThat(sumOf(new int[]{-1, 1, 2}), is(3));
        assertThat(sumOf(new int[]{-1, 1, 2, 3, 4, -3}), is(10));
    }

    private int sumOf(int... arr) {
        if(arr == null || arr.length ==0) {
            return 0;
        }
        return sum(0, arr);
    }

    public int sum(int index, int... arr) {
        if(index == arr.length) {
            return 0;
        }
        return (arr[index] > 0 ? arr[index] : 0  )+ sum(index + 1, arr);
    }
}
