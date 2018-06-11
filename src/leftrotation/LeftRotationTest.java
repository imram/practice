package leftrotation;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class LeftRotationTest {
    @Test
    public void test() {
        assertThat(leftRotation(1, new int[] {1}), CoreMatchers.is(new int[] {1}));
        assertThat(leftRotation(1, new int[] {1, 2}), CoreMatchers.is(new int[] {2, 1}));
        assertThat(leftRotation(1, new int[] {1, 2, 3}), CoreMatchers.is(new int[] {2, 3, 1}));
        assertThat(leftRotation(2, new int[] {1, 2, 3, 4}), CoreMatchers.is(new int[] {3, 4, 1, 2}));

    }

    private int[] leftRotation(int n, int... arr) {
        for (int rotate = 0; rotate < n; rotate++) {
            int firstElement = arr[0];
            int lastIndex = arr.length - 1;
            for (int index = 0; index < lastIndex; index++)
                arr[index] = arr[index + 1];
            arr[lastIndex] = firstElement;
        }
        return arr;
    }

}
