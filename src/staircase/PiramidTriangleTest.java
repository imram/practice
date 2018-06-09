package staircase;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class PiramidTriangleTest {
    @Test
    public void test() {
        Assert.assertThat( piramidTriangle( 1, 1 ), is( "#" ) );
        Assert.assertThat( piramidTriangle( 3, 2 ), is( " # \n###" ) );
    }

    private String piramidTriangle(int c, int r) {
        String piramid = "";
        if (c == 1 && r == 1) {
            return "#";
        }
        int lastRowIndex = r - 1;
        for (int rowIndex = 0; rowIndex < r; rowIndex++) {
            int columnIndex = 0;
            int firstHalfColumn = (c + 1) / 2;
            for (; columnIndex < firstHalfColumn; columnIndex++) {
                if (rowIndex < firstHalfColumn - 1 - columnIndex) {
                    piramid += " ";
                } else {
                    piramid += "#";
                }

            }
            columnIndex--;
            for (; columnIndex < c; columnIndex++) {
                if (rowIndex >= columnIndex) {
                    piramid += "#";
                }

            }
            if (rowIndex != lastRowIndex)
                piramid += "\n";
        }
        return piramid;
    }
}
