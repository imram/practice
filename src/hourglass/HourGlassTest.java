package hourglass;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created by ramgupta on 6/19/18.
 */
public class HourGlassTest {

    @Test
    public void verifyOneHourGlassReturnsItsSumValueAsHighestValue() {
        assertThat(hourglassSum(new int[][]{{0, 0, 0},{0, 0, 0},{0, 0, 0}}), is(0));
        assertThat(hourglassSum(new int[][]{{1, 1, 0},{0, 0, 0},{0, 0, 0}}), is(2));
        assertThat(hourglassSum(new int[][]{{1, 1, 1},{0, 0, 0},{0, 0, 0}}), is(3));
        assertThat(hourglassSum(new int[][]{{1, 0, 0},{1, 0, 0},{0, 0, 0}}), is(1));
        assertThat(hourglassSum(new int[][]{{1, 1, 1},{2, 1, 2},{1, 1, 1}}), is(7));
    }

    @Test
    public void givenTwoHourGlassVerticallyReturnsHighestSum() {
        assertThat(hourglassSum(new int[][]{{0, 0, 0, 1}, {0, 0, 0, 0},{0, 0, 0, 0}}), is(1));
        assertThat(hourglassSum(new int[][]{{1, 1, 1, 2}, {1, 1, 1, 1},{1, 1, 1, 2}}), is(9));
    }

    @Test
    public void givenTwoHourGlassHorizontallyReturnsHighestSum() {
        assertThat(hourglassSum(new int[][]{{0, 0, 0}, {0, 0, 0},{0, 0, 0}, {0, 0, 1}}), is(1));
    }

    @Test
    public void integration() {
        assertThat(hourglassSum(new int[][]{{-9, -9, -9,  1, 1, 1},
                {0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                {0,  0,  8,  6, 6, 0},
                {0,  0,  0, -2, 0, 0},
                {0,  0,  1,  2, 4, 0}}), is(28));
    }

    private int hourglassSum(int[][] arr) {

        int max = Integer.MIN_VALUE;

        for (int rowInit = 0;rowInit < arr.length -2;rowInit++)
            for (int columnInit = 0; columnInit < arr[0].length - 2; columnInit++) {
                int glassSum = getGlassSum(arr, rowInit, columnInit);
                System.out.println(glassSum);
                max = glassSum > max ? glassSum : max;
            }

            return max;
    }

    private int getGlassSum(int[][] ints, int rowInit, int columnInit) {
        int sum = 0;

        for (int row = rowInit;row < rowInit + 3; row++)
            for (int column = columnInit; column < columnInit + 3; column++)
                if (row != rowInit + 1 || (columnInit - column) % 2 != 0)
                    sum += ints[row][column];

        return sum;
    }

}
