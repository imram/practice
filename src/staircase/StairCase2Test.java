package staircase;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class StairCase2Test {
    @Test
    public void test() {
        Assert.assertThat( stairCase( 1, 1 ), is( "#" ) );
        Assert.assertThat( stairCase( 2, 1 ), is( "##" ) );
        Assert.assertThat( stairCase( 3, 1 ), is( "###" ) );
        Assert.assertThat( stairCase( 2, 2 ), is( " #\n##" ) );
        Assert.assertThat( stairCase( 3, 3 ), is( "  #\n ##\n###" ) );
    }

    private String stairCase(int c, int r) {
        String steps = "";
        int lastIndex = r - 1;

        for (int rowIndex = 0; rowIndex < r; rowIndex++) {
            for (int columnIndex = 0; columnIndex < c; columnIndex++) {
                if (columnIndex < lastIndex - rowIndex) {
                    steps += " ";
                } else {
                    steps += "#";
                }
            }
            if (rowIndex != lastIndex)
                steps += "\n";
        }

        return steps;
    }
}
