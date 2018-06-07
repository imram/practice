package diagnoaldifference;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class DiagonalDifferenceTest {

    @Test
    public void givenMatrixOfSizeOne_returnsZero() {
        int a[][] = {{5}};
        Assert.assertThat( diagonalDiff( a ), is( 0 ) );
    }

    @Test
    public void givenMatrixOfSizeTwo_returnsDiagonalDifference() {
        int a[][] = {{5, 10}, {5, 20}};
        Assert.assertThat( diagonalDiff( a ), is( 10 ) );
    }

    @Test
    public void givenMatrixOfSizeThree_returnsDiagonalDifference() {
        int a[][] = {{5, 10, 15}, {20, 25, 30}, {35, 40, 45}};
        Assert.assertThat( diagonalDiff( a ), is( 0 ) );
    }

    private int diagonalDiff(int[][] a) {
        int sumOfLeftDiagonal = 0;
        int sumOfRightDiagonal = 0;

        for ( int rowIndex = 0, columnIndex = 0;rowIndex < a.length; rowIndex++, columnIndex++)
            sumOfLeftDiagonal += a[rowIndex][columnIndex];

        for (int rowIndex = 0, columnIndex = a.length - 1;rowIndex < a.length; rowIndex++, columnIndex--)
            sumOfRightDiagonal += a[rowIndex][columnIndex];

        return Math.abs( sumOfLeftDiagonal - sumOfRightDiagonal );
    }
}
